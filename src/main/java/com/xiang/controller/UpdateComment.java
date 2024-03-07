package com.xiang.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiang.bean.CommentBean;
import com.xiang.dao.CommentDAO;

@WebServlet("/UpdateComment")
public class UpdateComment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateComment() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("commentID");
		String comment = request.getParameter("editComment");
		CommentBean com = new CommentBean();
		long lastModifiedTime = System.currentTimeMillis();
		com.setCommentContent(comment);
		com.setLastmodifiedtime(lastModifiedTime);
		com.setUserID(Integer.parseInt(id));
		new CommentDAO().updateComment(com);

		response.sendRedirect("http://localhost:8080/Comment/GetCommentByID?userID=" + id);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
