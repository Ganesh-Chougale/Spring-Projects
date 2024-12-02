package com.Verligence.GSRPM.Entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.GrantedAuthoritiesContainer;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "AppUser")
public class User implements UserDetails{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String username;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false)
	private String password;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name="user_roles", joinColumns = @JoinColumn(name = "user_id"))
	@Column(name = "role")
	@Enumerated(EnumType.STRING)
	private Set<Role> roles = new HashSet<>();

	
	public User() {
		
	}
	
	public User(String username, String email, String password, Set<Role> roles) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

	// Getters & Setters
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	// inherited methods UserDetails
	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        for (Role role : roles) {  // Looping through Role Enum
            authorities.add(new SimpleGrantedAuthority(role.name()));  // Use role.name() for string representation
        }
        return authorities;
    }
    

	@Override
    public boolean isAccountNonExpired() {
    	return true;
    }
    
    @Override
    public boolean isAccountNonLocked() {
    	return true;
    }
	
    @Override
    public boolean isCredentialsNonExpired() {
    	return true;
    }
    
    @Override
    public boolean isEnabled() {
    	return true;
    }
	

}
