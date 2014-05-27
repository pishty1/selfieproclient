package org.selfiepro.client.mvc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Contest {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;

	private String fbPageName;

	private int maxParticipants;
	
	private Integer productId;
	
	
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
}
