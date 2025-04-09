import java.time.LocalDate;
import java.util.Date;

public class ExpirableProduct extends Product{
    LocalDate exDate;
    ExpirableProduct(String name, double price , int quantity, int weight, LocalDate exDate){
        super(name,price,quantity,weight);
        this.exDate = exDate;
    }
    public boolean isExpired(){
        return exDate.isBefore((LocalDate.now()));
    }
}
