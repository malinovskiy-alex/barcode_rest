<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: malinovsky
  Date: 9/17/2014
  Time: 7:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Barcode records</title>
</head>
<body>
<div align="center">
    <table border="1" id="barcodes" style="width:50%">
        <tr style="text-align: center; font-weight:bold">
            <td>UN location code</td>
            <td>Entry type</td>
            <td>Barcode</td>
        </tr>
        <c:forEach items="${barcodes}" var="item">
            <tr>
                <td>${item.locationCode}</td>
                <td>${item.type}</td>
                <td>${item.barcode}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
