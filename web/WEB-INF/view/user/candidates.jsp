<%@include file="header.jsp" %>
<div class="container">
	<a class="btn btn-default pull-right" href="candidateAdd?canId=0">Add Candidate</a>
	<table class="table table-hover">
		<c:forEach items="${candidatesList}" var ="candidate" >
			<tr>
				<td>
				<a href="<c:url value="candidateAdd?canId=${candidate.candidateId}"/>"><c:out value="${candidate.name}" /></a>
				
				</td>
			</tr>
		</c:forEach>
	</table>
</div>
</html>