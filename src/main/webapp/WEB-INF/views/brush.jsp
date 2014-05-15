<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:daddy pageNumber='2'>
	<div class="col-lg-12">
		<div class="page-header">
			<h1 id="navbar">this is your brush</h1>
		</div>
	</div>
	<div class="bs-example table-responsive">
		<table class="table table-striped table-hover ">
			<tbody>
				<tr>
					<th>#</th>
					<th>subject</th>
					<th>minEntries</th>
					<th>reward</th>
				</tr>
				<c:forEach var="pen" items="${pens}">
					<tr class="active" onclick="document.location = 'pen/${pen.id}';">
						<td><c:out value="${pen.id}" /></td>
						<td><c:out value="${pen.write}" /></td>
						<td><c:out value="${pen.minEntries}" /></td>
						<td><c:out value="${pen.reward}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</t:daddy>