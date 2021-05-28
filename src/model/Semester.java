package model;

import java.io.Serializable;

public class Semester implements Serializable{
	private int id;
	private String semester;
	/**
	 * 
	 */
	public Semester() {
	}
	/**
	 * @param id
	 * @param semester
	 */
	public Semester(int id, String semester) {
		this.id = id;
		this.semester = semester;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
}
