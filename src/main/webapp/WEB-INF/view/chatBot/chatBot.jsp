<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GPT-3 Viewer</title>
</head>
<body>
    <form action="gpt3" method="post">
        <label>Enter your prompt:</label>
        <input type="text" name="prompt" id="prompt" size="50" required>
        <input type="submit" value="Submit">
    </form>
    <br>
    <label>Generated text:</label>
    <div id="result">
        <c:out value="${result}" default="No results yet."/>
    </div>
</body>
</html>