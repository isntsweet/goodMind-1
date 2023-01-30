<%@ page language="java" import="java.io.*,
                                 java.net.*,
                                 org.json.*" %>
<%
    String userMessage = request.getParameter("userMessage");
    String chatbotResponse = "";
    if (userMessage != null && !userMessage.isEmpty()) {
        // Connect to Naver Chatbot API
        URL url = new URL("https://openapi.naver.com/v1/dialogue/api/v1/chat");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Authorization", "Bearer [API_KEY]");
        con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        String postParams = "query=" + userMessage;
        con.setDoOutput(true);
        con.getOutputStream().write(postParams.getBytes("UTF-8"));
        int responseCode = con.getResponseCode();
        if (responseCode == 200) {
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder Response = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                Response.append(line);
            }
            br.close();
            // Parse JSON response
            JSONObject json = new JSONObject(response.toString());
            chatbotResponse = json.getJSONObject("message").getString("resultText");
        }
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Naver Chatbot JSP</title>
</head>
<body>
    <form action="chatbot/gibuni" method="post">
        <input type="text" name="userMessage">
        <input type="submit" value="Submit">
    </form>
    <%= chatbotResponse %>
</body>
</html>
