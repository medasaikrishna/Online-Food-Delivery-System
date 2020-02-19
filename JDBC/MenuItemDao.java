import java.util.List;

public interface MenuItemDao {

	public List<MenuItem> getMenuItemListAdmin();
	public List<MenuItem> getMenuItemListCustomer();
	public List<MenuItem> getMenuItem(int id);
	public void editMenuItem(MenuItem obj);
}
