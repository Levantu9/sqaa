package model;

import java.io.Serializable;

public class Score implements Serializable{
	private int id;
	private float attendance;
	private int _attendance;
	private float midtestmark;
	private int _midtestmark;
	private float semestertestmark;
	private int _semestertestmark;
	private float medium;
	private User user;
	private Semester semester;
	private Scholastic scholastic;
	private Subject subject;
	/**
	 * @param id
	 * @param attendance
	 * @param _attendance
	 * @param midtestmark
	 * @param _midtestmark
	 * @param semestertestmark
	 * @param _semestertestmark
	 * @param medium
	 * @param user
	 * @param semester
	 * @param scholastic
	 * @param subject
	 */
	public Score(int id, float attendance, int _attendance, float midtestmark, int _midtestmark, float semestertestmark,
			int _semestertestmark, float medium, User user, Semester semester, Scholastic scholastic, Subject subject) {
		super();
		this.id = id;
		this.attendance = attendance;
		this._attendance = _attendance;
		this.midtestmark = midtestmark;
		this._midtestmark = _midtestmark;
		this.semestertestmark = semestertestmark;
		this._semestertestmark = _semestertestmark;
		this.medium = medium;
		this.user = user;
		this.semester = semester;
		this.scholastic = scholastic;
		this.subject = subject;
	}
	/**
	 * 
	 */
	public Score() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getAttendance() {
		return attendance;
	}
	public void setAttendance(float attendance) {
		this.attendance = attendance;
	}
	public int get_attendance() {
		return _attendance;
	}
	public void set_attendance(int _attendance) {
		this._attendance = _attendance;
	}
	public float getMidtestmark() {
		return midtestmark;
	}
	public void setMidtestmark(float midtestmark) {
		this.midtestmark = midtestmark;
	}
	public int get_midtestmark() {
		return _midtestmark;
	}
	public void set_midtestmark(int _midtestmark) {
		this._midtestmark = _midtestmark;
	}
	public float getSemestertestmark() {
		return semestertestmark;
	}
	public void setSemestertestmark(float semestertestmark) {
		this.semestertestmark = semestertestmark;
	}
	public int get_semestertestmark() {
		return _semestertestmark;
	}
	public void set_semestertestmark(int _semestertestmark) {
		this._semestertestmark = _semestertestmark;
	}
	public float getMedium() {
		return medium;
	}
	public void setMedium(float medium) {
		this.medium = medium;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Semester getSemester() {
		return semester;
	}
	public void setSemester(Semester semester) {
		this.semester = semester;
	}
	public Scholastic getScholastic() {
		return scholastic;
	}
	public void setScholastic(Scholastic scholastic) {
		this.scholastic = scholastic;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}

}
