package tagawl.com.tagwal;
import com.orm.SugarRecord;

/**
 * Created by asmaa.mostafa on 01/06/2017.
 */

public class PRODUCT_SUGAR extends SugarRecord {

    private Integer itemid;
    private Integer quantity;
    String name, description;
    Double price;

    public PRODUCT_SUGAR(){

    }

    public PRODUCT_SUGAR(int itemid,String name,Double price,String description){
        this.itemid = itemid;
        this.name=name;
        this.price = price;
        this.description = description;
    }

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
