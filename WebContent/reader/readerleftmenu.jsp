<%-- <ul class="sb_menu" style="font-weight: bold;text-transform: uppercase;">

<li style="border-bottom: 1px solid black;border-right: 1px solid black;">
<b><a href="<%=request.getContextPath() %>/admin/addbranch.jsp">My Books</a></b>
</li>

<li style="border-bottom: 1px solid black;border-right: 1px solid black;">
<b><a href="<%=request.getContextPath() %>/LoadsearchBook">Search Book</a></b>
</li>

<li style="border-bottom: 1px solid black;border-right: 1px solid black;">
<b><a href="<%=request.getContextPath() %>/LoadCheckout">Checkout</a></b>
</li>

<li style="border-bottom: 1px solid black;border-right: 1px solid black;">
<a href="#">Book Return</a>
</li>

<li style="border-bottom: 1px solid black;border-right: 1px solid black;">
<a href="#">Book Reserve</a>
</li>

<li style="border-bottom: 1px solid black;border-right: 1px solid black;">
<a href="#">Check Fine</a>
</li>

<li style="border-bottom: 1px solid black;border-right: 1px solid black;">
<b><a href="#">Reserved Books and Its Status</a></b>
</li>

<li style="border-bottom: 1px solid black;border-right: 1px solid black;"><a href="#">Books By Publisher</a></li>

</ul>
 --%>
 
 <link href="<%=request.getContextPath()%>/sidebar/accordion-menu.css"
	rel="stylesheet" />
<script src="<%=request.getContextPath()%>/sidebar/accordion-menu.js"></script>
<div id="panel1">
	<span data-panel="panel1" class="panel-button"
		style="margin: 0 30px 0 auto;"></span>
	<div id="accordion">
		<ul>
		<li><a href="#">My Profile</a></li>
<%-- 		<li><a href="<%=request.getContextPath() %>/LoadsearchBook">Search Book</a></li> --%>
			<li>
				<div>Borrow Books</div>
				<ul>
					<li><a href="<%=request.getContextPath() %>/LoadsearchBook">Search Book</a></li>
					<li><a href="<%=request.getContextPath()%>/LoadViewBorrowedBook">View/Return Borrowed Books</a>
					<li><a href="<%= request.getContextPath()%>/LoadCheckFine">Check Fine</a></li>
				</ul>
			</li>
			<li>
				<div>Reserve Books</div>
				<ul>
					<li><a href="<%=request.getContextPath()%>/LoadreserveBook">Reserve Book</a></li>
					<li><a href="<%=request.getContextPath()%>/LoadViewReserveBook">View/Checkout Reserved Book</a></li>
				</ul>
			</li>
			<li><a href="<%=request.getContextPath() %>/Logout">Logout</a></li>
		</ul>
	</div>
</div>
