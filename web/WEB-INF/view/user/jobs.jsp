<%@include file="header.jsp" %>
<div class="container">
	<a class="btn btn-default pull-right" href="jobAdd?jobId=0">Add Job</a>
	<table class="table table-hover">
		<c:forEach items="${jobsList}" var ="job" >
			<tr>
				<td>
				<a href="<c:url value="jobAdd?jobId=${job.jobId}"/>"><c:out value="${job.title}" /></a>
				
				</td>
			</tr>
		</c:forEach>
	</table>
</div>
</html>