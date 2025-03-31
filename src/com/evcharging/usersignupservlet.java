package com.evcharging;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class usersignupservlet
 */
public class usersignupservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public usersignupservlet() {
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
		

		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String mobileno=request.getParameter("mobileno");
		long mobileno2=Long.parseLong(mobileno);
		String city=request.getParameter("city");
		String password=request.getParameter("password");
		
		
		try {
			PreparedStatement pstmt1=con.prepareStatement("insert into user values(?,?,?,?,?,?)");
			pstmt1.setInt(1, 0);
			pstmt1.setString(2, name);
			pstmt1.setString(3, email);
			pstmt1.setLong(4, mobileno2);
			pstmt1.setString(5, city);
			pstmt1.setString(6, password);
		
			int s=pstmt1.executeUpdate();
	
		    	if(s>0){
		    		response.sendRedirect("userDashboard.html");
		    	}
		    	else{
		    		response.sendRedirect("usersignup.html");
		    	}


	
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
