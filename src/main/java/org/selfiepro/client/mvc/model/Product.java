package org.selfiepro.client.mvc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {
	
	@Id
	@GeneratedValue
	@JsonProperty("exId")
	private Integer id;
	
	private String name;
	
	private double price;
	
	@JsonProperty("id")
	private Integer sfId;
	
	private String imageUrl;
	
	private String status;

	
	public Integer getSfId() {
		return sfId;
	}

	public void setSfId(Integer sfId) {
		this.sfId = sfId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
