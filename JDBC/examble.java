
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.*;

public class examble{

	public static void main(String args[]) throws ClassNotFoundException,SQLException
	{
		//Connection con=ConnectionHandler.getConnection();
		//try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root","password-1");
		Statement st=con.createStatement();
		//st.executeUpdate("create table emp(eid int,ename varchar(10),email varchar(10),address varchar(10))");
		System.out.println("created");
		//String sq1="insert into emp value(?,?,?,?)"
		//String sq2="delete from emp where eid=?";
		//String sq3="update emp set ename='krishna' where eid=12";
		PreparedStatement ps=con.prepareStatement("update emp set ename=? where eid=?");
		ps.setString(1,"sai");
		ps.setInt(2,12);
		/*ps.setString(3,"sai@gma");
		ps.setString(4,"hyd");*/
		ps.executeUpdate();
		System.out.println("inserted");
		
		/*ResultSet rs=st.executeQuery("Select * from emp");
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6));

		}*/

	
	}
}
