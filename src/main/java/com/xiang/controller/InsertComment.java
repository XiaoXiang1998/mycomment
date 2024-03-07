package com.xiang.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiang.bean.CommentBean;
import com.xiang.dao.CommentDAO;

@WebServlet("/InsertComment")
public class InsertComment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InsertComment() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		CommentBean com = new CommentBean();
		com.setUserID(Integer.parseInt(request.getParameter("UserID")));
		com.setUsername(request.getParameter("Username"));
		com.setUserType(request.getParameter("UserType"));
		com.setCommentContent(request.getParameter("CommentContent"));
	    com.setRate(Integer.parseInt(request.getParameter("rate")));
	    Timestamp currentTime = new Timestamp(System.currentTimeMillis());
	    long commentTimeInMillis = currentTime.getTime(); // 获取毫秒时间戳
	    com.setCommentTime(commentTimeInMillis);
	    com.setLastmodifiedtime(commentTimeInMillis);
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
