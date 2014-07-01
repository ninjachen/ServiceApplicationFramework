package com.wonders.frame.core.jpa.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Cacheable
@Entity
@Table(name = "tbl_user")
@Access(AccessType.PROPERTY)
public class User implements UserDetails, Serializable {

	private static final long serialVersionUID = 6683661386004867187L;

	private Integer id;
	private String username;
	private String password;
	private Name name;
	private Gender gender;
	private Lock lock;
	private List<String> emails;
	private Set<Role> roles;

	public User() {
		super();
		roles = new HashSet<Role>();
		emails = new ArrayList<String>();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Id
	@GeneratedValue
	@Column(name = "_id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "_username")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "_password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "tbl_user_role",
		inverseJoinColumns = { @JoinColumn(name = "_role_id") },
		joinColumns = { @JoinColumn(name = "_user_id") }
	)
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Embedded
	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}
	
	@Column(name = "_sex")
	@Enumerated(EnumType.STRING)
	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "_lock")
	public Lock getLock() {
		return lock;
	}

	public void setLock(Lock lock) {
		this.lock = lock;
	}

	@ElementCollection(fetch = FetchType.EAGER)
	@JoinTable(name = "tbl_email", joinColumns = { @JoinColumn(name = "_user_id") })
	@Column(name = "_email")
	@OrderColumn(name = "_order")
	public List<String> getEmails() {
		return emails;
	}

	public void setEmails(List<String> emails) {
		this.emails = emails;
	}

	@Transient
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return getRoles();
	}

	@Transient
	public boolean isAccountNonExpired() {
		return true;
	}

	@Transient
	public boolean isAccountNonLocked() {
		return true;
	}

	@Transient
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Transient
	public boolean isEnabled() {
		return getLock() == Lock.NON_LOCKED;
	}
	
	@Transient
	public String getFirstName() {
		if (name == null) return null;
		return name.getFirstName();
	}

	@Transient
	public String getLastName() {
		if (name == null) return null;
		return name.getLastName();
	}
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public static enum Lock {
		LOCKED, NON_LOCKED
	}
	
	public static enum Gender {
		MALE, FEMALE
	}
}
