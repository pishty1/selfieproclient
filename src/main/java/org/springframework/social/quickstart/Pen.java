package org.springframework.social.quickstart;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Pen {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
	
	private String write;
	private int minEntries;
	private double reward;
	
	
	public String getWrite() {
		return write;
	}
	public void setWrite(String write) {
		this.write = write;
	}
	public int getMinEntries() {
		return minEntries;
	}
	public void setMinEntries(int minEntries) {
		this.minEntries = minEntries;
	}
	public double getReward() {
		return reward;
	}
	public void setReward(double reward) {
		this.reward = reward;
	}
}
