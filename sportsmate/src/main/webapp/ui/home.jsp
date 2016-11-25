<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<%@ page isELIgnored="false" %>
<title>Sports Mate</title>
</head>
<body>
<h1>Message : ${rajmessage}</h1>
<c:if test="${!empty error}">
	<div style="color: #D8000C;background-color: #FFBABA;">
		<c:out value="Error: ${error}" />
	</div>
</c:if>
<br>
    <c:if test="${!empty warrnames}">
        <c:forEach items="${warrnames}" var="name" varStatus="loop">
            <c:out value="${name}" />
            <br>
        </c:forEach>
    </c:if>
</body>
</html>