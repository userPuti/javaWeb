package com.example.jsptest.service.impl;

import com.example.jsptest.dao.UserDao;
import com.example.jsptest.dao.impl.ImplUserDao;
import com.example.jsptest.pojo.User;
import com.example.jsptest.service.UserService;

import java.util.List;
import java.util.Objects;

/**
 * @author puti
 * @date 2022/3/18
 */
public class ImplUserService implements UserService {

    private final UserDao userDao = new ImplUserDao();

    @Override
    public User login(User user) {
        return userDao.queryUserByYhidAndYhkl(user.getYhid(), user.getYhkl());
    }

    @Override
    public String userInfoDisplay() {

        List<User> list = userDao.queryAllUser();
        return userListXml(list);
    }

    @Override
    public String insertUser(User user) {
        String yhbm = user.getYhbm();
        String xb = user.getYhxb();
        String sfjy = user.getSfjy();

        if (Objects.equals(yhbm, "lat")) {
            user.setYhbm("32010001");
        } else if (Objects.equals(yhbm, "ywt")) {
            user.setYhbm("32010002");
        } else {
            user.setYhbm("32010003");
        }

        if (Objects.equals(xb, "male")) {
            user.setYhxb("09_00003-1");
        } else if (Objects.equals(xb, "female")) {
            user.setYhxb("09_00003-2");
        } else {
            user.setYhxb("09_00003-255");
        }

        if (Objects.equals(sfjy, "on")) {
            user.setSfjy("1");
        } else {
            user.setSfjy("0");
        }

        int rows = userDao.insertUser(user);

        String isSuccess = "";
        if (rows == 1) {
            System.out.println("添加成功");
            isSuccess = "success";
        } else {
            System.out.println("添加失败");
            isSuccess = "defeat";
        }

        return isSuccess;
    }

    /**
     * 根据用户名查询用户
     *
     * @param yhid 用户名
     * @return User对象
     */
    @Override
    public String queryUserByYhid(String yhid) {
        List<User> list = userDao.queryUserByYhid(yhid);
        return userListXml(list);
    }

    /**
     * 根据用户部门查询用户
     *
     * @param yhbm 用户部门
     * @return List<User>对象
     */
    @Override
    public String queryUserByYhbm(String yhbm) {
        List<User> users = userDao.queryUserByYhbm(yhbm);
        return userListXml(users);
    }

    /**
     * 根据用户id和用户部门查询用户
     *
     * @param yhid 用户id
     * @param yhbm 用户部门
     * @return User对象
     */
    @Override
    public String queryUserByYhidAndYhbm(String yhid, String yhbm) {
        List<User> users = userDao.queryUserByYhidAndYhbm(yhid, yhbm);
        return userListXml(users);
    }

    /**
     * 根据用户id删除用户信息
     *
     * @param yhid 用户id
     * @return 影响的行数
     */
    @Override
    public int deleteUserInfo(String yhid) {
        return userDao.deleteByYhid(yhid);
    }

    /**
     * 更新用户信息
     *
     * @param user user对象
     * @return 影响的行数
     */
    @Override
    public int updateUserInfo(User user) {
        return userDao.updateUserInfo(user);
    }

    /**
     * 查看用户的详细信息，用于弹窗
     *
     * @param yhid 用户的id
     * @return user对象
     */
    @Override
    public User viewUserInfo(String yhid) {
        List<User> users = userDao.queryUserByYhid(yhid);
        if (users.size() > 0) {
            return transferToRealInfo(users.get(0));
        }
        return null;
    }

    private String userListXml(List<User> list) {
        StringBuilder allUserxml = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
        if (list != null && list.size() > 0) {
            allUserxml.append("<rows>");
            allUserxml.append("<userdata name='totalnumber'>").append(list.size()).append("</userdata>");
            for (User user : list) {
                String yhbm = user.getYhbm();
                if (Objects.equals(yhbm, "32010001")) {
                    yhbm = "立案庭";
                } else if (Objects.equals(yhbm, "32010002")) {
                    yhbm = "业务庭";
                } else if (Objects.equals(yhbm, "32010003")) {
                    yhbm = "办公室";
                }

                String yhxb = user.getYhxb();

                if (Objects.equals(yhxb, "09_00003-1")) {
                    yhxb = "男";
                } else if (Objects.equals(yhxb, "09_00003-2")) {
                    yhxb = "女";
                } else if (Objects.equals(yhxb, "09_00003-255")) {
                    yhxb = "其他";
                }

                String sfjy = user.getSfjy();

                if (Objects.equals(sfjy, "1")) {
                    sfjy = "是";
                } else if (Objects.equals(sfjy, "0")) {
                    sfjy = "否";
                }

                allUserxml.append("<row>");
                allUserxml.append("<cell>0</cell>");
                allUserxml.append("<cell>").append(user.getYhid()).append("</cell>");
                allUserxml.append("<cell>").append(user.getYhxm()).append("</cell>");
                allUserxml.append("<cell>").append(yhxb).append("</cell>");
                allUserxml.append("<cell>").append(yhbm).append("</cell>");
                allUserxml.append("<cell>").append(user.getCsrq()).append("</cell>");
                allUserxml.append("<cell>").append(user.getDjrq()).append("</cell>");
                allUserxml.append("<cell>").append(sfjy).append("</cell>");
                allUserxml.append("<cell>").append(user.getPxh()).append("</cell>");
                allUserxml.append("<cell>").append("images/search.png^查看^javascript:view(\"").append(user.getYhid()).append("\")^_self").append("</cell>");
                allUserxml.append("<cell>").append("images/modify.png^修改^modifyUser.jsp^").append("</cell>");
                allUserxml.append("<cell>").append("images/delete.png^删除^deleteUser.jsp^").append("</cell>");
                allUserxml.append("</row>");
            }
            allUserxml.append("</rows>");
        } else {
            //没数据
            allUserxml.append("<rows><userdata name='totalnumber'>0</userdata></rows>");
        }
        return allUserxml.toString();
    }

    private User transferToRealInfo(User user) {
        String yhbm = user.getYhbm();

        if (Objects.equals(yhbm, "32010001")) {
            user.setYhbm("立案庭");
        } else if (Objects.equals(yhbm, "32010002")) {
            user.setYhbm("业务庭");
        } else if (Objects.equals(yhbm, "32010003")) {
            user.setYhbm("办公室");
        }

        String yhxb = user.getYhxb();

        if (Objects.equals(yhxb, "09_00003-1")) {
            user.setYhxb("男");
        } else if (Objects.equals(yhxb, "09_00003-2")) {
            user.setYhxb("女");
        } else if (Objects.equals(yhxb, "09_00003-255")) {
            user.setYhxb("其他");
        }

        String sfjy = user.getSfjy();

        if (Objects.equals(sfjy, "1")) {
            user.setSfjy("是");
        } else if (Objects.equals(sfjy, "0")) {
            user.setSfjy("否");
        }

        return user;
    }
}
