package co.edu.unilibre.user.service;

import java.util.List;

import co.edu.unilinre.user.entity.User;

public interface IUserService {
	public List<User> getAllList();
	public User getById(Long id);
}