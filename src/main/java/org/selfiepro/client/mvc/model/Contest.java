package org.selfiepro.client.mvc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Contest {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;

	private String fbPageName;

	private int maxParticipants;
	
	private int currentParticipants;
	
	private Integer productId;
	
	@ManyToOne
	private Product product;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFbPageName() {
		return fbPageName;
	}

	public void setFbPageName(String fbPageName) {
		this.fbPageName = fbPageName;
	}

	public int getMaxParticipants() {
		return maxParticipants;
	}

	public void setMaxParticipants(int maxParticipants) {
		this.maxParticipants = maxParticipants;
	}

	public Product getProduct() {
	    return product;
	}

	public void setProduct(Product product) {
	    this.product = product;
	}

	public int getCurrentParticipants() {
	    return currentParticipants;
	}

	public void setCurrentParticipants(int currentParticipants) {
	    this.currentParticipants = currentParticipants;
	}
}
