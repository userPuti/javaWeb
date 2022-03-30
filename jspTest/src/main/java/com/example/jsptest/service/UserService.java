package com.example.jsptest.service;

import com.example.jsptest.pojo.User;

import java.util.List;

/**
 * @author puti
 * @date 2022/3/18
 */
public interface UserService {
    /**
     * 登录
     *
     * @param user 传入User对象
     * @return 返回User对象
     */
    public User login(User user);

    /**
     * 展示所有的用户信息
     *
     * @return List<User>
     */
    public String userInfoDisplay();

    /**
     * 新增用户信息
     *
     * @param user user对象
     * @return 影响的行数
     */
    public String insertUser(User user);

    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return User对象
     */
    public String queryUserByYhid(String username);

    /**
     * 根据用户部门查询用户
     *
     * @param yhbm 用户部门
     * @return List<User>对象
     */
    public String queryUserByYhbm(String yhbm);

    /**
     * 根据用户id和用户部门查询用户
     *
     * @param yhid 用户id
     * @param yhbm 用户部门
     * @return User对象
     */
    public String queryUserByYhidAndYhbm(String yhid, String yhbm);

    /**
     * 根据用户id删除用户信息
     *
     * @param yhid 用户id
     * @return 影响的行数
     */
    public int deleteUserInfo(String yhid);


    /**
     * 更新用户信息
     *
     * @param user user对象
     * @return 影响的行数
     */
    public int updateUserInfo(User user);
}
