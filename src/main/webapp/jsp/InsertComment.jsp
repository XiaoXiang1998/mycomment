<%@page
	import="java.util.*, com.xiang.bean.CommentBean,java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%!public String formatDate(long millis) {
    Date date = new Date(millis);

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    return sdf.format(date);
} %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>評論資料</title>
 <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
 <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<style>
button {
	margin-bottom: 20px;
}

table {
	margin-top: 20px;
}
</style>
<jsp:useBean id="com" scope="request" class="com.xiang.bean.CommentBean" />

</head>
<body style='background-color: fdf5e6'>
	<div align="center" style="margin-top: 20px;">
		<h2>成功新增資料</h2>
		<table border="1">
			<tr style="background-color: #a8fefa">
				<th>ID
				<th>Name
				<th>Type
				<th>CommentContent
				<th>Rate
				<th>CommentTime
				<th>Lastmodifiedtime
				<th>delete
				<th>update
			<tr>
				<td><%= com.getUserID() %></td>
				<td><%= com.getUsername() %></td>
				<td><%= com.getUserType() %></td>
				<td><%= com.getCommentContent() %></td>
				<td><%
					int rate = com.getRate(); // 获取评分值
					for (int i = 0; i < rate; i++) {
					%> <img src="http://localhost:8080/Comment/images/star3.png " alt="star" width="20" height="20">
					<% } %>
				<td><%= formatDate(com.getCommentTime()) %></td>
				<td><%= formatDate(com.getLastmodifiedtime()) %></td>
				<td><a
					href="http://localhost:8080/Comment/DeleteComment?id=<%=com.getUserID()%>"	
					class="delete">刪除</a></td>
				<td><a
					href="http://localhost:8080/Comment/html/edit_comment.html?id=<%=com.getUserID()%>"	
					class="update">修改</a></td>
			</tr>
		</table>
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