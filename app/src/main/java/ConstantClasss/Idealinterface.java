package ConstantClasss;

import java.util.List;

import MODEL.Area;
import MODEL.WishlistModel;
import MODEL.productDetailmodel;
import retrofit2.http.Headers;
import tagawl.com.tagwal.AllProduct;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by asmaa.mostafa on 13/03/2017.
 */
public interface Idealinterface {
    @POST("GetLatestProducts")
    Call<List<AllProduct>>GetAllProducts(@Body Object data);
    @POST("GetProposalProducts")
    Call<List<WishlistModel>>GetwishlistProducts(@Body Object data);
    @POST("GetProductDetails")
    Call<productDetailmodel>Getproducrdetails(@Body Object data);

    @POST("GetAreas")
    Call<List<Area>>GetAreas();

}
