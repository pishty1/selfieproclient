<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>Sign In</title>
	</head>
	<body>
		<form action="<c:url value="/signin/facebook" />" method="POST">
		    <input type="hidden" name="scope" value="email,publish_stream,offline_access" />		    
		    <button type="submit">Sign in with Facebook</button>
		</form>
	</body>
</html>
