package com.kmstore.slowfood.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category {
	

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;

	@JsonIgnore
	@ManyToOne
	private Department department;
	
	@OneToMany(mappedBy = "category")
	private Set<Product> products = new HashSet<Product>();
	
	public Category(String name, Department department) {
		this.name = name;
		this.department = department;
	}
	
	@SuppressWarnings("unused")
	private Category() {
		
	}

	public Long getId() {
		return id;
	}
	
	

	public String getName() {
		return name;
	}

	public Department getDepartment() {
		return department;
	}

	public Set<Product> getProducts() {
		return products;
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
		Category other = (Category) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
