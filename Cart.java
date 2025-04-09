import java.util.ArrayList;
import java.util.List;
public class Cart {
    
    List<Product> products = new ArrayList();

    public double totalShipping=0;
    double subPrice=0;
    double totalPrice=0;
    public int itemQuantity;
    public void shippingRate()throws Exception{
        try {
            for (Product p :products) {
                if (p.getWeight()> 0 ){
                    totalShipping +=10;
            }
        }
        }
        catch(Exception e){
            throw new Exception(e.getMessage());
        }

    }

    public void subTotal(Product product, int quantity)throws Exception{
       try{
           subPrice += product.getPrice();
           subPrice*=quantity;
       }
       catch (Exception e){
           throw new Exception(e.getMessage());
       }

    }

    public void totalAmount()throws Exception{
       try{
           totalPrice = subPrice+totalShipping;
          // return totalPrice;
       }
       catch(Exception e){
           throw new Exception(e.getMessage());
       }
    }
    public void add(Product product,int quantity)throws Exception{
      try {
          if (quantity > product.getQuantity()){

              throw new Exception("Error! "+product.getName()+" out of Stock  by " + (quantity - product.getQuantity()));
          }
          if(product instanceof ExpirableProduct){
              if (((ExpirableProduct) product).isExpired()){
                  throw new Exception("Item"+product.getName()+" is expired!" );
              }
          }
          products.add(product);
                  this.itemQuantity = quantity;
                  product.setQuantity(product.getQuantity()- quantity);
                  this.subTotal(product,quantity);
                  shippingRate();
                  totalAmount();

      }
      catch(Exception e){
          throw new Exception(e.getMessage());
      }
    }
}
