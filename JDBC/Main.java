import java.util.*;
import java.sql.*;
public class Main {

	public static void main(String[] args)throws SQLException {
		Scanner s=new Scanner(System.in);
		MenuItemDaoSqllmpl m=new MenuItemDaoSqllmpl();
		MenuItem mn=new  MenuItem();
		cart ct=new cart();
		CartDaoSqlImpl cd=new CartDaoSqlImpl();
		
		
		List<MenuItem> list1=new ArrayList<MenuItem>();
		List<MenuItem> list2=new ArrayList<MenuItem>();
		List<MenuItem> list3=new ArrayList<MenuItem>();
		List<cart> clist=new ArrayList<cart>();
		System.out.println("Enter no of items to insert");
		int t=Integer.parseInt(s.nextLine());
		while(t-->0)
		{
		System.out.println("enter id,name,cost,type,date,status,deliverstatus to insert data");
		 mn.setItemid(Integer.parseInt(s.nextLine()));
		 mn.setItemname(s.nextLine());
		 mn.setItemcost(Integer.parseInt(s.nextLine()));
		 mn.setItemtype(s.nextLine());
		 mn.setItemdate(s.nextLine());
		 mn.setItemstatus(s.nextLine());
		 mn.setItemdelstatus(s.nextLine());
		 m.insert(mn);
		}
		list1=m.getMenuItemListAdmin();
		System.out.println("Admin details");
		System.out.println("ItemId   ItemName   ItemCost   ItemType   Date   ItemStatus DeliveryStatus");
		for(int i=0;i<list1.size();i++)
			System.out.println(list1.get(i).getItemid()+" "+list1.get(i).getItemname()+" "+list1.get(i).getItemcost()+" "+list1.get(i).getItemtype()+" "+list1.get(i).getItemdate()+" "+list1.get(i).getItemstatus()+" "+list1.get(i).getItemdelstatus());

		list2=m.getMenuItemListCustomer();
		System.out.println();
		System.out.println("Customer details");
		System.out.println("ItemId   ItemName   ItemCost   ItemType   Date   ItemStatus DeliveryStatus"); 
		for(int i=0;i<list2.size();i++)
			System.out.println(list2.get(i).getItemid()+" "+list2.get(i).getItemname()+" "+list2.get(i).getItemcost()+" "+list2.get(i).getItemtype()+" "+list2.get(i).getItemdate()+" "+list2.get(i).getItemstatus()+" "+list2.get(i).getItemdelstatus());

		System.out.println();
		System.out.println("Enter the id to get menu");
		int id=Integer.parseInt(s.nextLine());
		list3=m.getMenuItem(id);
		System.out.println("menu");
		for(int i=0;i<list3.size();i++)
			System.out.println(list3.get(i).getItemid()+" "+list3.get(i).getItemname()+" "+list3.get(i).getItemcost()+" "+list3.get(i).getItemtype()+" "+list3.get(i).getItemdate()+" "+list3.get(i).getItemstatus()+" "+list3.get(i).getItemdelstatus());
		
		System.out.println("enter id, name, cost, type, date, status, deliverstatus to Update data");
		 //MenuItem mn=new  MenuItem();
		 mn.setItemid(Integer.parseInt(s.nextLine()));
		 mn.setItemname(s.nextLine());
		 mn.setItemcost(Integer.parseInt(s.nextLine()));
		 mn.setItemtype(s.nextLine());
		 mn.setItemdate(s.nextLine());
		 mn.setItemstatus(s.nextLine());
		 mn.setItemdelstatus(s.nextLine());
		 m.editMenuItem(mn);
		 System.out.println();
		System.out.println("Enter no of items add to cart");
		int tt=s.nextInt();
		while(tt-->0)
		{
		 System.out.println("Enter the userid and itemid to insert into cart");
		 ct.setUserid(s.nextLong());
		 ct.setItemid(s.nextLong());
		 cd.addCartItem(ct.getUserid(), ct.getItemid());
		}
		
		System.out.println();
		System.out.println("Enter UserId to get Cart Items");
		 ct.setUserid(s.nextLong());
		 try{
		 clist=cd.getAllCartItems(ct.getUserid());
		 System.out.println("UserId   ItemId");
		 for(int j=0;j<clist.size();j++)
			 System.out.println(clist.get(j).getUserid()+"        "+clist.get(j).getItemid());
		 }
		 catch(Exception e)
		 {
			 System.out.println("no items in cart");
		 }
		 
		 System.out.println();
		System.out.println("Enter UserId and ItemId to remove Items from cart");
		 ct.setUserid(s.nextLong());
		 ct.setItemid(s.nextLong());
		 cd.removeCartItem(ct.getUserid(),ct.getItemid());
		 
	}

}
