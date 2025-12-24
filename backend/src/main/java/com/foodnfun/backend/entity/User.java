package com.foodnfun.backend.entity;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name="users") 
public class User {
		
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable=false, unique=true)
	private String email;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false)
	private String password;
	
//	One user can have many vendors
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	private List<Review> reviews;
	
//	One user can bookmark many Vendors
	@ManyToMany
	@JoinTable(
			name="user_bookmarks",
			joinColumns=@JoinColumn(name="user_id"),
			inverseJoinColumns=@JoinColumn(name="vendor_id")
		)
	private List<Vendor> bookmarks;
	
//	Getters and Setters
	public long getId() {
		return id;
	}
	public void setId(long id) { this.id=id;}
	
	public String getEmail() { return email;}
	public void setEmail(String email) {this.email=email;}
	
	public String getName() {return name;}
	public void setName(String name) {this.name=name;}
	
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password=password;}
	
	public List<Review> getReviews(){return reviews;}
	public void setReviews(List<Review> reviews) {this.reviews=reviews;}
	
	public List<Vendor> getBookmarks(){return bookmarks;}
	public void setBookmarks(List<Vendor> bookmarks) {this.bookmarks=bookmarks;}
	
	
	
}
