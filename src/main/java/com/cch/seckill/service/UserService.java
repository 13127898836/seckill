package com.cch.seckill.service;

import com.cch.seckill.dao.UserDao;
import com.cch.seckill.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 459105408@qq.com
 * 2018-03-03 13:49.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User getById(int id){
        return userDao.getById(id);
    }
    @Transactional
    public boolean tx(){
        User u1 = new User();
        u1.setId(2);
        u1.setName("2222");

        User u2 = new User();
        u2.setId(1);
        u2.setName("1111");
        userDao.insert(u1);
        userDao.insert(u2);
        return true;
    }
}
