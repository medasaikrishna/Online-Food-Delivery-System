//import java.io.FileInputStream;
//import java.io.IOException;
import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.SQLException;
//import java.util.Properties;
import java.sql.*;
import java.util.*;
public class MenuItemDaoSqllmpl implements MenuItemDao{
	public void insert(MenuItem obj)
	{
		//List<MenuItem> list=new ArrayList<MenuItem>();
	try{
		Connection con=ConnectionHandler.getConnection();
		PreparedStatement ps=con.prepareStatement("insert into menu values(?,?,?,?,?,?,?)");
		//ResultSet rs=ps.executeQuery();
			//System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6));
			//MenuItem mi=new MenuItem();
			ps.setInt(1,obj.getItemid());
			ps.setString(2,obj.getItemname());
			ps.setInt(3,obj.getItemcost());
			ps.setString(4,obj.getItemtype());
			ps.setString(5,obj.getItemdate());
			ps.setString(6,obj.getItemstatus());
			ps.setString(7,obj.getItemdelstatus());
			//list.add(mi);
		int c=ps.executeUpdate();
		if(c==1)
			System.out.println("Insetrted Successfully");
		else
			System.out.println("Not Insetrted");
		
	}
    catch(ClassNotFoundException e){
        e.printStackTrace();
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	
	}

	public List<MenuItem> getMenuItemListAdmin()
	{
		List<MenuItem> list=new ArrayList<MenuItem>();
	try{
		Connection con=ConnectionHandler.getConnection();
		PreparedStatement ps=con.prepareStatement("Select * from menu");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			//System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6));
			MenuItem mi=new MenuItem();
			mi.setItemid(rs.getInt(1));
			mi.setItemname(rs.getString(2));
			mi.setItemcost(rs.getInt(3));
			mi.setItemtype(rs.getString(4));
			mi.setItemdate(rs.getString(5));
			mi.setItemstatus(rs.getString(6));
			mi.setItemdelstatus(rs.getString(7));
			list.add(mi);
		}
		
	}
    catch(ClassNotFoundException e){
        e.printStackTrace();
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}

	return list;
	
	}
	
	public List<MenuItem> getMenuItemListCustomer()
	{
		List<MenuItem> list=new ArrayList<MenuItem>();
	try{
		Connection con=ConnectionHandler.getConnection();
		PreparedStatement ps=con.prepareStatement("Select * from menu where itemstatus='yes'");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			//System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6));
			MenuItem mi=new MenuItem();
			mi.setItemid(rs.getInt(1));
			mi.setItemname(rs.getString(2));
			mi.setItemcost(rs.getInt(3));
			mi.setItemtype(rs.getString(4));
			mi.setItemdate(rs.getString(5));
			mi.setItemstatus(rs.getString(6));
			mi.setItemdelstatus(rs.getString(7));
			list.add(mi);
		}
		
	}
    catch(ClassNotFoundException e){
        e.printStackTrace();
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}

	return list;
	
	}
	
	public List<MenuItem> getMenuItem(int id)
	{
		List<MenuItem> list=new ArrayList<MenuItem>();
	try{
		Connection con=ConnectionHandler.getConnection();
		PreparedStatement ps=con.prepareStatement("Select * from menu where itemid=?");
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			//System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6));
			MenuItem mi=new MenuItem();
			mi.setItemid(rs.getInt(1));
			mi.setItemname(rs.getString(2));
			mi.setItemcost(rs.getInt(3));
			mi.setItemtype(rs.getString(4));
			mi.setItemdate(rs.getString(5));
			mi.setItemstatus(rs.getString(6));
			mi.setItemdelstatus(rs.getString(7));
			list.add(mi);
		}
		
	}
    catch(ClassNotFoundException e){
        e.printStackTrace();
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}

	return list;
	
	}
	
	public void editMenuItem(MenuItem obj)
	{
		//List<MenuItem> list=new ArrayList<MenuItem>();
	try{
		Connection con=ConnectionHandler.getConnection();
		PreparedStatement ps=con.prepareStatement("Update menu set itemname='"+obj.getItemname()+"' , itemcost='"+obj.getItemcost()+"' , itemtype='"+obj.getItemtype()+"' , itemdate='"+obj.getItemdate()+"' , itemstatus='"+obj.getItemstatus()+"' , itemdelstatus='"+obj.getItemdelstatus()+"' where itemid='"+obj.getItemid()+"'");
		//ResultSet rs=ps.executeQuery();
			//System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6));
			//MenuItem mi=new MenuItem();
			//ps.setInt(1,obj.getItemid());
			//ps.setString(1,obj.getItemname());
			//ps.setInt(2,obj.getItemcost());
			//ps.setString(3,obj.getItemtype());
			//ps.setString(4,obj.getItemdate());
			//ps.setString(5,obj.getItemstatus());
			//ps.setString(6,obj.getItemdelstatus());
			//list.add(mi);
		int c=ps.executeUpdate();
		if(c!=0)
			System.out.println("Updated Successfully");
		else
			System.out.println("Not Updated");
		
	}
    catch(ClassNotFoundException e){
        e.printStackTrace();
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	
	}
	
}
