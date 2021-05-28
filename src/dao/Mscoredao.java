package dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Mscore;
import model.Score;

public class Mscoredao extends dao{
	public Mscoredao() {
		super();
	}
	public ArrayList<Mscore>getAllMscore() {
		ArrayList <Mscore> listmscore = new ArrayList();
		Mscore ms = new Mscore();
		String s = "{call getAllMscore()}";
		try {
			CallableStatement cs = con.prepareCall(s);
			ResultSet rs = cs.executeQuery();
			while(rs.next()) {
				ms.setId(rs.getInt("id"));
				ms.setMedium(rs.getFloat("medium"));
				ms.setAvg(rs.getString("avg"));
				listmscore.add(ms);
				ms = new Mscore();
			}
			return listmscore;
		}catch(Exception e) {
			return listmscore;
		}
	}
}
