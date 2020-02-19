import java.util.List;

public interface CartDao {
	public List<cart> getAllCartItems(long userId) throws CartEmptyException;
	public void addCartItem(long userId,  long menuItemId);
	public void removeCartItem(long userId,  long menuItemId);
}
