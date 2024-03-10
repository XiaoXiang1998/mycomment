package com.xiang.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiang.dao.CommentDAO;

@WebServlet("/DeleteComment")
public class DeleteComment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteComment() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String commentId = request.getParameter("id");

		if (!commentId.isEmpty()) {

			int id = Integer.parseInt(commentId);
			new CommentDAO().deleteComment(id);
		}

		response.sendRedirect("http://localhost:8080/Comment/GetCommentByID?userID="+commentId);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
