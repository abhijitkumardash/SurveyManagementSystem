package com.survey.modules.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.survey.modules.model.UserRole;
import com.survey.modules.dao.UserRoleDao;
import com.survey.modules.dao.LoginDao;
import com.survey.modules.model.Users;

@Service
public class UsersServiceImpl implements UsersService{
		
	@Autowired
		private LoginDao loginDao;
	@Autowired
	private UserRoleDao userRoleDao;
	  
		public void setUserRoleDao(UserRoleDao userRoleDao) {
		this.userRoleDao = userRoleDao;
	}

		public void setLoginDao(LoginDao loginDao) {
	        this.loginDao = loginDao;
	    }
	 
	    @Transactional
	    public void addUser(Users user) {
	        this.loginDao.addUser(user);
	        UserRole userrole = new UserRole();
	        userrole.setRole("ROLE_USER");
	        userrole.setUser(user);
	        this.userRoleDao.addRole(userrole);
	    }
	    @Transactional
	    public void updateUser(Users user) {
	        this.loginDao.updateUser(user);
	    }
	    
	    @Transactional
	    public List<Users> listUsers() {
	        return this.loginDao.listUsers();
	    }
	 
	    @Transactional
	    public Users findByUserName(String username) {
	        return this.loginDao.findByUserName(username);
	    }
	 
	    @Transactional
	    public void removeUser(String username) {
	        this.loginDao.removeUser(username);
	        this.userRoleDao.removeAllRoles(username);
	    }
	 
}
