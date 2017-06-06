package Adapter;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.gitonway.lee.niftymodaldialogeffects.lib.Effectstype;
import com.gitonway.lee.niftymodaldialogeffects.lib.NiftyDialogBuilder;
import com.orm.SugarRecord;

import java.util.HashMap;
import java.util.List;

import ConstantClasss.Constanturl;
import ConstantClasss.Idealinterface;
import MODEL.productDetailmodel;
import cc.cloudist.acplibrary.ACProgressConstant;
import cc.cloudist.acplibrary.ACProgressFlower;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tagawl.com.tagwal.AllProduct;
import tagawl.com.tagwal.NavDrawerActivity;
import tagawl.com.tagwal.PRODUCT_SUGAR;
import tagawl.com.tagwal.R;

/**
 * Created by Asmaa on 5/29/2017.
 */

public class Grid_productAdapter extends ArrayAdapter  {
    private List<AllProduct> studentListold;
    TextView txtProductName,tvProductPrice;
    ImageView product_img;
    public RelativeLayout btn_buy,parent,btn_addToBasker;
    View departView;
    NiftyDialogBuilder dialogBuildercard;
    TextView tv_proName,tv_proPrice,tv_proSeller,tv_proDesc;
    Context context;
    SliderLayout Slider_Item;
    ACProgressFlower dialog;

    public Grid_productAdapter(Context context, List<AllProduct> studentListold){
        super(context, R.layout.layout_gridproducts, studentListold);
        this.context = context;
        this.studentListold = studentListold;
    }
    @Override
    public int getCount() {
        return studentListold.size();
    }
    @Override
    public boolean isEnabled(int position) {
        return false;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public View getView( final int position, @Nullable View convertView, @NonNull final ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
         departView = inflater.inflate(R.layout.layout_gridproducts, parent, false);
        findViewsId();
        txtProductName.setText(studentListold.get(position).getName());
        tvProductPrice.setText(String.valueOf(studentListold.get(position).getCost()));


        // ADD CART
        btn_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<PRODUCT_SUGAR> authors=PRODUCT_SUGAR.find(PRODUCT_SUGAR.class,"itemid = ?",studentListold.get(position).getProductID()+"");
                if(authors.isEmpty()){
                    PRODUCT_SUGAR p_model = new PRODUCT_SUGAR(
                            studentListold.get(position).getProductID(),
                            studentListold.get(position).getName(),
                            studentListold.get(position).getCost(),
                            studentListold.get(position).getDescription(),1);
                    p_model.save();
                    Toast.makeText(context, context.getResources().getString(R.string.addedsuccesfuly), Toast.LENGTH_LONG).show();

                }else {

                    //List<PRODUCT_SUGAR> existed=PRODUCT_SUGAR.find(PRODUCT_SUGAR.class,"itemid = ?",studentListold.get(position).getProductID()+"");
                    authors.get(0).setQuantity(authors.get(0).getQuantity()+1);
                    authors.get(0).save();
                    //do update on existing item count
                    Toast.makeText(context, context.getResources().getString(R.string.addedsuccesfuly), Toast.LENGTH_LONG).show();
                }


                        }

        });

        departView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        dialogBuildercard = NiftyDialogBuilder.getInstance(context);
        dialogBuildercard
                .withDialogColor("#ededed")
                .withDuration(700)                                          //def
                .withEffect(Effectstype.Sidefill).withTitle(context.getString(R.string.cardd)).withTitleColor(context.getResources().getColor(R.color.colorPrimary))
                .isCancelableOnTouchOutside(false)                           //def    | isCancelable(true)
                .setCustomView(R.layout.cartdetails, v.getContext())
                .show();
        tv_proName =(TextView)dialogBuildercard.findViewById(R.id.tv_proName) ;
        tv_proPrice =(TextView)dialogBuildercard.findViewById(R.id.tv_proPrice) ;
        tv_proSeller =(TextView)dialogBuildercard.findViewById(R.id.tv_proSeller) ;
        tv_proDesc =(TextView)dialogBuildercard.findViewById(R.id.tv_proDesc) ;
        Slider_Item = (SliderLayout) dialogBuildercard.findViewById(R.id.slider);

        HashMap<String,String> url_maps = new HashMap<String, String>();
        url_maps.put("Hannibal", "http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg");
        url_maps.put("Big Bang Theory", "http://tvfiles.alphacoders.com/100/hdclearart-10.png");
        url_maps.put("House of Cards", "http://cdn3.nflximg.net/images/3093/2043093.jpg");
        url_maps.put("Game of Thrones", "http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");
        for(String name : url_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(context);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(url_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit);
                    //.setOnSliderClickListener(context);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            Slider_Item.addSlider(textSliderView);
        }
        Slider_Item.setPresetTransformer(SliderLayout.Transformer.Accordion);
        Slider_Item.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        Slider_Item.setCustomAnimation(new DescriptionAnimation());
        Slider_Item.setDuration(4000);
        getProductDetails(studentListold.get(position).getProductID());
        //Slider_Item.addOnPageChangeListener(context);
    }
});
        return departView;
    }

    private void findViewsId() {
        txtProductName = (TextView) departView.findViewById(R.id.tv_productName);
        tvProductPrice = (TextView) departView.findViewById(R.id.tv_productPrice);
        btn_buy = (RelativeLayout) departView.findViewById(R.id.btn_buy);
        parent = (RelativeLayout) departView.findViewById(R.id.parent);
    }
    public void getProductDetails(int id){
        if (dialog == null) {
            dialog = new ACProgressFlower.Builder(context)
                    .direction(ACProgressConstant.DIRECT_CLOCKWISE)
                    .themeColor(Color.WHITE)
                    .fadeColor(Color.DKGRAY).build();
        }
        //
        // dialog.show();
        HashMap input = new HashMap();
        input.put("ProductID", id);
        Log.e("inpp", input + "");
        Constanturl.createService(Idealinterface.class).Getproducrdetails(input).enqueue(new Callback<productDetailmodel>() {
            @Override
            public void onResponse(Call<productDetailmodel> call, Response<productDetailmodel> response) {
                if (response.isSuccessful()) {
                    tv_proName.setText(response.body().getName());
                    Log.d("CODE", response.body().getName());
                    tv_proDesc.setText(response.body().getDescription());
                    tv_proPrice.setText(String.valueOf(response.body().getCost()));
                    tv_proSeller.setText(response.body().getShopName());
                } else {
                    Log.d("CODE", response.code() + "");
                }

            }

            @Override
            public void onFailure(Call<productDetailmodel> call, Throwable t) {
                Log.e("llll", "error");

            }
        });
        //

    }


}

