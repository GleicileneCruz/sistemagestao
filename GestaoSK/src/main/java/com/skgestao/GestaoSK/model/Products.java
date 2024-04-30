package com.skgestao.GestaoSK.model;

import java.io.Serializable;

import java.text.NumberFormat;
import java.time.Instant;

import java.util.HashSet;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;


import javax.persistence.*;


@Entity
@Table(name = "tb_product")
public class Products implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private String name;
    private Integer quantity;


    @Column(columnDefinition = "TEXT")
	private String description;

	@Column(nullable = false)
	private Double price;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant date;

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	@ManyToMany
	 @JoinTable(name = "tb_product_category",
	 		joinColumns = @JoinColumn(name = "product_id"),
	 		inverseJoinColumns = @JoinColumn(name = "category_id"))
	 Set<Category> categories = new HashSet<>();
	
	public Products() {
	}
	
	public Products(Integer id, String name, Integer quantity, String description, Double price, Instant date) {
		this.id = id;
		this.name = name;
        this.quantity = quantity;
		this.description = description;
		this.price = price;
		this.date = date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	 public Set<Category> getCategories() {
	 	return categories;
	 }


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Products other = (Products) obj;
		return Objects.equals(id, other.id);
	}


}

