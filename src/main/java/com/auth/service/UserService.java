package com.auth.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.auth.model.SimpleGrantedAuthority;
import com.auth.model.User;
import com.auth.repo.SimpleAuthritiesRepository;
import com.auth.repo.UserRepository;
import com.auth.request.LoginUserDetails;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService implements UserDetailsManager {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SimpleAuthritiesRepository simpleAuthritiesRepository;
	
	@Autowired
	public BCryptPasswordEncoder encoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<User> users = userRepository.findByUsername(username);
		if (users.isEmpty()) {
			return null;
		}
		return users.get(0);
	}
	
	// Save New Login User
		public void saveNewLoginUser(LoginUserDetails loginUserDetails) {
			User user = new User();
			user.setUsername(loginUserDetails.getUsername());
			user.setPassword(encoder.encode(loginUserDetails.getPassword()));
			user.setEnabled(true);
			user.setAccountNonExpired(true);
			user.setAccountNonLocked(true);
			user.setCredentialsNonExpired(true);
			Collection<SimpleGrantedAuthority> grantAuthority = new ArrayList<>();
			for (String roles : loginUserDetails.getAuthorities()) {
				SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(roles);
				grantAuthority.add(simpleGrantedAuthority);
			}
			user.setAuthorities(grantAuthority);
			userRepository.save(user);
			Set<SimpleGrantedAuthority> grantedAuthorities=new HashSet<>();
			grantAuthority.stream().forEach(simpleGrnatedAuth->{
				simpleGrnatedAuth.setUser(user);
				grantedAuthorities.add(simpleGrnatedAuth);
			});
			simpleAuthritiesRepository.saveAll(grantedAuthorities);
		}

		@DeleteMapping("/deacviveTheUser")
		@PreAuthorize("hasRole('ADMIN')")
		public void deactiveTheUSer(@PathVariable String username) {
			this.deleteUser(username);
		}
	@Override
	public void createUser(UserDetails user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(UserDetails user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(String username) {
		userRepository.deleteByUsername(username);
		
	}

	@Override
	public void changePassword(String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean userExists(String username) {
		// TODO Auto-generated method stub
		return false;
	}
	
}