package com.stacksimplify.restservices.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="orders")
public class Order extends ResourceSupport {
	@Id
	@GeneratedValue
	@JsonView(Views.Internal.class)
	private Long orderid;
	@JsonView(Views.Internal.class)
	private String orderDescription;
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private User user;
	public Order() {
		super();
	}
	public Long getOrderid() {
		return orderid;
	}
	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}
	public String getOrderDescription() {
		return orderDescription;
	}
	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
		

}
