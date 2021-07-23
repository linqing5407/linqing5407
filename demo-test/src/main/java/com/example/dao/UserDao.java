package com.example.dao;
import com.example.model.UserDomain;
import java.util.List;
public interface UserDao {

    int insert(UserDomain record);


    List<UserDomain> selectUsers();
}

