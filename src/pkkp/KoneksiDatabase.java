/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkkp;
import java.sql.*;
import com.mysql.cj.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author timot
 */
public class KoneksiDatabase {
   String url, usr, pwd, dbn;
   public KoneksiDatabase (String dbn) {
       this.url = "jdbc:mysql://localhost/" + dbn;
       this.usr = "root";
       this.pwd = "";
   }
   public KoneksiDatabase(String host, String user, String pass, String dbn) {
       this.url = "jdbc:mysql://" + host + "/" + dbn;
       this.usr = user;
       this.pwd = pass;
   }
   public Connection getConnection() {
       Connection con = null;
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           con = DriverManager.getConnection(this.url, this.usr, this.pwd);
       }catch (ClassNotFoundException e){
           System.out.println("Error #1 : " + e.getMessage());
           System.exit(0);
       }catch (SQLException e){
           System.out.println("Error #2 : " + e.getMessage());
           System.exit(0);
       }
       return con;
    }
//    public static void main(String[] args) {
//        KoneksiMysql kon = new KoneksiMysql("penjualan");
//        Connection c = kon.getConnection();
//    }
}
