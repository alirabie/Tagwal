package MODEL;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Asmaa on 02/06/2017.
 */

public class ImageModel {
    @SerializedName("ImageID")
    @Expose
    private Integer imageID;
    @SerializedName("ProductID")
    @Expose
    private Integer productID;
    @SerializedName("Location")
    @Expose
    private String location;

    public Integer getImageID() {
        return imageID;
    }

    public void setImageID(Integer imageID) {
        this.imageID = imageID;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
