package co.edu.unilibre.user.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unilinre.user.entity.User;
import co.edu.unilibre.user.service.IUserService;

@RestController
public class UserController {
	@Value("${server.port}")
	private Long port;
	
	@Autowired
	private IUserService userService;
	
	@GetMapping("/list")
	public List<User> getList(){
		return userService.getAllList().stream().map(user -> {
			user.setPort(port);
			return user;
		}).collect(Collectors.toList());
	}
	
	@GetMapping("/{id}")
	public User getById(@PathVariable Long id) {
		User user = userService.getById(id);
		user.setPort(port);
		return user;
		
	}
}