package com.kmstore.slowfood.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	@Lob
	private String imageUrl;
	private String categoryName;
	private String price;

	@JsonIgnore
	@ManyToOne
	private Category category;

	public Product(String name, String price, String imageUrl, Category category) {
		this.name = name;
		this.price = price;
		this.imageUrl = imageUrl;
		this.category = category;
		this.categoryName = category.getName();
	}

	public Product(String name, String imageUrl, Category category) {
		this.name = name;
		this.imageUrl = imageUrl;
		this.category = category;
		this.categoryName = category.getName();
	}

	@SuppressWarnings("unused")
	private Product() {

	}


	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPrice() {
		return price;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public Category getCategory() {
		return category;
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
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
