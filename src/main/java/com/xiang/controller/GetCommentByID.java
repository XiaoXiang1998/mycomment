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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String userID = request.getParameter("userID");
		CommentBean com = new CommentDAO().getCommentByUserID(Integer.parseInt(userID));
		request.setAttribute("com", com);
		response.setContentType("text/html;charset=UTF-8");
		if (com != null) {
			request.getRequestDispatcher("/jsp/GetComment.jsp").forward(request, response);
		} else {
			PrintWriter out = response.getWriter();
		    out.println("<!DOCTYPE html>");
		    out.println("<html>");
		    out.println("<head>");
		    out.println("<meta charset='UTF-8'>");
		    out.println("<title></title>");
		    out.println("<style>");
		    out.println("table {width: 100%; border-collapse: collapse;}");
		    out.println("th, td {padding: 8px; text-align: left; border-bottom: 1px solid #ddd;}");
		    out.println("th {background-color: #f2f2f2;}");
		    out.println("tr:hover {background-color: #f5f5f5;}");
		    out.println("button {display: block; margin: 20px auto 0;}"); 
		    out.println("</style>");
		    out.println("</head>");
		    out.println("<body>");
		    out.println("<table>");
		    out.println("<tr style='background-color: #a8fefa'>");
		    out.println("<th>編號</th>");
		    out.println("<th>名字</th>");
		    out.println("<th>類型</th>");
		    out.println("<th>評論內容</th>");
		    out.println("<th>服務評價</th>");
		    out.println("<th>評論建立時間</th>");
		    out.println("<th>評論修改時間</th>");
		    out.println("<th>刪除</th>");
		    out.println("<th>修改</th>");
		    out.println("</tr>");
		    out.println("<tr>");
		    out.println("<td colspan='9'>沒有該筆使用者的評論資料</td>");
		    out.println("</tr>");
		    out.println("</table>");
		    out.println("<button onclick=\"redirectToHomepage()\">返回首頁</button>");
		    out.println("<script>");
		    out.println("function redirectToHomepage() {");
		    out.println("    window.location.href = 'http://localhost:8080/Comment/html/index.html';");
		    out.println("}");
		    out.println("</script>");
		    out.println("</body>");
		    out.println("</html>");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
