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
     * 根据用户名查询用户，显示在主页中
     *
     * @param username 用户名
     * @return xmlString
     */
    public String queryUserByYhid(String username);

    /**
     * 根据用户部门查询用户，显示在主页中
     *
     * @param yhbm 用户部门
     * @return xmlString
     */
    public String queryUserByYhbm(String yhbm);

    /**
     * 根据用户id和用户部门查询用户，显示在主页
     *
     * @param yhid 用户id
     * @param yhbm 用户部门
     * @return xmlString
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
    public boolean updateUserInfo(User user);

    /**
     * 查看用户的详细信息，用于弹窗
     *
     * @param yhid 用户的id
     * @return user对象
     */
    public User viewUserInfo(String yhid);


    /**
     * 批量删除用户信息
     *
     * @param del 用户的信息集合
     * @return 是否删除成功
     */
    public boolean bulkDeletion(String del);

}
