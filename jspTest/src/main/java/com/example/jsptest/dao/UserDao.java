package com.example.jsptest.dao;

import com.example.jsptest.pojo.User;

import java.util.List;

/**
 * @author puti
 * @date 2022/3/18
 */
public interface UserDao {

    /**
     * 根据用户名和密码查询用户
     *
     * @param username 用户名
     * @param password 密码
     * @return 返回null代表没有，反之则用户存在
     */
    public User queryUserByYhidAndYhkl(String username, String password);

    /**
     * 查询所有的用户信息
     *
     * @return List<User>
     */
    public List<User> queryAllUser(int sta,int lim);

    /**
     * 新增一个用户信息
     *
     * @param user 用户对象
     * @return 影响的行数
     */
    public int insertUser(User user);

    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return User对象
     */
    public List<User> queryUserByYhid(String username);

    /**
     * 根据用户部门查询用户
     *
     * @param yhbm 用户部门
     * @return List<User>对象
     */
    public List<User> queryUserByYhbm(String yhbm,int sta,int lim);

    /**
     * 根据用户id和用户部门查询用户
     *
     * @param yhid 用户id
     * @param yhbm 用户部门
     * @return User对象
     */
    public List<User> queryUserByYhidAndYhbm(String yhid, String yhbm);

    /**
     * 根据用户id删除用户信息
     *
     * @param yhid 用户id
     * @return 影响的行数
     */
    public int deleteByYhid(String yhid);


    /**
     * 更新用户信息
     *
     * @param user user对象
     * @return 影响的行数
     */
    public int updateUserInfo(User user);

    /**
     * 查询用户信息总量
     *
     * @return 数量
     */
    public long countUser();


    /**
     * 根据用户部门代码查询用户部门的人数
     *
     * @param yhbm 用户部门
     * @return 用户部门的人数
     */
    public long countYhbmUser(String yhbm);

}
