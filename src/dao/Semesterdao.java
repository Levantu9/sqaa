package dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Scholastic;
import model.Semester;

public class Semesterdao extends dao{
	public Semesterdao() {
		super();
	}
	public ArrayList<Semester> getAll() {
		ArrayList <Semester> listsemester = new ArrayList();
		Semester sc = new Semester();
		String s = "{call getAllSemester()}";
		try {
		CallableStatement cs = con.prepareCall(s);
		ResultSet rs = cs.executeQuery();
		while(rs.next()) {
			sc.setId(rs.getInt("id"));
			sc.setSemester(rs.getString("semester"));
			listsemester.add(sc);
			sc = new Semester();
		}
		}catch(Exception e) {
			return null;
		}
		return listsemester;
	}
}
