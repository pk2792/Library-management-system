<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.util.List"%>
<%@page import="com.lms.model.BranchBO"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>LMS</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=request.getContextPath() %>/blue_shuffle_template_808/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=request.getContextPath() %>/blue_shuffle_template_808/js/cufon-yui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/blue_shuffle_template_808/js/arial.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/blue_shuffle_template_808/js/cuf_run.js"></script>
<link href="<%=request.getContextPath() %>/datatable/jquery.dataTables.min.css" rel="stylesheet"  type="text/css" />
<script src="<%=request.getContextPath() %>/datatable/jquery-1.12.0.min.js"></script>
<script src="<%=request.getContextPath() %>/datatable/jquery.dataTables.min.js"></script>
<script>
$(document).ready(function(){
	$("#branch").DataTable();
});
</script>
</head>
<body>
<div class="main">
<!-- header start -->
<%@ include file="/commonjsps/adminafterloginheader.jsp" %>
  <!--   header ends -->
  <div class="content">
    <div class="content_resize">
    
    <div class="sidebar">
        <div class="gadget">
<!--           <h2 class="star"><span>Admin</span> Functionalities</h2> -->
          <div class="clr"></div>
          <%@include file="/admin/adminleftmenu.jsp" %>
        </div>
        
      </div>
      
      <div class="mainbar">
        <div class="article">
          <h2 align="center">Branch Information</h2>
          <%if(null != request.getAttribute("branch")){ 
          	List<BranchBO> list = (List<BranchBO>) request.getAttribute("branch");
          %>
          <table align="center" width="100%" id="branch" class="display">
          	<thead>
          		<tr align="center">
          			<th> Sr No.</th>
          			<th>Branch Id</th>
          			<th>Branch Name</th>
          			<th>Branch Location</th>
          		</tr>
          	</thead>
          	<tbody>
          	<%int i=1;for(BranchBO b : list){ %>
          		<tr align="center">
          			<td><%=i++ %></td>
          			<td><%=b.getBranch_id() %></td>
          			<td><%=b.getBranch_name() %></td>
          			<td><%=b.getBranch_location() %></td>
          		</tr>
          	<%} %>
          	</tbody>
          </table>
          <%} %>
        </div>
      </div>
      <div class="clr"></div>
    </div>
  </div>
</div>
</body>
</html>
