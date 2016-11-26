<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<%@ page isELIgnored="false" %>
<title>Sports Mate</title>
</head>
	<body>
	<c:if test="${!empty error}">
		<div style="color: #D8000C;background-color: #FFBABA;">
			<c:out value="Error: ${error}" />
		</div>
	</c:if>	
	<form method="post" action="<c:url value="/ui/search.do"/>">
	<table>
	<tr>
	<td>ISBN Code:</td>
	
	<td><input type="text" name="isbncode" size="10" /></td>
	
	<td>Book Category:</td>
	<td>
		<select name="bookcategories">
			<option value="-1">-Select Category-</option>
			<option value="java">java</option>
			<option value="c">c</option>
			<option value="c++">c++</option>
			<option value="php">php</option>
		</select>
	</td>
	<td>
		<input type="submit" value="Search Book" />
	</td>
	</tr>
	</table>
	</form>
	</body>
</html>