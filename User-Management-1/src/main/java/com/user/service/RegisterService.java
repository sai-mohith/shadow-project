package com.user.service;

import java.util.Optional;

import com.user.model.Add;
import com.user.model.User;
import com.user.model.Valid;

public interface RegisterService {
	public void saveData(Valid valid,User user,Add add);
	public boolean authenticate(Valid valid);
	public boolean emailvalid(String emailid);
	public void deleteData(Valid valid);
	public Optional<User> search(String emailid);
	public void saveUpdate(User user);
}
