package MODEL;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by asmaa.mostafa on 01/06/2017.
 */

public class productDetailmodel {
    @SerializedName("ProductID")
    @Expose
    private Integer productID;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Description")
    @Expose
    private String description;
    @SerializedName("Cost")
    @Expose
    private Double cost;
    @SerializedName("ShopID")
    @Expose
    private Integer shopID;
    @SerializedName("Brand")
    @Expose
    private Object brand;
    @SerializedName("Size")
    @Expose
    private Object size;
    @SerializedName("Shape")
    @Expose
    private Object shape;
    @SerializedName("Type")
    @Expose
    private Object type;
    @SerializedName("ShopLink")
    @Expose
    private Object shopLink;
    @SerializedName("ShopName")
    @Expose
    private String shopName;
    @SerializedName("Images")
    @Expose
    private List<ImageModel> images = null;

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

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getShopID() {
        return shopID;
    }

    public void setShopID(Integer shopID) {
        this.shopID = shopID;
    }

    public Object getBrand() {
        return brand;
    }

    public void setBrand(Object brand) {
        this.brand = brand;
    }

    public Object getSize() {
        return size;
    }

    public void setSize(Object size) {
        this.size = size;
    }

    public Object getShape() {
        return shape;
    }

    public void setShape(Object shape) {
        this.shape = shape;
    }

    public Object getType() {
        return type;
    }

    public void setType(Object type) {
        this.type = type;
    }

    public Object getShopLink() {
        return shopLink;
    }

    public void setShopLink(Object shopLink) {
        this.shopLink = shopLink;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public List<ImageModel> getImages() {
        return images;
    }
}
