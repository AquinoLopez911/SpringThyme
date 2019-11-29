//this class represents a table in the data base
//annotations are required acordingly
//
package com.LateNightIce.models;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "Product")
public class Product {
	
	/* TABLE COLUMNS */
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min = 5, max = 200)
	@NotNull(message = "Name may not be null")
	private String name;
	
	@NotNull()
	private float price;
	
	@Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
	
	
     /* CONSTRUCTORS */
    
	//Default constructor
    public Product() {
		
	}
    
    //overloaded constructor
	public Product(String n, float p) {
		this.name = n;
		this.price = p;
	}
	
	
	public Product(String name, float price, Date createdAt,Date updatedAt) {
		this.name = name;
		this.price = price;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	/* CREATED / UPDATED */
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

    
    /* GETTERS */ 
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public float getPrice() {
		return price;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	
	/* SETTERS */
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}//end class
