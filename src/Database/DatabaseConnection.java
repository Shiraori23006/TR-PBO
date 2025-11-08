package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3360/db_bioskop";
    private static final String NAME = "root";
    private static final String PASSWORD = "";
    
    public static Connection GetConnection(){
        try{
            return DriverManager.getConnection(URL, NAME, PASSWORD);
        }catch(SQLException e){
            System.out.println("Database Connection Error " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    public static void StopConnection(Connection connection){
        if(connection != null){
            try{
                connection.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
    
}
