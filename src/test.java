import java.util.ArrayList;

import dao.Mscoredao;
import dao.Scholasticdao;
import dao.Scoredao;
import dao.Semesterdao;
import dao.Userdao;
import model.Semester;
import model.User;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Userdao dao = new Userdao();
		User u = new User();
		u.setIgn("123");
		u.setPassword("123");
		u = dao.Login(u);
		System.out.println(u.getIgn());
	}

}
