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
    public List<User> queryAllUser() {
        String sql = "select * from t_user";
        return queryForList(User.class, sql);
    }

    @Override
    public int insertUser(User user) {
        String sql = "insert into t_user values(?,?,?,?,?,?,?,?,?,?)";
        return update(sql, user.getYhid(), user.getYhxm(), user.getYhkl(), user.getYhxb(), user.getYhbm(), user.getCsrq(), user.getDjsj(), user.getDjrq(), user.getSfjy(), user.getPxh());
    }

    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return User对象
     */
    @Override
    public User queryUserByUsername(String username) {
        String sql = "select * from t_user where yhid = ?";
        return (User) queryForOne(User.class, sql, username);
    }

    /**
     * 根据用户部门查询用户
     *
     * @param yhbm 用户部门
     * @return List<User>对象
     */
    @Override
    public List<User> queryUserByYhbm(String yhbm) {
        String sql = "select * from t_user where yhbm = ?";
        return queryForList(User.class, sql, yhbm);
    }

    /**
     * 根据用户id和用户部门查询用户
     *
     * @param yhid 用户id
     * @param yhbm 用户部门
     * @return User对象
     */
    @Override
    public User queryUserByYhidAndYhbm(String yhid, String yhbm) {
        String sql = "select * from t_user where yhid = ? and yhbm = ?";
        return (User) queryForOne(User.class, sql, yhid, yhbm);
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
}
