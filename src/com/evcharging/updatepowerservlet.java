package com.evcharging;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class updatepowerservlet
 */
public class updatepowerservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatepowerservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		Connection con=Dbconnection.connect(); 
		
		
		int power=Integer.parseInt(request.getParameter("power"));
		int cid=getset.getCid();
		try{
		PreparedStatement psmt6=con.prepareStatement("update chargingstation set power=? where cid=?");
		psmt6.setInt(1,power);
		psmt6.setInt(2,cid);
		int re=psmt6.executeUpdate();
		
		if(re>0){
		response.sendRedirect("ViewCSCS.jsp");
		}
		else
		{
			
			response.sendRedirect("updatepower1.jsp");
		
		}
		
		}
				catch(Exception e)
		{
					e.printStackTrace();
		}
	}

}
