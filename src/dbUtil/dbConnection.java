package dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection
{
  private static final String USERNAME = "###";
  private static final String PASSWORD = "###";
  private static final String CONN = "jdbc:mysql://localhost:3308/login";
  
  public static Connection getConnection() throws SQLException
  {
    try
    {
      Class.forName("com.mysql.jdbc.Driver");
      
      return DriverManager.getConnection(CONN,USERNAME,PASSWORD);
    }
    catch (ClassNotFoundException|SQLException ex)
    {
      ex.printStackTrace();
    }
    return null;
  }
}

