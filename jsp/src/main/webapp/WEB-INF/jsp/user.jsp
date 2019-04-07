
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
    <body>
        <h3>One line of Java code</h3>
        <P>
            Date of today: <%=(new java.util.Date())%>
        </P>

        <h3>Multiple lines</h3>
        <P>
            Your IP address:
            <%
                out.println("Your IP address is " + request.getRemoteAddr() + "</br>");
                out.println("codes");
            %>
        </P>

        <h3>for loop</h3>
        <%
            int count = (int)session.getAttribute("count");
            for(int fontSize = 1; fontSize <= count; fontSize++) {
        %>
                simle
        <br />
        <%}%>

        <h3>Tag c:if</h3>
        <c:if test = "${username != null}">
            <p>username: username</p>
        </c:if>

        <h3>Tag c:choose</h3>
        <c:choose>
            <c:when test = "${salary <= 0}">
                poor guy.
            </c:when>
            <c:when test = "${salary > 1000}">
                nice life.
            </c:when>
            <c:otherwise>
                nothing at all.
            </c:otherwise>
        </c:choose>

        <h3>layout</h3>
        <%@ include file = "footer.jsp"%>
    </body>
</html>

