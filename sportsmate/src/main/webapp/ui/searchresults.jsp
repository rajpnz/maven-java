<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<%@ page isELIgnored="false" %>
<title>Book Results</title>
</head>
<body>
<h1>Book Search Results</h1>
<c:if test="${!empty error}">
	<div style="color: #D8000C;background-color: #FFBABA;">
		<c:out value="Error: ${error}" />
	</div>
</c:if>
<br>
ISBN: ${isbncode}
<br>
Book Category: ${bookcategories}
<br>
</body>
</html>