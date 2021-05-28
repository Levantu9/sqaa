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
      	ArrayList<Mscore> listms = new ArrayList();
      	String []hocluc = new String [5];
		hocluc[0]="Xuất sắc";hocluc[1]="Giỏi";hocluc[2]="Khá";hocluc[3]="Trung Bình";hocluc[4]="Yếu";
		Mscoredao dao = new Mscoredao();
		listms = dao.getAllMscore();
		int tong = listms.size();
		int []soluong = new int[5];
		for(int i=0;i<tong;i++){
			if(listms.get(i).getAvg().equals("xuatsac")){
				soluong[0]++;
			}else if(listms.get(i).getAvg().equals("gioi")){
				soluong[1]++;
			}else if(listms.get(i).getAvg().equals("kha")){
				soluong[2]++;
			}else if(listms.get(i).getAvg().equals("trungbinh")){
				soluong[3]++;
			}else if(listms.get(i).getAvg().equals("yeu")){
				soluong[4]++;
			}
		}
%>
<h2> Báo cáo % </h2>
	<table class ="tablesb">
		<thead>
			<tr>
				<th>Học lực</th>
				<th>Số sinh viên</th>
				<th>% Số sinh viên</th>
			</tr>
			</thead>
			<%for (int i = 0;i<5;i++){
				%>
			
			<tr class="elm">
					
					<td style="text-align:right"><%=hocluc[i] %></td>
					<td style="text-align:right"><%=soluong[i] %></td>
					<td style="text-align:right"><%=(float)soluong[i]/tong %></td>

			</tr>
			<%} %>
		</table>
</body>
</html>