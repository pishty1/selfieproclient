<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>Home</title>
	</head>
	<body>
	<ul>
		<li><a href="<c:url value="/signout" />">Sign Out</a></li>
	</ul>
	<h3>Your Facebook Friends</h3>
	<ul>
	<c:forEach items="${friends}" var="friend">
		<li>
			<img src="http://graph.facebook.com/<c:out value="${friend.id}"/>/picture" align="middle"/><c:out value="${friend.name}"/>
			<c:forEach items="${friend.extraData}" var="entry">
<%--     		i		Key = ${entry.key}, value = ${entry.value}<br> --%>
    				<c:out value="$$${entry.key}, ${entry.value}££"></c:out>
			</c:forEach>
		</li>
	</c:forEach>
	</ul>	
	</body>
</html>