package com.xiang.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiang.bean.CommentBean;
import com.xiang.dao.CommentDAO;

@WebServlet("/GetAllComments")
public class GetAllComments extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetAllComments() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		List<CommentBean> coms = new CommentDAO().getAllComments();

		request.setAttribute("coms", coms);
		request.getRequestDispatcher("/jsp/GetAllComments.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
