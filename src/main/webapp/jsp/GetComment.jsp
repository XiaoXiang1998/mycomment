<%@page import="java.util.*, com.xiang.bean.CommentBean,java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%!public String formatDate(long date) {
	
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    return sdf.format(date);
} %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>評論資料</title>
<jsp:useBean id="com" scope="request" class="com.xiang.bean.CommentBean" />

</head>
<body style='background-color:fdf5e6'>
    <div align="center">    
    <h2>評論表資料</h2>
    <table border="1">    
    <tr style="background-color:#a8fefa">
    <th>ID<th>Name<th>Type<th>CommentContent<th>Rate<th>CommentTime<th>Lastmodifiedtime<th>delete<th>update
    <tr>
        <td><%= com.getUserID() %></td>
                <td><%= com.getUsername() %></td>
                <td><%= com.getUserType() %></td>
                <td><%= com.getCommentContent() %></td>
                <td><%= com.getRate() %></td>
                <td><%= formatDate(com.getCommentTime()) %></td>
                <td><%= formatDate(com.getLastmodifiedtime()) %></td>
        <td><a href="http://localhost:8080/Comment/DeleteComment?id=<%=com.getUserID()%>">刪除</a></td>
		<td><a href="http://localhost:8080/Comment/html/edit_comment.html?id=<%=com.getUserID()%>">修改</a></td>
    </tr>
    </table>
    </div>
    
</body>
</html>