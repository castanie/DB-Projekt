package Projekt;

import java.sql.*;

public class App {
    
    public static void main(String[] args) throws SQLException {
        
        String url = "jdbc:postgresql://localhost:5432/postgres";
        Connection conn = DriverManager.getConnection(url, "postgres", "password");

        Statement stat = conn.createStatement();
        ResultSet result = stat.executeQuery("SELECT COUNT(*) FROM betrieb;");

        while(result.next()) {
            System.out.println("Count: " + result.getInt(1));
        }
        
    }

    // TODO: Move to respective DAOs!

    

}
