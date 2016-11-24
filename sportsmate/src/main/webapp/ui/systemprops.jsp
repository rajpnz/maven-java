<%@page import="java.util.Properties"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>System properties page</title>
</head>
<body>
<h2>System Properties</h2>
<br>
<%
Properties props = System.getProperties();
out.print("<table border=\"1\">");
for (Object key : props.keySet()) {
    out.print("<tr><td>" + key + "</td><td>" + props.get(key) + "</td></tr>");
}
out.print("</table>");
%>

</body>
</html>