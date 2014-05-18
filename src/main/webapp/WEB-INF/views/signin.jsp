<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<t:daddy pageNumber='1'>
<form action="<c:url value="/signin/facebook" />" method="POST">
		    <input type="hidden" name="scope" value="email,publish_stream,offline_access" />		    
		    <button type="submit">Sign in with THE Facebook BUTTON</button>
		</form>
</t:daddy>
