package com.springmvcMaven.service.user;

import com.springmvcMaven.pojo.TUser;

import java.util.List;

/**
 * Created by Administrator on 2016/7/20.
 */
public interface UserService {
    /**
     * 查找所有用户
     *
     * @return
     * @throws Exception
     */
    List<TUser> findUser() throws Exception;

    /**
     *
     * @param userName
     * @param password
     */
    void addUser(String userName,String password);
}
