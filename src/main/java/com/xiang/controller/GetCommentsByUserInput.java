package com.xiang.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiang.bean.CommentBean;
import com.xiang.dao.CommentDAO;


@WebServlet("/GetCommentsByUserInput")
public class GetCommentsByUserInput extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public GetCommentsByUserInput() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");
		    String keyword = request.getParameter("keyword");

		    if (keyword != null && !keyword.isEmpty()) {
		        List<CommentBean> comments = new CommentDAO().getCommentsByUserInput(keyword);
		        if (comments != null && !comments.isEmpty()) {
		            request.setAttribute("coms", comments);
		            request.getRequestDispatcher("/jsp/GetAllComments.jsp").forward(request, response);
		        } else {
		        	 response.setContentType("text/html;charset=UTF-8");
		             PrintWriter out = response.getWriter();
		             out.println("<h2>抱歉，沒有找到與關鍵字匹配的評論。</h2>");
		             out.println("<button onclick=\"redirectToPreviousStep()\">返回上一步</button>");
		             out.println("<script>");
		             out.println("function redirectToPreviousStep() {");
		             out.println("    window.location.href = 'http://localhost:8080/Comment/html/userinput.html';");
		             out.println("}");
		             out.println("</script>");
		        }
		    } else {
		    	response.setContentType("text/html;charset=UTF-8");
		        PrintWriter out = response.getWriter();
		        out.println("<h2>請輸入關鍵字進行搜索。</h2>");
		        out.println("<button onclick=\"redirectToPreviousStep()\">返回上一步</button>");
		        out.println("<script>");
		        out.println("function redirectToPreviousStep() {");
		        out.println("    window.location.href = 'http://localhost:8080/Comment/html/userinput.html';");
		        out.println("}");
		        out.println("</script>");
		    }
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
