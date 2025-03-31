package com.evcharging;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class userloginservlet
 */
public class userloginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userloginservlet() {
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
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		try {
			
			PreparedStatement psmt=con.prepareStatement("select * from user where email=? and password=?");
		    psmt.setString(1,email);
		    psmt.setString(2,password);
		    ResultSet re=psmt.executeQuery();
		    int i=0;
		    while(re.next())
		    {
		    	i=1;
		    	int uid=re.getInt(1);
		    	getsetuid.setUid(uid);
		    }
		    	if(i>0){
		    		response.sendRedirect("userDashboard.html");
		    		
		    	}
		    	else{
		    		response.sendRedirect("userlogin.html");
		    	}
		    
		    	
		    

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
