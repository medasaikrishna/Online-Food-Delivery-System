import java.sql.*;
import java.util.*;
public class CartDaoSqlImpl implements CartDao{
	public List<cart> getAllCartItems(long userId) throws CartEmptyException
	{
		List<cart> list=new ArrayList<cart>();
		try{
			Connection con=ConnectionHandler.getConnection();
			PreparedStatement ps=con.prepareStatement("Select * from cart where userid=?");
			ps.setLong(1,userId);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				//System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6));
				cart c=new cart();
				c.setUserid(rs.getLong(1));
				c.setItemid(rs.getLong(2));

				list.add(c);
			}
			
			
		}
	    catch(ClassNotFoundException e){
	        e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		if(list==null)
			throw new CartEmptyException();
		else
		return list;
	}
	
	public void addCartItem(long userId,  long menuItemId)
	{
		//List<MenuItem> list=new ArrayList<MenuItem>();
		try{
			Connection con=ConnectionHandler.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into cart values(?,?)");
			//ResultSet rs=ps.executeQuery();
			ps.setLong(1, userId);
			ps.setLong(2, menuItemId);
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
	
	public void removeCartItem(long userId,  long menuItemId)
	{
		try{
			Connection con=ConnectionHandler.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from cart where userid=? and itemid=?");
			//ResultSet rs=ps.executeQuery();
			ps.setLong(1, userId);
			ps.setLong(2, menuItemId);
			int c=ps.executeUpdate();
			if(c==1)
				System.out.println("Delected Successfully");
			else
				System.out.println("Not Delected");
			
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
