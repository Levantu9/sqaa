package dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Scholastic;
import model.User;

public class Scholasticdao extends dao{
	public Scholasticdao() {
		super();
	}
	public ArrayList<Scholastic> getAll() {
		ArrayList <Scholastic> listscholastic = new ArrayList();
		Scholastic sc = new Scholastic();
		String s = "{call getAllScholastic()}";
		try {
		CallableStatement cs = con.prepareCall(s);
		ResultSet rs = cs.executeQuery();
		while(rs.next()) {
			sc.setId(rs.getInt("id"));
			sc.setScholastic(rs.getString("scholastic"));
			listscholastic.add(sc);
			sc = new Scholastic();
		}
		}catch(Exception e) {
			return null;
		}
		return listscholastic;
	}
}
