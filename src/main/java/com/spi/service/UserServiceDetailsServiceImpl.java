package com.spi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.spi.entity.User;
import com.spi.repo.UserRepository;

public class UserServiceDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userrepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub

		List<User> users = userrepo.findByUsername(username);

		if (users.isEmpty()) {
			throw new UsernameNotFoundException("User Not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(users.get(0).getUsername(),
				users.get(0).getPassword(), new ArrayList<>());
	}

}
