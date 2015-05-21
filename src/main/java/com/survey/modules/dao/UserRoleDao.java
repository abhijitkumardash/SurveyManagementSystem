package com.survey.modules.dao;

import java.util.List;

import com.survey.modules.model.UserRole;
import com.survey.modules.model.Users;

public interface UserRoleDao {
	
	public List<Users> findByRole(String role);
	public void addRole(UserRole userrole);
    public List<UserRole> listUserRoles();
    public void removeUserRole(Users user, String role);
    public void removeAllRoles(String user);
}
