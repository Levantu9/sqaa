package model;

import java.io.Serializable;

public class Scholastic implements Serializable{
	private int id;
	private String scholastic;
	/**
	 * @param id
	 * @param scholastic
	 */
	public Scholastic(int id, String scholastic) {
		super();
		this.id = id;
		this.scholastic = scholastic;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getScholastic() {
		return scholastic;
	}
	public void setScholastic(String scholastic) {
		this.scholastic = scholastic;
	}
	/**
	 * 
	 */
	public Scholastic() {
		super();
	}
	
	
}
