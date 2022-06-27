package pos;

public class Order {
   String menu;
   Integer price;
   Integer menunum;
   Integer sumprice;
   
   public String getMenu() {
      return menu;
   }
   public Integer getPrice() {
      return price;
   }
   public Integer getMenunum() {
      return menunum;
   }
   public Integer getSumprice() {
      return sumprice;
   }
   
   public Order(String menu,Integer price,   Integer menunum, Integer sumprice) {
      this.menu = menu;
      this.price = price;
      this.menunum = menunum;
      this.sumprice = sumprice;
      // TODO Auto-generated constructor stub
   }
   String sql = "SELECT payment_price FROM payment_list WHERE ?";
}
