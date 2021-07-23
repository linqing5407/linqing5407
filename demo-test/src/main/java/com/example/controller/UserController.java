package com.example.controller;


import com.example.model.UserDomain;
import com.example.service.UserService;
import org.redisson.api.RLock;
import org.redisson.api.RReadWriteLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/8/16.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController{

    @Autowired
    private UserService userService;
    @Autowired
    private RedissonClient redissonClient;


    @ResponseBody
    @RequestMapping(value = "/addRedissonClient",method = RequestMethod.GET)
    public void addRedissonClient(){
      String key = "dec_store_lock_" + "123";
        RReadWriteLock rReadWriteLock = redissonClient.getReadWriteLock(key);
        rReadWriteLock.readLock().lock();
        rReadWriteLock.writeLock().unlock();
        RLock  rLock = redissonClient.getLock(key);
        rLock.lock();
        rLock.unlock();
    }


    @ResponseBody
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public int addUser(){
        UserDomain user =new UserDomain();
        user.setPassword("666");
        user.setPhone("18050010830");
        user.setUserName("linqing");
        return userService.addUser(user);
    }

    @ResponseBody
    @GetMapping("/all")
    public Object findAllUser(@RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum, @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                    int pageSize){
        return userService.findAllUser(pageNum,pageSize);
    }
}



