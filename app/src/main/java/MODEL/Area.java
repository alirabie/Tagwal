package MODEL;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Eng Ali on 6/7/2017.
 */
public class Area {
    @SerializedName("AreaID")
    @Expose
    private Integer areaID;
    @SerializedName("Name")
    @Expose
    private String name;

    public Integer getAreaID() {
        return areaID;
    }

    public void setAreaID(Integer areaID) {
        this.areaID = areaID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
