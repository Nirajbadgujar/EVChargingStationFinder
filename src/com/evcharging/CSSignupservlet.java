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
 * Servlet implementation class CSSignupservlet
 */
public class CSSignupservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CSSignupservlet() {
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
			

			String name=request.getParameter("stationname");
			String address=request.getParameter("address");
			String city=request.getParameter("city");
			String district=request.getParameter("district");
			String taluka=request.getParameter("taluka");
			String opentime=request.getParameter("opentime");
			String closetime=request.getParameter("closetime");
			String email=request.getParameter("email");
			String mobileno=request.getParameter("mobileno");
			long mobileno2=Long.parseLong(mobileno);
			String latitude=request.getParameter("latitude");
			String longitude=request.getParameter("longitude");
			int power=Integer.parseInt(request.getParameter("power"));
			String password=request.getParameter("password");
			
			
			try {
				PreparedStatement pstmt1=con.prepareStatement("insert into chargingstation values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				pstmt1.setInt(1, 0);
				pstmt1.setString(2, name);
				pstmt1.setString(3, address);
				pstmt1.setString(4, city);
				pstmt1.setString(5, district);
				pstmt1.setString(6, taluka);
				pstmt1.setString(7, opentime);
				pstmt1.setString(8, closetime);
				pstmt1.setString(9, email);
				pstmt1.setLong(10, mobileno2);
				pstmt1.setString(11, latitude);
				pstmt1.setString(12, longitude);
				pstmt1.setInt(13, power);
				pstmt1.setString(14, password);
				pstmt1.setString(15, "Not approved");
				
			
				int s=pstmt1.executeUpdate();
		
			    	if(s>0){
			    		response.sendRedirect("CSDashboard.html");
			    	}
			    	else{
			    		response.sendRedirect("chargingstationsignup.html");
			    	}


		
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}

}
