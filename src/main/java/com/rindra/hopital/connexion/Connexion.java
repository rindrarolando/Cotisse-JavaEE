package com.rindra.hopital.connexion;

import java.sql.*;

public class Connexion {
    private Connection connection;
    private Statement statement;
    private ResultSet resultset;

    public String username = "postgres";
    public String password = "mdpprom13";

    public Connexion(String request) {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Hopital",username,password);
            statement = getConnection().createStatement();
            resultset = getStatement().executeQuery(request);
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
    public Statement getStatement() {
        return statement;
    }
    public ResultSet getResultSet() {
        return resultset;
    }

}
