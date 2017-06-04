package tagawl.com.tagwal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

/**
 * Created by Asmaa on 31/05/2017.
 */

public class AllProduct {

    @SerializedName("ProductID")
    @Expose
    private Integer productID;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Description")
    @Expose
    private String description;
    @SerializedName("ShopID")
    @Expose
    private Integer shopID;
    @SerializedName("Cost")
    @Expose
    private Double cost;
    @SerializedName("ShopName")
    @Expose
    private String shopName;
    @SerializedName("OwnerName")
    @Expose
    private Object ownerName;
    @SerializedName("OwnerPhone")
    @Expose
    private Object ownerPhone;
    @SerializedName("MangerName")
    @Expose
    private Object mangerName;
    @SerializedName("MangerPhone")
    @Expose
    private Object mangerPhone;
    public AllProduct(){

    }
public AllProduct(int productID,String name,String description,Double cost){
this.productID =productID;
    this.name = name;
    this.description = description;
    this.cost = cost;
}
    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getShopID() {
        return shopID;
    }

    public void setShopID(Integer shopID) {
        this.shopID = shopID;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Object getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(Object ownerName) {
        this.ownerName = ownerName;
    }

    public Object getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(Object ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    public Object getMangerName() {
        return mangerName;
    }

    public void setMangerName(Object mangerName) {
        this.mangerName = mangerName;
    }

    public Object getMangerPhone() {
        return mangerPhone;
    }

    public void setMangerPhone(Object mangerPhone) {
        this.mangerPhone = mangerPhone;
    }
}
