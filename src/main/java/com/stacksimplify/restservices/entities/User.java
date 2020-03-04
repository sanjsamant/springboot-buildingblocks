package com.stacksimplify.restservices.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "user")
//@JsonIgnoreProperties({"firstname","lastname"})
//@JsonFilter(value = "userFilter")
@ApiModel(description = "This model is to create a user")
public class User extends ResourceSupport{
	
	@Id
	@GeneratedValue
	@JsonView(Views.External.class)
	@ApiModelProperty(notes = "userid - Unique identifier of user", required = true, position = 1)
	private Long userid;
	@Size(min=2, max=50)
	@NotEmpty(message="Username is mandatory field, please provide username")
	@Column(name="USER_NAME", length=50, nullable=false, unique=true)
	@JsonView(Views.External.class)
	@ApiModelProperty(notes = "username of user", required = false, position = 2)
	private String username;
	@Size(min=2, max=50,  message="FirstName should have atleast 2 characters")
	@Column(name="FIRST_NAME",length=50, nullable=false )
	@JsonView(Views.External.class)
	@ApiModelProperty(notes = "First name of the User.", example = "Kalyan", required = false, position = 3)
	private String firstname;
	@Column(name="LAST_NAME",length=50, nullable=false )
	@JsonView(Views.External.class)
	private String lastname;
	@Column(name="EMAIL_ADDRESS",length=50, nullable=false )
	@JsonView(Views.External.class)
	private String email;
	@Column(name="ROLE",length=50, nullable=false )
	@JsonView(Views.Internal.class)
	private String role;
	@Column(name="SSN", length=50, nullable=false, unique=true)
	//@JsonIgnore
	@JsonView(Views.Internal.class)
	@ApiModelProperty(notes = "SSN of the User.", example = "SSN1010", required = true, position = 4)
	private String ssn;
	
	@OneToMany(mappedBy = "user")
	@JsonView(Views.Internal.class)
	private List<Order> orders;
	
	@Column(name="ADDRESS")
	private String address;
	
	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public User() {
		
	}



	public User(Long userid,
			@NotEmpty(message = "Username is mandatory field, please provide username") String username,
			@Size(min = 2, message = "FirstName should have atleast 2 characters") String firstname, String lastname,
			String email, String role, String ssn, List<Order> orders, String address) {
		super();
		this.userid = userid;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.role = role;
		this.ssn = ssn;
		this.orders = orders;
		this.address = address;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long id) {
		this.userid = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", firstname=" + firstname + ", lastname="
				+ lastname + ", email=" + email + ", role=" + role + ", ssn=" + ssn + ", orders=" + orders
				+ ", address=" + address + "]";
	}

	

	
	

}
