<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,dao.*,model.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style><%@include file="all.css"%></style>
<title>Dang nhap</title>
</head>
<body>
<h2> Đăng nhập </h2>
    <form name="dangnhap" method="post">
        <table border="0">
            <tr>
                <td><h5>Tên đăng nhập:</h5></td>
                <td><input type="text" name="tendangnhap" id="tendangnhap" 
                /></td>
            </tr>
            <tr>
                <td><h5>Mật khẩu:</h5></td>
                <td><input type="password" name="matkhau" id="matkhau" 
                /></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" class ="button" id ="button" value="Đăng nhập" />
			</td>
            </tr>
        </table>
    </form>
<%
      if(request.getParameter("err") !=null && request.getParameter("err").equalsIgnoreCase("timeout")){
          %> <h4>Hết phiên làm việc. Làm ơn đăng nhập lại!</h4><%
      }else if(request.getParameter("err") !=null && request.getParameter("err").equalsIgnoreCase("fail")){
          %> <h4 id="message" style="display: block;" color="red">Wrong username/password!</h4><%
      }
      %>
      
<%
	String tendn = request.getParameter("tendangnhap");
    String mk = request.getParameter("matkhau");
    if(tendn!=null&&tendn.isEmpty()&&mk!=null&&mk.isEmpty()){
    	%> <h4 id="message" style="display: block;" color="red">Username and password have not been entered, please try again</h4><%
    }
    else if(tendn!=null&&tendn.isEmpty()){
    	%> <h4 id="message" style="display: block;" color="red">Username not entered, please try again</h4><%
    }else if(mk!=null&&mk.isEmpty()){
    	%> <h4 id="message" style="display: block;" color="red">Password not entered, please try again</h4><%
    }
    else if(tendn!=null&&mk!=null&&!tendn.isEmpty()&&!mk.isEmpty()){
    User u = new User();
    u.setIgn(tendn);
    u.setPassword(mk);
    
    Userdao dao = new Userdao();
    User kq = dao.Login(u);
    if(kq.getVaitro()!=null){
    if((u.getVaitro().equalsIgnoreCase("quanly"))){
    	session.setAttribute("quanly", kq);
    	response.sendRedirect("ql\\gdchinhquanly.jsp");
    	}
    else if(kq!=null&&(u.getVaitro().equalsIgnoreCase("banhang"))){
    	session.setAttribute("banhang", kq);
    	response.sendRedirect("gddangnhap.jsp?err=fail");
    	}
    }else{
    	response.sendRedirect("gddangnhap.jsp?err=fail");
    	}
    }
    else{
    	
    }
%>
</body>
</html>