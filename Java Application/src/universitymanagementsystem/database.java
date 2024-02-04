/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitymanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @Ahmed_Ali
 */
public class database {
    
    public static Connection connectDb() {
    try {
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String user = "UNIVERSITY";
        String password = "root";


        Connection connect = DriverManager.getConnection(url, user, password);
        return connect;
    } catch (SQLException e) {
        e.printStackTrace();

    }
    return null;
}

           
}


