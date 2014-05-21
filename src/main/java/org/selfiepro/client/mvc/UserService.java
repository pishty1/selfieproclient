package org.selfiepro.client.mvc;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Inject
	UserRepository userRepository;
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	public boolean userExists(String userId){
		return userRepository.exists(userId);
	}
	
	public User getUser(String userId) {
		return userRepository.findOne(userId);
	}
}
