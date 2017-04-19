<%-- <ul class="sb_menu" style="font-weight: bold;text-transform: uppercase;">
<li style="border-bottom: 1px solid black;border-right: 1px solid black;">
<b><a href="<%=request.getContextPath() %>/admin/addbranch.jsp">Add Branch</a></b>
</li>
<li style="border-bottom: 1px solid black;border-right: 1px solid black;">
<a href="<%=request.getContextPath() %>/authorbooks">Add Book Copy</a>
</li>

<li style="border-bottom: 1px solid black;border-right: 1px solid black;">
<a href="<%=request.getContextPath() %>/admin/Author.jsp">Add Author</a>
</li>

<li style="border-bottom: 1px solid black;border-right: 1px solid black;">
<a href="<%=request.getContextPath() %>/admin/publisher.jsp">Add Publisher</a>
</li>

<li style="border-bottom: 1px solid black;border-right: 1px solid black;">
<b><a href="<%=request.getContextPath() %>/BooksBranchMapLoad">Add Books To Branch</a></b>
</li>

<li style="border-bottom: 1px solid black;border-right: 1px solid black;"><a href="#">Search book copy and check its status</a></li>
<li style="border-bottom: 1px solid black;border-right: 1px solid black;"><a href="#">Add new reader.
</a></li>
<li style="border-bottom: 1px solid black;border-right: 1px solid black;"><a href="#">Print branch information</a></li>
 <li style="border-bottom: 1px solid black;border-right: 1px solid black;"><a href="#">Print top 10 most frequent borrowers in a branch and the number of books each has
borrowed.</a></li>
  <li style="border-bottom: 1px solid black;border-right: 1px solid black;"><a href="#">Print top 10 most borrowed books in a branch.</a></li>
   <li style="border-bottom: 1px solid black;border-right: 1px solid black;"><a href="#">Find the average fine paid per reader.</a></li>
          </ul> --%>
          <link href="<%=request.getContextPath() %>/buttons/buttons.css" rel="stylesheet"  type="text/css" />
<link href="<%=request.getContextPath()%>/sidebar/accordion-menu.css"
	rel="stylesheet" />
<script src="<%=request.getContextPath()%>/sidebar/accordion-menu.js"></script>
<div id="panel1">
	<span data-panel="panel1" class="panel-button"
		style="margin: 0 30px 0 auto;"></span>
	<div id="accordion">
		<ul>
		<li><a href="<%=request.getContextPath() %>/admin/adminhomepage.jsp">My Profile</a></li>
			<li>
				<div>Manage Master Data</div>
				<ul>
					<li><a href="<%=request.getContextPath() %>/admin/addbranch.jsp">Add Branch</a></li>
					<li><a href="<%=request.getContextPath() %>/admin/Author.jsp">Add Author</a></li>
					<li><a href="<%=request.getContextPath() %>/admin/publisher.jsp">Add Publisher</a></li>
					<li><a href="<%=request.getContextPath() %>/authorbooks">Add Book Copy</a></li>
				</ul>
			</li>
			<li><a href="<%=request.getContextPath() %>/BooksBranchMapLoad">Add Books To Branch</a></li>
			<li><a href="<%=request.getContextPath() %>/admin/adminSearchBook.jsp">Search book</a></li>
<%-- <<<<<<< .mine
			<li><a href="<%=request.getContextPath() %>/addnewreader">Add New Reader</a></li>
||||||| .r30
			<li><a href="#">Add New Reader</a></li>
======= --%>
			<li><a href="<%=request.getContextPath() %>/GetRegisteredUsers">Add New Reader</a></li>
			<li>
				<div>View Reports</div>
				<ul>
					<li><a href="<%=request.getContextPath() %>/GetBranchInfo">Branch Information</a></li>
					<li><a href="<%=request.getContextPath() %>/BranchList">Top 10 Borrowers</a></li>
					<li><a href="<%=request.getContextPath() %>/BranchList?id=10">Top 10 Books Borrowed</a></li>
					<li><a href="<%=request.getContextPath()%>/AverageFine">Average Fine</a></li>
				</ul>
			</li>
			
			
		</ul>
	</div>
</div>