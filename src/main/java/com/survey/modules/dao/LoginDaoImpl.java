package com.survey.modules.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.survey.modules.model.Users;

@Repository
public class LoginDaoImpl implements LoginDao{
 
 SessionFactory sessionFactory;
 
 public void setSessionFactory(SessionFactory sessionFactory){
     this.sessionFactory = sessionFactory;
 }
 public Users findByUserName(String username) { Session session = this.sessionFactory.getCurrentSession();
  Users user = (Users) session.load(Users.class, new String(username));
  return user;
 }
 public void addUser(Users user) {
     Session session = this.sessionFactory.getCurrentSession();
     session.persist(user);
 }
 public void updateUser(Users user) {
 	
     Session session = this.sessionFactory.getCurrentSession();
     session.update(user);
 }

 @SuppressWarnings("unchecked")
 public List<Users> listUsers() {
 	
 	Criteria cr = this.sessionFactory.openSession().createCriteria(Users.class);
     List<Users> usersList = cr.list();
     return usersList;
 }

 public void removeUser(String username) {
     Session session = this.sessionFactory.getCurrentSession();
     Users user = (Users) session.load(Users.class, new String(username));
     if(null != user){
         session.delete(user);
     }
 }

}


