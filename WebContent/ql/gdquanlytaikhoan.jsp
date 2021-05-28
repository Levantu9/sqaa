<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,dao.*,model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel ="stylesheet" type="text/css" href="css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
 function openPage(pageURL){
    window.location.href = pageURL;
 }
</script>
<style><%@include file="all.css"%></style>
<title>Quan ly user</title>
</head>
<body>
<%
	
     ArrayList<User> listuser = new ArrayList();
     //Lấy session list user
     if(request.getParameter("page") !=null && request.getParameter("page").equalsIgnoreCase("back")){
    	 if((ArrayList<User>)session.getAttribute("listuser")!=null)
    	 listuser = (ArrayList<User>)session.getAttribute("listuser");
     	}
    	 else if(request.getParameter("page") !=null && request.getParameter("page").equalsIgnoreCase("xoa")){
         	listuser = (ArrayList<User>)session.getAttribute("listuser");
         	String s = request.getParameter("idsb");
         	int i = Integer.parseInt(s);
         	Userdao o = new Userdao();
         	if(o.xoa(i)){
         		for(int k =0;k<listuser.size();k++){
         			if(listuser.get(k).getId()==i){
         				listuser.remove(k);
        			}
         		}
         	}
         	
    	 }
     else if(request.getParameter("page") !=null && request.getParameter("page").equalsIgnoreCase("search")){
    	 listuser = (ArrayList<User>)session.getAttribute("listuser");
     }
      %>
<h2> Quản lý thành viên </h2>
<form>
		<table class ="tablesb">
		<thead>
			<tr>
				<th>Name</th>
				<th>IGN</th>
				<th>Password</th>
				<th>SĐT</th>
				<th>Email</th>
				<th>Vai trò</th>
				<th>Sửa</th>
				<th>Xóa</th>
			</tr>
			
		</thead>

		<%
			if(listuser.isEmpty())
				for(int i=0;i<5;i++){
					
					%>
					
					<tr class="elm">
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					</tr>
			<% }
				
		%>
		<%
			if(listuser!=null)
				for(int i =0;i<listuser.size();i++){
					
					%>
					<tr class="elm">
					<td><%=listuser.get(i).getName()%></td>
					<td><%=listuser.get(i).getIgn()%></td>
					<td><%=listuser.get(i).getPassword()%></td>
					<td><%=listuser.get(i).getSdt()%></td>
					<td><%=listuser.get(i).getEmail() %></td>
					<td><%=listuser.get(i).getVaitro() %></td>
					<td><a id="sua" href = "gdsuataikhoan.jsp?idsb=<%=i %>&&id=1"/>Sửa</td>
					<td><a href = "gdquanlytaikhoan.jsp?page=xoa&&idsb=<%=listuser.get(i).getId() %>"/>Xóa</td>
					
					</tr>
				<% }	
		%>
			
	</table>
	<table>
		<td><h5>Tìm kiếm</h5></td>
		<td><input type="text"  name="timkiem" id="timkiem"></td>
		<td><input type="submit" class ="button" id ="buttontimkiem" value="Tìm kiếm" /></td>
		<td><a id="them" href="gdthemuser.jsp?id=1">Thêm</a></td>
	</table>
</form>
<%
	
	String keyword = request.getParameter("timkiem");
	if(keyword!=null){
		Userdao dao = new Userdao();
		listuser = dao.timUser(keyword);
		session.setAttribute("listuser", listuser);
		response.sendRedirect("gdquanlytaikhoan.jsp?page=search");
	}
%>
</body>
</html>