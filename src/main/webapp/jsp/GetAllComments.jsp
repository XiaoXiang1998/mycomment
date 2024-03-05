<%@page import="java.sql.Time"%>
<%@page import="com.xiang.bean.CommentBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.xiang.bean.CommentBean,java.text.SimpleDateFormat" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%! @SuppressWarnings("unchecked") public String formatDate(long date) {
	
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    return sdf.format(date);
} %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>評論資料</title>
</head>
<body style='background-color:fdf5e6'>
	<div align="center">	
	<h2>評論表資料</h2>
	<table border="1">	
	<tr style="background-color:#a8fefa">
	<th>ID<th>Name<th>Type<th>CommentContent<th>Rate<th>CommentTime<th>Lastmodifiedtime<th>delete<th>update
	<% List<CommentBean> coms=(ArrayList<CommentBean>)request.getAttribute("coms"); 
	for(CommentBean com:coms){	%>
	<tr><td><%=com.getUserID() %>
	<td><%=com.getUsername() %>
	<td><%=com.getUserType() %>
	<td><%=com.getCommentContent() %>
	<td><%=com.getRate() %>
	<td><%=formatDate((com.getCommentTime())) %>
	<td><%=formatDate(com.getLastmodifiedtime()) %>
	<td><a href="http://localhost:8080/Comment/DeleteComment?id=<%=com.getUserID()%>">刪除</a>
	<td><a href="http://localhost:8080/Comment/html/edit_comment.html?id=<%=com.getUserID()%>">修改</a></td>	<% } %>
	</table>
	<h3>共<%=coms.size() %>筆評論資料</h3>
	</div>
	<script>
    
</script>
</body>
</html>