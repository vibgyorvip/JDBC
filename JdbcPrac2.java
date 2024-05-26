
import java.sql.*;
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        /*
        Import Packages
        Load & Register Driver
        Create Connection
        Create Statement
        Execute Statement
        Process the results
        Close Connection
        */

        String url="jdbc:postgresql://localhost:5432/demo";
        String uname="postgres";
        String pass="vipul";
        //String sql="select sname from student where sid=1";
        String sql="select * from student";

        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection(url,uname,pass);
        System.out.println("Connection Established !!");
        Statement st= con.createStatement();
        ResultSet rs=st.executeQuery(sql);
//        rs.next();
//        String name=rs.getString("sname");
//        System.out.println("Name of a student is "+name);

        while(rs.next())
        {
            System.out.print(rs.getInt(1)+"-");
            System.out.print(rs.getString(2)+"-");
            System.out.println(rs.getInt(3));
        }

        con.close();
        System.out.println("Connection Closed !!");
    }
}
