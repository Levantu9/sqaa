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
<title>Theo doi diem</title>
</head>
<body>
<%
	User ql = (User)session.getAttribute("quanly");
      	if(ql==null){
          	response.sendRedirect("gddangnhap.jsp?err=timeout");
     }
      	ArrayList<Score> listdiem = new ArrayList();
      	float diemtb = -1;
      	int tinchitb = -1;
        if(request.getParameter("page") !=null && request.getParameter("page").equalsIgnoreCase("search")){
       	 listdiem = (ArrayList<Score>)session.getAttribute("listdiem");
        }
%>
<h2> Theo dõi điểm </h2>
<table>
	<form>
	<tr>
		<td><h5>Mã sinh viên</h5></td>
		<td><input type="text"  name="timkiem" id="timkiem" ></td>
		<td><h5>Năm học</h5></td>
		<%
		Scholasticdao dao = new Scholasticdao();
		ArrayList<Scholastic>listsc=new ArrayList();
		listsc = dao.getAll();
		%>
		<td><select name ="scholastic">
		<%if(listsc!=null){
		for(int i =0;i<listsc.size();i++){
			%>
			<option><%=listsc.get(i).getScholastic() %></option>
			
			<%}} %>
		</select></td>
		<td><h5>Học kỳ</h5></td>
		<%
		Semesterdao smdao = new Semesterdao();
		ArrayList<Semester>listsm=new ArrayList();
		listsm = smdao.getAll();
		%>
		<td><select name = "semester">
		<%if(listsm!=null){
		for(int i =0;i<listsm.size();i++){
			%>
			<option><%=listsm.get(i).getSemester() %></option>
			
			<%}} %>
		</select></td>
		<td><input type="submit" class ="button" id ="button" value="Theo dõi" />
	</tr>

	</form>
	<tr>
	<table class ="tablesb">
		<thead>
			<tr>
				<th>Ten mon hoc</th>
				<th>Diem chuyen can</th>
				<th>%Diem chuyen can</th>
				<th>Diem giua ky</th>
				<th>%Diem giua ky</th>
				<th>Diem cuoi ky</th>
				<th>%Diem cuoi ky</th>
				<th>Trung binh</th>
			</tr>
			
		</thead>

		<%
			if(listdiem.isEmpty())
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
			if(listdiem!=null)
				diemtb = 0;
				tinchitb = 0;
				for(int i =0;i<listdiem.size();i++){
					diemtb += listdiem.get(i).getMedium()*listdiem.get(i).getSubject().getCredit();
					tinchitb+=listdiem.get(i).getSubject().getCredit();
					
					%>
					<tr class="elm">
					<td><%=listdiem.get(i).getSubject().getName()%></td>
					<td style="text-align:right"><%=listdiem.get(i).getAttendance()%></td>
					<td style="text-align:right"><%=listdiem.get(i).get_attendance()%></td>
					<td style="text-align:right"><%=listdiem.get(i).getMidtestmark()%></td>
					<td style="text-align:right"><%=listdiem.get(i).get_midtestmark()%></td>
					<td style="text-align:right"><%=listdiem.get(i).getSemestertestmark()%></td>
					<td style="text-align:right"><%=listdiem.get(i).get_semestertestmark()%></td>
					<td style="text-align:right"><%=listdiem.get(i).getMedium()%></td>
					</tr>
				<% }	
		%>
			
	</table>
	
	<%
	if(tinchitb!=0){
		diemtb/=tinchitb;
	}
	if (diemtb!=-1&&diemtb!=0){%>
	<table class ="tablesb">
		<thead>
			<tr>
				<td>Điểm Trung Bình</td>
			</tr>
		</thead>
		<tr class="elm">
		<td><%=diemtb %></td>
		</tr>
		</table>
		<%} %>
	</tr>
</table>
<%
	String masv = request.getParameter("timkiem");
	String scholastic = request.getParameter("scholastic");
	String semester = request.getParameter("semester");
	if(masv!=null&&masv.isEmpty()){
		%> <h4>Vui lòng nhập mã sinh viên</h4><%
	}
	else if(masv!=null&&scholastic!=null&&semester!=null){
		Scoredao scoredao = new Scoredao();
		listdiem = scoredao.getUserScore(masv,scholastic,semester);
		session.setAttribute("listdiem", listdiem);
		response.sendRedirect("gdtheodoidiem.jsp?page=search");
	}
%>
</body>
</head>
