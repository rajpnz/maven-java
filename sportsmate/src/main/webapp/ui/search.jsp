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
	
	<td><input type="text" name="isbncode" size="10" value="${isbncode}"/></td>
	
	<td>Book Category:</td>
	<td>
		<select name="bookcategories" >
			<option value="-1" ${ '-1'  == bookcategories ? 'selected="selected"' : ''}>-Select Category-</option>
			<option value="java" ${ 'java'  == bookcategories ? 'selected="selected"' : ''}>java</option>
			<option value="c" ${ 'c'  == bookcategories ? 'selected="selected"' : ''}>c</option>
			<option value="c++" ${ 'c++'  == bookcategories ? 'selected="selected"' : ''}>c++</option>
			<option value="php" ${ 'php'  == bookcategories ? 'selected="selected"' : ''}>php</option>
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