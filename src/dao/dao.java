/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author nobjt
 */
import java.sql.Connection;
import java.sql.DriverManager;
public class dao {
	public static Connection con;
	     
	    public dao(){
	        if(con == null){
	            String dbUrl = "jdbc:mysql://localhost:3306/qld?autoReconnect=true&useSSL=false";
	      
	 
	            try {
	            	Class.forName("com.mysql.cj.jdbc.Driver");
	                con = DriverManager.getConnection (dbUrl, "root", "nguyenhung1999");
	            }catch(Exception e) {
	                e.printStackTrace();
	            }
	        }
	    }	
	}
