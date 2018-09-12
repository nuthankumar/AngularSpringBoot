package com.exide.sfcrm.authentication;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class UserDetails extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4039923993897658220L;
	
	/**
	 * 
	 */
	private com.exide.sfcrm.model.User user; 

	/**
	 * 
	 * @param username
	 * @param password
	 * @param enabled
	 * @param accountNonExpired
	 * @param credentialsNonExpired
	 * @param accountNonLocked
	 * @param authorities
	 */
	public UserDetails(String username, String password, boolean enabled,
			boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired,
				accountNonLocked, authorities);
	}
	
	/**
	 * 
	 * @param username
	 * @param password
	 * @param authorities
	 */
	public UserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, true, true, true, true, authorities);
	}
	
	
	/**
	 * 
	 * @return
	 */
	public com.exide.sfcrm.model.User getUser() {
		return user;
	}
	
	/**
	 * 
	 * @param user
	 */
	public void setUser(com.exide.sfcrm.model.User user) {
		this.user = user;
	}

}
