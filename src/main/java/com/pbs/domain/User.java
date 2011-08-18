package com.pbs.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="User")
@XmlRootElement(name="User")
public class User {
	
	@Id @Column @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column @NotEmpty
	private String name;
	@Column @NotEmpty @Email 
	private String email;
	@Column @NotEmpty @Size(min=6, max=20)
	private String password;
	@Column @NotEmpty
	private String country;
	
	public User() { /* For Hibernate */ }
	
	public User(Long id, String name, String email, String password,
			String country) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.country = country;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}
	
	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}
	
}
