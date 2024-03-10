package com.xiang.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiang.bean.CommentBean;
import com.xiang.dao.CommentDAO;

@WebServlet("/InsertComment2")
public class InsertComment2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InsertComment2() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	    CommentBean com = new CommentBean();

	    String userID = request.getParameter("UserID");
	    String username = request.getParameter("Username");
	    String userType = request.getParameter("UserType");
	    String commentContent = request.getParameter("CommentContent");
	    int rate = Integer.parseInt(request.getParameter("rate"));

	    if (new CommentDAO().isUserIDExists(userID)) {
	       
	        response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        out.println("<script type=\"text/javascript\">");
	        out.println("alert('已有相同的使用者ID');");
	        out.println("window.history.back();");
	        out.println("</script>");
	        return;
	    }

	    com.setUserID(Integer.parseInt(userID));
	    com.setUsername(username);
	    com.setUserType(userType);
	    com.setCommentContent(commentContent);
	    com.setRate(rate);
	    long currentTimeMillis = System.currentTimeMillis();
	    com.setCommentTime(currentTimeMillis);
	    com.setLastmodifiedtime(currentTimeMillis);

	    new CommentDAO().insertComment(com);
	    request.setAttribute("com", com);

	    request.getRequestDispatcher("/jsp/InsertComment.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
