package mihich;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.sun.rowset.JdbcRowSetImpl;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Shujuk {

    public void Shu(String position, String company, String compensation, String workplace, String date) throws PropertyVetoException, ClassNotFoundException, SQLException {
            String driverClassName = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/pa01?useSSL=false";
            String username = "root";
            String password = "123456";
            Class.forName(driverClassName);
        Connection con = (Connection)DriverManager.getConnection(url, username, password);
       String sql = "INSERT INTO job(position,company,compensation,workplace,date)VALUES(?,?,?,?,?)";
     //   String sql="INSERT job VALUES(?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,position);
        ps.setString(2,company);
        ps.setString(3,compensation);
        ps.setString(4,workplace);
        ps.setString(5,date);
            ps.addBatch();

            int[] res = ps.executeBatch();
            System.out.println(res);
            ps.close();
            con.close();

    }



}
