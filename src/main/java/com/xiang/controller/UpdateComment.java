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

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		CommentBean com=new CommentBean();
		com.setUserID(Integer.parseInt(request.getParameter("id")));
		com.setCommentContent(request.getParameter("editComment"));
		new CommentDAO().updateComment(com);
		
	    response.sendRedirect("http://localhost:8080/Comment/GetAllComments");

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
