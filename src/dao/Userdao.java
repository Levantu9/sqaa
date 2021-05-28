/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.CallableStatement;
import model.User;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author nobjt
 */
public class Userdao extends dao{
    public Userdao(){
        super();
    }
    public User Login(User u){
        boolean kq = false;
        if(!u.getIgn().isEmpty()&&!u.getPassword().isEmpty()){
            String s = "{call kiemtraDN(?,?)}";
            try{
                CallableStatement cs = con.prepareCall(s);
                cs.setString(1, u.getIgn());
                cs.setString(2, u.getPassword());
                ResultSet rs = cs.executeQuery();
                if(rs.next()){
                    u.setId(rs.getInt("id"));
                    u.setName(rs.getString("name"));
                    u.setIgn(rs.getString("ign"));
                    u.setPassword(rs.getString("password"));
                    u.setSdt(rs.getString("sdt"));
                    u.setEmail(rs.getString("email"));
                    u.setVaitro(rs.getString("vaitro"));
                    u.setMota(rs.getString("mota"));
                    
                    kq = true;
                }
            }catch(Exception e){
            	e.printStackTrace();
                return null;
            }
            if(kq==true) return u;
            else return u;
        }
        else return u;
    }
    public ArrayList <User> timUser(String keyword){
        ArrayList <User> listuser = new ArrayList();
        if(keyword!=null){
            String s = "{call timuser(?)}";
            try{
            CallableStatement cs = con.prepareCall(s);
            cs.setString(1, keyword);
            ResultSet rs = cs.executeQuery();
            while(rs.next()) {
                  User u = new User();
                  u.setId(rs.getInt("id"));
                  u.setName(rs.getString("name"));
                  u.setIgn(rs.getString("ign"));
                  u.setPassword(rs.getString("password"));
                  u.setSdt(rs.getString("sdt"));
                  u.setEmail(rs.getString("email"));
                  u.setVaitro(rs.getString("vaitro"));
                  u.setMota(rs.getString("mota"));
                  listuser.add(u);
            }
            }catch(Exception e){
                
            }
        }
        return listuser;
    }
    public boolean themUser(User u){
        boolean kq = false;
        if(u!=null){
            String s = "{call them(?,?,?,?,?,?)}";
            try{
                CallableStatement cs = con.prepareCall(s);
                cs.setString(1,u.getName());
                cs.setString(2,u.getIgn());
                cs.setString(3,u.getPassword());
                cs.setString(4,u.getSdt());
                cs.setString(5,u.getEmail());
                cs.setString(6,u.getVaitro());
                
                ResultSet rs = cs.executeQuery();
                kq = true;
            }catch(Exception e){
            	
                return false;
            }
        }
        return kq;
    }
    public boolean sua(User u) {
    	boolean kq = false;
    	if(u!=null) {
    		String s = "{call sua(?,?,?,?,?,?,?,?)}";
    		try {
    			CallableStatement cs = con.prepareCall(s);
				cs.setInt(1, u.getId());
				cs.setString(2,u.getName());
				cs.setString(3,u.getIgn());
				cs.setString(4,u.getPassword());
				cs.setString(5, u.getSdt());
				cs.setString(6, u.getEmail());
				cs.setString(7, u.getVaitro());
				cs.setString(8, u.getMota());
				
				ResultSet rs = cs.executeQuery();
				
				kq = true;
			}catch(Exception e) {
				
				return false;
				}
    		
    	}
    	return kq;
    }
    public boolean xoa(int i) {
        	boolean kq = false;
        		String s = "{call xoa(?)}";
        		try {
        			CallableStatement cs = con.prepareCall(s);
        			cs.setInt(1, i);
        			ResultSet rs = cs.executeQuery();
    				
    				kq = true;
        		}catch(Exception e) {
        			
        			return false;
        		}
        		return kq;
    }
}
