package com.springmvcMaven.service.user.impl;

import com.springmvcMaven.mapper.TUserMapper;
import com.springmvcMaven.pojo.TUser;
import com.springmvcMaven.service.user.UserService;
import com.springmvcMaven.util.Md5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/7/20.
 */
@Service
public class UserServiceImpl implements UserService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //User接口
    @Autowired(required=false)
    private TUserMapper tUserMapper;

    public List<TUser> findUser() throws Exception {
        logger.info("查询所有用户信息");
        //调用mapper类中的selectByExample方法，如果传入类型为null，则表示无条件查找
        List<TUser> users = tUserMapper.selectByExample(null);
        return users;
    }

    public void addUser(String userName,String password) {
        TUser user = new TUser();
        user.setUsername(userName);
        user.setPassword(Md5Util.GetMD5Code(password));
        user.setState("1");
        user.setCreateTime(new Date());
        tUserMapper.insertSelective(user);
    }
}
