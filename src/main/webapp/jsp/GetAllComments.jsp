<%@page import="java.sql.Time"%>
<%@page import="com.xiang.bean.CommentBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*, com.xiang.bean.CommentBean,java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%!@SuppressWarnings("unchecked")
	public String formatDate(long date) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return sdf.format(date);
	}%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>評論資料</title>
 <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
 <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
 
</head>
<body style='background-color: fdf5e6'>
	<div align="center">
		<h2>評論表資料</h2>
		<table border="1"  id="table_id">
			<tr style="background-color: #a8fefa">
				<th>編號
				<th>名字
				<th>類型
				<th>評論內容
				<th>服務評價
				<th>評論建立時間
				<th>評論修改時間
				<th>delete
				<th>update <%
				List<CommentBean> coms = (ArrayList<CommentBean>) request.getAttribute("coms");
						for (CommentBean com : coms) {
				%>
			<tr>
				<td><%=com.getUserID()%>
				<td><%=com.getUsername()%>
				<td><%=com.getUserType()%>
				<td><%=com.getCommentContent()%>
				<td>
					<%
					int rate = com.getRate(); // 获取评分值
					for (int i = 0; i < rate; i++) {
					%> <img src="http://localhost:8080/Comment/images/star3.png "
					alt="star" width="20" height="20"> <% } %>
				
				<td><%=formatDate((com.getCommentTime()))%>
				<td><%=formatDate(com.getLastmodifiedtime())%>
				<td><a
					href="http://localhost:8080/Comment/DeleteComment?id=<%=com.getUserID()%>"
					class="delete">刪除</a>
				<td><a
					href="http://localhost:8080/Comment/html/edit_commentAll.html?id=<%=com.getUserID()%>"
					class="update">修改</a></td>
				<%
				}
				%>
			
		</table>
		<h3>
			共<%=coms.size()%>筆評論資料
		</h3>
		<button onclick="redirectToHomepage()" style="margin-bottom: 20px;">返回首頁</button>
	</div>
	<script>
		

		
	$(".delete").on('click', function(e) {
	    e.preventDefault();
	    var deleteLink = $(this).attr('href');
	    Swal.fire({
	        title: "你確定要刪除嗎?",
	        text: "您將無法恢復此狀態！",
	        icon: "warning",
	        showCancelButton: true,
	        confirmButtonColor: "#3085d6",
	        cancelButtonColor: "#d33",
	        confirmButtonText: "刪除"
	    }).then((result) => {
	        if (result.isConfirmed) {
	            Swal.fire({
	                title: "已刪除!",
	                text: "您的資料已刪除",
	                icon: "success"
	            }).then(() => {
	                window.location.href = deleteLink; 
	            });
	        }
	    });
	});
		function redirectToHomepage() {
			window.location.href = 'http://localhost:8080/Comment/html/index.html';
		}
		
</script>
</body>
</html>