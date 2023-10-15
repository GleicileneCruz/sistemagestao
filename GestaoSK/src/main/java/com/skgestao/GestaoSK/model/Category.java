package com.skgestao.GestaoSK.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "tb_category")
public class Category implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant createdAt;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant updateAt;
	
	// @ManyToMany(mappedBy = "categories")
	// private Set<Products> products = new HashSet<>();
	
	public Category() {
	}

	public Category(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	

	public Instant getCreatedAT() {
		return createdAt;
	}

	public Instant getUpdateAt() {
		return updateAt;
	}

	@PrePersist
	public void prePersist() {
		createdAt = Instant.now();
	}
	
	@PreUpdate
	public void preUpdate() {
		updateAt = Instant.now();
	}
	
	// public Set<Products> getProducts() {
	// 	return products;
	// }
	
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
		Category other = (Category) obj;
		return Objects.equals(id, other.id);
	}

	// public void delete(int id) {
	// 	try {
	// 		categoryRepo.deleteById(id);
	// 	}
	// 	catch (EmptyResultDataAccessException e) {
	// 		throw new ResourceNotFoundException("Id not found" + id);
	// 	}
	// 	catch (DataIntegrityViolationException e) {
	// 		throw new DatabaseException("Violacao Integridade");
	// 	}
	// }
	
}