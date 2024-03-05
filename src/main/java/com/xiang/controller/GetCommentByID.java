package com.xiang.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiang.bean.CommentBean;
import com.xiang.dao.CommentDAO;


@WebServlet("/GetCommentByID")
public class GetCommentByID extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public GetCommentByID() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String userID= request.getParameter("userID");
		CommentBean com=new CommentDAO().getCommentByUserID(Integer.parseInt(userID));
		request.setAttribute("com", com);
		response.setContentType("text/html;charset=UTF-8");
		if(com!=null) {
		request.getRequestDispatcher("/jsp/GetComment.jsp").forward(request, response);
		}else {	
			PrintWriter out = response.getWriter();
			out.print("沒有該筆使用者的評論資料");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
