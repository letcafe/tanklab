<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${test}
<c:forEach items="${fileList}" var="list">
    <p><c:out value="${list.id}"></c:out></p>
    <p><c:out value="${list.fileName}"></c:out></p>
    <p><c:out value="${list.uploadTime}"></c:out></p>
</c:forEach>
</body>
</html>
