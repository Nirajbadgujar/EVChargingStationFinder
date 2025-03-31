<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@page import="java.sql.* "%>
<%@page import="com.evcharging.*" %>

<!DOCTYPE HTML>
<html>
<head>
<title>Admin view CS</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Glance Design Dashboard Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
SmartPhone Compatible web template, free WebDesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />

<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />

<!-- font-awesome icons CSS -->
<link href="css/font-awesome.css" rel="stylesheet"> 
<!-- //font-awesome icons CSS -->

 <!-- side nav css file -->
 <link href='css/SidebarNav.min.css' media='all' rel='stylesheet' type='text/css'/>
 <!-- side nav css file -->
 
 <!-- js-->
<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/modernizr.custom.js"></script>

<!--webfonts-->
<link href="//fonts.googleapis.com/css?family=PT+Sans:400,400i,700,700i&amp;subset=cyrillic,cyrillic-ext,latin-ext" rel="stylesheet">
<!--//webfonts--> 

<!-- Metis Menu -->
<script src="js/metisMenu.min.js"></script>
<script src="js/custom.js"></script>
<link href="css/custom.css" rel="stylesheet">
<!--//Metis Menu -->

</head> 
<body class="cbp-spmenu-push">
	<div class="main-content">
	<div class="cbp-spmenu cbp-spmenu-vertical cbp-spmenu-left" id="cbp-spmenu-s1">
		<!--left-fixed -navigation-->
		<aside class="sidebar-left">
      <nav class="navbar navbar-inverse">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".collapse" aria-expanded="false">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            </button>
            <h1><a class="navbar-brand" ><span class="fa fa-area-chart"></span> EV<span class="dashboard_text">Charging Station</span></a></h1>
          </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="sidebar-menu">
              <li class="header">MAIN NAVIGATION</li>
              <li class="treeview">
                <a href="adminViewUser.jsp">
                <i class="fa fa-dashboard"></i> <span>View all charging stations</span>
                </a>
              </li>
              <li class="treeview">
                <a href="CSapprove.jsp">
                <i class="fa fa-dashboard"></i> <span>Charging Station Approve</span>
                </a>
              </li>
              <li class="treeview">
                <a href="CSdelete.jsp">
                <i class="fa fa-dashboard"></i> <span>Charging Station Delete</span>
                </a>
              </li>
			  
          <!-- /.navbar-collapse -->
      </nav>
    </aside>
	</div>
		<!--left-fixed -navigation-->
		
		<!-- header-starts -->
		<div class="sticky-header header-section ">
			<div class="header-left">
				
				<!--toggle button start-->
				<button id="showLeftPush"><i class="fa fa-bars"></i></button>
				<!--toggle button end-->
				<div class="profile_details_left"><!--notifications of menu start -->
					<ul class="nofitications-dropdown">
						<li class="dropdown head-dpdn">
							
								
								 
						
						</li>	
					
						</li>	
					</ul>
					<div class="clearfix"> </div>
				</div>
				<!--notification menu end -->
				<div class="clearfix"> </div>
			</div>
			<div class="header-right">
				
				
				
				</div>
				<div class="clearfix"> </div>				
			</div>
			<div class="clearfix"> </div>	
		</div>
		<!-- //header-ends -->
		<!-- main content start-->
		<div id="page-wrapper">
			<div class="main-page">
				<div class="tables">
					
					<%Connection con=Dbconnection.connect(); 
					try{
					PreparedStatement psmt4=con.prepareStatement("select * from chargingstation");
					ResultSet r=psmt4.executeQuery();%>
					<div class="bs-example widget-shadow" data-example-id="bordered-table"> 
						<h4>View Charging Station Info</h4>
						<table class="table table-bordered"> 
						<thead> <tr> 
						<th>Sid</th>
						 <th>Station Name</th> 
						 <th>Address</th> 
						 <th>City</th> 
						 <th>District</th> 
						 <th>Taluka</th> 
						 <th>Open Time</th> 
						 <th>Close Time</th> 
						 <th>Email</th>
						  <th>Mobile No</th> 
						  <th>Latitude</th> 
						  <th>Longitude</th>
						   <th>Power</th> 
						    <th>Status</th>
						     </tr> 
						     </thead> 
						</div>
						
						<%while(r.next()){ %>
						<tr>
						<td><%=r.getInt(1) %></td>
						<td><%=r.getString(2) %></td>
						<td><%=r.getString(3) %></td>
						<td><%=r.getString(4) %></td>
						<td><%=r.getString(5) %></td>
						<td><%=r.getString(6) %></td>
						<td><%=r.getString(7) %></td>
						<td><%=r.getString(8) %></td>
						<td><%=r.getString(9) %></td>
						<td><%=r.getInt(10) %></td>
						<td><%=r.getString(11) %></td>
						<td><%=r.getString(12) %></td>
						<td><%=r.getString(13) %></td>
						
						<td><%=r.getString(15) %></td>
						</tr>
						<%}}
							catch(Exception e)
					{
								e.printStackTrace();
					}
							%>
						</table>
					
				</div>
			</div>
		</div>
		
	</div>
	
	<!-- side nav js -->
	<script src='js/SidebarNav.min.js' type='text/javascript'></script>
	<script>
      $('.sidebar-menu').SidebarNav()
    </script>
	<!-- //side nav js -->
	
	<!-- Classie --><!-- for toggle left push menu script -->
		<script src="js/classie.js"></script>
		<script>
			var menuLeft = document.getElementById( 'cbp-spmenu-s1' ),
				showLeftPush = document.getElementById( 'showLeftPush' ),
				body = document.body;
				
			showLeftPush.onclick = function() {
				classie.toggle( this, 'active' );
				classie.toggle( body, 'cbp-spmenu-push-toright' );
				classie.toggle( menuLeft, 'cbp-spmenu-open' );
				disableOther( 'showLeftPush' );
			};
			
			function disableOther( button ) {
				if( button !== 'showLeftPush' ) {
					classie.toggle( showLeftPush, 'disabled' );
				}
			}
		</script>
	<!-- //Classie --><!-- //for toggle left push menu script -->
	
	<!--scrolling js-->
	<script src="js/jquery.nicescroll.js"></script>
	<script src="js/scripts.js"></script>
	<!--//scrolling js-->
	
	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.js"> </script>
	
</body>
</html>