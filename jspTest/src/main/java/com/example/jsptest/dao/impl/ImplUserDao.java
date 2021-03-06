package com.example.jsptest.dao.impl;

import com.example.jsptest.dao.BaseDao;
import com.example.jsptest.dao.UserDao;
import com.example.jsptest.pojo.User;

import java.util.List;

/**
 * @author puti
 * @date 2022/3/18
 */
public class ImplUserDao extends BaseDao implements UserDao {
    @Override
    public User queryUserByYhidAndYhkl(String yhid, String yhkl) {
        String sql = "select * from t_user where yhid = ? and yhkl = ?";
        return (User) queryForOne(User.class, sql, yhid, yhkl);
    }

    @Override
    public List<User> queryAllUser(int sta, int lim, String yhid, String yhbm) {
        String sql = "select * from t_user ";
        if(!"".equals(yhid)){
            sql += " and yhid like ?";
        }
        if(!"".equals(yhbm)){
            sql += " and yhbm = ?";
        }
        sql += " limit ? , ?";
        sql.replaceFirst("and","where");
        return queryForList(User.class, sql, sta, lim);
    }

    @Override
    public int insertUser(User user) {
        String sql = "insert into t_user values(?,?,?,?,?,?,?,?,?)";
        return update(sql, user.getYhid(), user.getYhxm(), user.getYhkl(), user.getYhxb(), user.getYhbm(), user.getCsrq(), user.getDjrq(), user.getSfjy(), user.getPxh());
    }

    /**
     * 根据用户名查询用户
     *
     * @param yhid 用户名
     * @return User对象
     */
    @Override
    public List<User> queryUserByYhid(String yhid) {
        String sql = "select * from t_user where yhid = ?";
        return queryForList(User.class, sql, yhid);
    }

    /**
     * 根据用户部门查询用户
     *
     * @param yhbm 用户部门
     * @return List<User>对象
     */
    @Override
    public List<User> queryUserByYhbm(String yhbm, int sta, int lim) {
        String sql = "select * from t_user where yhbm = ? limit ?, ?";
        return queryForList(User.class, sql, yhbm, sta, lim);
    }

    /**
     * 根据用户id和用户部门查询用户
     *
     * @param yhid 用户id
     * @param yhbm 用户部门
     * @return User对象
     */
    @Override
    public List<User> queryUserByYhidAndYhbm(String yhid, String yhbm) {
        String sql = "select * from t_user where yhid = ? and yhbm = ?";
        return queryForList(User.class, sql, yhid, yhbm);
    }

    /**
     * 根据用户id删除用户信息
     *
     * @param yhid 用户id
     * @return 影响的行数
     */
    @Override
    public int deleteByYhid(String yhid) {
        String sql = "delete from t_user where yhid=?";
        return update(sql, yhid);
    }

    /**
     * 更新用户信息
     *
     * @param user user对象
     * @return 影响的行数
     */
    @Override
    public int updateUserInfo(User user) {
        String sql = "update t_user set yhxm= ?, yhkl=?,yhxb=?,yhbm=?,csrq=?,djrq=?,sfjy=?,pxh=? where yhid=?";
        return update(sql, user.getYhxm(), user.getYhkl(), user.getYhxb(), user.getYhbm(), user.getCsrq(), user.getDjrq(), user.getSfjy(), user.getPxh(), user.getYhid());
    }

    /**
     * 查询用户信息总量
     *
     * @return 数量
     */
    @Override
    public long countUser() {
        String sql = "select count(*) from t_user";
        return (long) queryForSingleValue(sql);
    }

    /**
     * 根据用户部门代码查询用户部门的人数
     *
     * @param yhbm 用户部门
     * @return 用户部门的人数
     */
    @Override
    public long countYhbmUser(String yhbm) {
        String sql = "select count(*) from t_user where yhbm = ?";
        return (long) queryForSingleValue(sql, yhbm);
    }
}
