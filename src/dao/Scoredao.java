package dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Score;
import model.Semester;
import model.Subject;

public class Scoredao extends dao{
	public Scoredao() {
		super();
	}
	public ArrayList<Score> getUserScore(String masv, String namhoc,String hocky){
		ArrayList <Score> listscore = new ArrayList();
		Score sc = new Score();
		Subject sj = new Subject();
		String s = "{call getScore(?,?,?)}";
		try {
			CallableStatement cs = con.prepareCall(s);
			cs.setString(1,masv);
			cs.setString(2,namhoc);
			cs.setString(3,hocky);
			ResultSet rs = cs.executeQuery();
			while(rs.next()) {
				sc.setId(rs.getInt("id"));
				sc.setAttendance(rs.getFloat("attendance"));
				sc.set_attendance(rs.getInt("%attendance"));
				sc.setMidtestmark(rs.getFloat("midtestmark"));
				sc.set_midtestmark(rs.getInt("%midtestmark"));
				sc.setSemestertestmark(rs.getFloat("semestertestmark"));
				sc.set_semestertestmark(rs.getInt("%semestertestmark"));
				sc.setMedium(rs.getFloat("medium"));
				
				sj.setId(rs.getInt("d.id"));
				sj.setName(rs.getString("d.name"));
				sj.setCredit(rs.getInt("d.credit"));
				sc.setSubject(sj);
				
				listscore.add(sc);
				sc = new Score();
				sj = new Subject();
			}
		}catch(Exception e) {
			return null;
		}
		return listscore;
	}
}
