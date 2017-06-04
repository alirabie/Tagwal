package MODEL;

/**
 * Created by Asmaa on 5/29/2017.
 */

public class PRODUCTModel {
    String product_name,pic;
    int product_id;
    double price;
    public  PRODUCTModel(String product_name,int product_id,double price,String pic){
        this.pic= pic;
        this.product_id=product_id;
        this.price = price;
        this.product_name = product_name;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
