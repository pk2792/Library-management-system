<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.lms.model.BranchBO"%>
<%@page import="java.util.List"%>
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
function getData(val){
	$.ajax({
		url: "<%=request.getContextPath()%>/GetTopTenBook?bid="+val+"", 
		success: function(result){
        	$("#search").html(result);
			$("#searchtable").DataTable();
		}
	});
}

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
          <h2 align="center">Top Ten Books - Branch Wise</h2>
          <br/>
          <table align="center">
          	<tr>
          		<td><b>Select Branch : </b></td>
          		<td>
          		<select onchange="getData(this.value);">
          		<option value="-1">--Select--</option>
          		<%if(null != request.getAttribute("list")){ 
          		List<BranchBO> list = (List<BranchBO>) request.getAttribute("list");
          		for(BranchBO b : list){
          		%>
          		<option value="<%=b.getBranch_id()%>"><%=b.getBranch_name() %> (<%=b.getBranch_location() %>)</option>
          		<%}} %>
          		</select>
          		</td>
          	</tr>
          </table>
          <br/><br/>
          <div id="search"></div>
        </div>
      </div>
      <div class="clr"></div>
    </div>
  </div>
</div>
</body>
</html>
