package model;

import java.io.Serializable;

public class Mscore implements Serializable{
	private int id;
	private float medium;
	private User u;
	private String avg;
	/**
	 * @param id
	 * @param medium
	 * @param u
	 * @param avg
	 */
	public Mscore(int id, float medium, User u, String avg) {
		super();
		this.id = id;
		this.medium = medium;
		this.u = u;
		this.avg = avg;
	}
	/**
	 * 
	 */
	public Mscore() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getMedium() {
		return medium;
	}
	public void setMedium(float medium) {
		this.medium = medium;
	}
	public User getU() {
		return u;
	}
	public void setU(User u) {
		this.u = u;
	}
	public String getAvg() {
		return avg;
	}
	public void setAvg(String avg) {
		this.avg = avg;
	}
	
	
}
