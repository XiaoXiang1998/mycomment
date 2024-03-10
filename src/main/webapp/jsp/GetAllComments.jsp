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
<title>評論表多筆資料</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
<style>
#backButton {
	display: block;
	margin: 0 auto;
	margin-bottom: 20px;
}

table {
	width: 100%;
	border-collapse: collapse;
	border: 2px solid #ddd;
}

th, td {
	padding: 8px;
	text-align: center;
	border-bottom: 1px solid #ddd;
	word-wrap: break-word;
	white-space: pre-line;
	max-width: 300px;
}

tr:hover {
	background-color: #f5f5f5;
}

.delete, .update {
	text-decoration: none;
	color: #333;
}

.delete:hover, .update:hover {
	color: red;
}

td img {
	vertical-align: middle;
}

.update {
	display: inline-block;
}

.delete {
	display: inline-block;
}
</style>
</head>
<body style='background-color: fdf5e6'>
	<button onclick="redirectToHomepage()" id="backButton">返回首頁</button>
	<div align="center">
		<h2>評論表資料</h2>
		<table border="1" id="table_id">
			<tr style="background-color: #a8fefa">
				<th>使用者編號
				<th>名字
				<th>類型
				<th>評論內容</th>
				<th>服務評價
				<th>評論建立時間
				<th>評論修改時間
				<th>刪除
				<th>修改 <%
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
					alt="star" width="20" height="20"> <%
 }
 %>
				
				<td><%=formatDate((com.getCommentTime()))%>
				<td><%=formatDate(com.getLastmodifiedtime())%>
				<td><a
					href="http://localhost:8080/Comment/DeleteCommentAll?id=<%=com.getUserID()%>"
					class="delete" data-userid="<%=com.getUserID()%>"><i class="fa-solid fa-delete-left"></i></a>
				<td><a
					href="http://localhost:8080/Comment/html/edit_commentAll.html?id=<%=com.getUserID()%>"
					class="update"><i class="fa-solid fa-pen"></i></a></td>
				<%
				}
				%>
			
		</table>
		<h3>
			共<%=coms.size()%>筆評論資料
		</h3>

	</div>
	<script>
		

		
	$(".delete").on('click', function(e) {
	    e.preventDefault();
	    var deleteLink = $(this).attr('href');
	    var userID = $(this).data('userid'); // 获取要删除的评论的Userid
	    Swal.fire({
	        title: "你確定要刪除使用者編號為 " + userID + " 的資料嗎?",
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