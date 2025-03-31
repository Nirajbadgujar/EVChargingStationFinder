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
 * Servlet implementation class bookstationservlet
 */
public class bookstationservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bookstationservlet() {
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
		String stationname=null;
		int upower,stpower = 0;
		int uid=getsetuid.getUid();
		int cid=Integer.parseInt(request.getParameter("cid"));
		int power=Integer.parseInt(request.getParameter("power"));
		String timeslot=request.getParameter("timeslot");
		Connection con=Dbconnection.connect();
		try {
			PreparedStatement psmt11=con.prepareStatement("select * from chargingstation where cid=? and status='Approved' ");
			psmt11.setInt(1,cid);
			ResultSet z=psmt11.executeQuery();
			
			while(z.next()){
				 stationname=z.getString(2);
				 stpower=z.getInt(13);
			}
			
			PreparedStatement psmt12=con.prepareStatement("insert into booking values(?,?,?,?,?,?)");
			psmt12.setInt(1, 0);
			psmt12.setInt(2, uid);
			psmt12.setInt(3, power);
			psmt12.setInt(4, cid);
			psmt12.setString(5, stationname);
			psmt12.setString(6, timeslot);
			int s=psmt12.executeUpdate();
			if(s>0){
				response.sendRedirect("ViewCSuser.jsp");
			}
			else{
				response.sendRedirect("bookstation.jsp");

			}
			upower=stpower-power;
			PreparedStatement psmt13=con.prepareStatement("update chargingstation set power=? where cid=?");
			psmt13.setInt(1,upower);
			psmt13.setInt(2,cid);
			if(upower<0){
			}
			else if(upower>stpower){

			}
			else{
					psmt13.executeUpdate();
			}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
