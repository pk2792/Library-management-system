	<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>LMS</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=request.getContextPath() %>/blue_shuffle_template_808/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=request.getContextPath() %>/blue_shuffle_template_808/js/cufon-yui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/blue_shuffle_template_808/js/arial.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/blue_shuffle_template_808/js/cuf_run.js"></script>
<script src="<%=request.getContextPath() %>/datatable/jquery-1.12.0.min.js"></script>
<link href="<%=request.getContextPath() %>/buttons/buttons.css" rel="stylesheet"  type="text/css" />
<script>
$(document).ready(function(){
	setTimeout(function() {
	    $('#msg').fadeOut('fast');
	}, 5000); // <-- time in milliseconds
});

</script>
<script type="text/javascript">
function checkname(a){
	$.ajax({
		url: "<%= request.getContextPath()%>/CheckBranch?bname="+a, 
		success: function(result){
        	if(result){
				alert("Branch By Same Name Already Exists !!!");
				document.getElementById("bname").value = "";
            }
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
<!--           <h2 class="star"><span>Sidebar</span> Menu</h2> -->
          <div class="clr"></div>
          <%@include file="/admin/adminleftmenu.jsp" %>
        </div>
        
      </div>
      
      <div class="mainbar">
        <div class="article">
        
<form method="post" action="<%=request.getContextPath() %>/AddBranch">
<h2 align="center">Add Branch</h2>
<table align="center" style="font-size: 18px;">

<tr>
	<td><b>Branch Name : </b> </td>
	<td> <input type="text" name="bname" id="bname" required/></td>
</tr>
<tr><td colspan="2" style="padding-top: 5px;"></td></tr>
<tr>
	<td> <b>Branch Location : </b></td>
	<td> <input type="text" name="bloc" id="bloc" required/></td>
</tr>
<tr><td colspan="2" style="padding-top: 5px;"></td></tr>
<tr align="center">
	<td colspan="2"> <input class="button button-3d button-primary button-rounded" type="submit" value="Add Branch"/></td>
</tr>

</table>

</form>
<br/>
<%if(null != request.getAttribute("msg")){ %>
<div align="center" id="msg" style="font-size: 17px;font-weight: bold;"><%= request.getAttribute("msg") %></div>
<%} %>

         
        </div>
      </div>
      <div class="clr"></div>
    </div>
  </div>
 
  </div>
</body>
</html>
