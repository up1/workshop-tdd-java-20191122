package demo01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DemoTry {

    public void doProcess() {
//        Connection conn = null;
//        PreparedStatement prepStmt = null;
        
        try(
                Connection conn = DriverManager.getConnection("");
                PreparedStatement prepStmt = conn.prepareStatement("");  
                
                ){
            
    } catch (SQLException e) {
        e.printStackTrace();
    }

//        try {
//            conn = DriverManager.getConnection("");
//            prepStmt = conn.prepareStatement("");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//
//        }

    }

}
