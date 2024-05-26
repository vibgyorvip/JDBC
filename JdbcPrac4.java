import java.sql.*;
public class JdbcDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        int sid=5;
        String sname="max";
        int marks=38;

        String url="jdbc:postgresql://localhost:5432/demo";
        String uname="postgres";
        String pass="vipul";
        //String sql="insert into student values (5,'john',38)";
        //String sql="update student set sname='max' where sid=5";
        //String sql ="delete from student where sid=5";
        //String sql="insert into student values ("+sid+","+sname+","+marks+")";
        String sql ="insert into student values(?,?,?)";

        //load & regeister a driver
        Class.forName("org.postgresql.Driver");

        //Create connection
        Connection con = DriverManager.getConnection(url,uname,pass);
        System.out.println("Connection Established !!");


//        //Create statement
//        Statement st = con.createStatement();

        PreparedStatement st= con.prepareStatement(sql);
        st.setInt(1,sid);
        st.setString(2,sname);
        st.setInt(3,marks);
        
        st.execute();


//        //Execute statement
//        st.execute(sql);


        //Close the connection
        con.close();
        System.out.println("Connection Closed !!");
    }
}
