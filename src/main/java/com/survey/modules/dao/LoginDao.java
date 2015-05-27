package com.survey.modules.dao;


import java.util.List;

import com.survey.modules.model.Users;

public interface LoginDao {
 Users findByUserName(String username);
 public void addUser(Users user);
 public void updateUser(Users user);
 public List<Users> listUsers();
 public void removeUser(String username);
}