package Fragments;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Adapter.Grid_favAdapter;
import Adapter.Grid_productAdapter;
import ConstantClasss.Constanturl;
import ConstantClasss.Idealinterface;
import MODEL.WishlistModel;
import cc.cloudist.acplibrary.ACProgressConstant;
import cc.cloudist.acplibrary.ACProgressFlower;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tagawl.com.tagwal.AllProduct;
import tagawl.com.tagwal.R;

/**
 * Created by Asmaa on 5/29/2017.
 */

public class FragmentHome extends Fragment {
    View about_view;
    TextView txtnewproducts, txtfavproduct;
    GridView grid_products, grid_favproducts;
    List<AllProduct> product_list;
    List<WishlistModel> wishlist_products;
    ACProgressFlower dialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        about_view = inflater.inflate(R.layout.layout_home, container,
                false);
        findViewId();
        product_list = new ArrayList<>();
        wishlist_products = new ArrayList<>();
        getproducts();
        GetwishlistProducts(1,20);
        return about_view;

    }

    private void findViewId() {
        txtnewproducts = (TextView) about_view.findViewById(R.id.txtnewproducts);
        txtfavproduct = (TextView) about_view.findViewById(R.id.txtfavproduct);
        grid_products = (GridView) about_view.findViewById(R.id.grid_products);
        grid_favproducts = (GridView) about_view.findViewById(R.id.grid_favproducts);
    }

    public void getproducts() {
        if (dialog == null) {
            dialog = new ACProgressFlower.Builder(getActivity())
                    .direction(ACProgressConstant.DIRECT_CLOCKWISE)
                    .themeColor(Color.WHITE)
                    .fadeColor(Color.DKGRAY).build();
        }
        //
        // dialog.show();
        HashMap input = new HashMap();
        input.put("pageNo", "1");
        input.put("pageSize","100");
        Log.e("inpp", input + "");
        Constanturl.createService(Idealinterface.class).GetAllProducts(input).enqueue(new Callback<List<AllProduct>>() {
            @Override
            public void onResponse(Call<List<AllProduct>> call, Response<List<AllProduct>> response) {

                if (response.isSuccessful()) {
                    // AllProduct model = response.body();
                   // product_list = response.body();
                    Log.e("sizeerr", response.body().size() + "");
                    Grid_productAdapter adapter = new Grid_productAdapter(getActivity(),response.body());
                    grid_products.setAdapter(adapter);
                } else {
                    Log.d("CODE", response.code() + "");
                }

            }

            @Override
            public void onFailure(Call<List<AllProduct>> call, Throwable t) {
                Log.e("llll", "error");

            }
        });
        //

    }

    public void GetwishlistProducts(int start,int length) {
        if (dialog == null) {
            dialog = new ACProgressFlower.Builder(getActivity())
                    .direction(ACProgressConstant.DIRECT_CLOCKWISE)
                    .themeColor(Color.WHITE)
                    .fadeColor(Color.DKGRAY).build();
        }
        //
        // dialog.show();
        HashMap input = new HashMap();
        input.put("pageNo", start);
        input.put("pageSize", length);
        Log.e("inpp", input + "");
        Constanturl.createService(Idealinterface.class).GetwishlistProducts(input).enqueue(new Callback<List<WishlistModel>>() {
            @Override
            public void onResponse(Call<List<WishlistModel>> call, Response<List<WishlistModel>> response) {

                if (response.isSuccessful()) {
                    // AllProduct model = response.body();
                    //wishlist_products = response.body();
                    Log.e("vvvv", response.body().size() + "");
                    Grid_favAdapter favadapter = new Grid_favAdapter(getActivity(), response.body());
                    grid_favproducts.setAdapter(favadapter);
                } else {
                    Log.d("CODE", response.code() + "");
                }

            }

            @Override
            public void onFailure(Call<List<WishlistModel>> call, Throwable t) {
                Log.e("llll", "error");

            }
        });
    }
}
