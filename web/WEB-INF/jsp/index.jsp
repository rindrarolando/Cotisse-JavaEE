<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="requete.*,models.*,java.util.*,java.util.ArrayList,connexion.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
        <p>Notes ! Cette page est encore une page pour tester les codes mais va changer une fois toutes<br>
            les requêtes finies</p><br>
        <%String[] title = new Requete().getTitle("Patient");%>
        <form action ="#" method="POST">
            <%for(int i = 0 ; i < title.length ; i++) {%>
                <label><%out.println(title[i] + " : ");%><input type="text" name="<%out.println(title[i]);%>" placeholder="<%out.println(title[i]);%>"></label><br>
            <%}%>
            <input type="submit" value="rechercher">
        </form>
    </body>
</html>
