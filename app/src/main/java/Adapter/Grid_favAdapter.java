package Adapter;

import android.content.Context;
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

import java.util.HashMap;
import java.util.List;

import MODEL.PRODUCTModel;
import MODEL.WishlistModel;
import tagawl.com.tagwal.PRODUCT_SUGAR;
import tagawl.com.tagwal.R;

/**
 * Created by Asmaa on 5/29/2017.
 */

public class Grid_favAdapter extends ArrayAdapter {
    private List<WishlistModel> studentListold;
    Context context;
    View departView;
    TextView txtProductName,tvProductPrice;
    ImageView product_img;
    NiftyDialogBuilder dialogBuildercard;
    SliderLayout Slider_Item;
    public RelativeLayout btn_buy,parent;
    public Grid_favAdapter(Context context, List<WishlistModel> studentListold){
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
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
         departView = inflater.inflate(R.layout.layout_gridproducts, parent, false);
        findViewsId();
        txtProductName.setText(studentListold.get(position).getName());
        tvProductPrice.setText(String.valueOf(studentListold.get(position).getCost()));
        btn_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PRODUCT_SUGAR p_model = new PRODUCT_SUGAR(studentListold.get(position).getProductID(),studentListold.get(position).getName(),studentListold.get(position).getCost(),studentListold.get(position).getDescription());
                List<PRODUCT_SUGAR> authors = p_model.find(PRODUCT_SUGAR.class, "itemid = ?", String.valueOf(studentListold.get(position).getProductID()));
                /*if (authors.size()==0){

                }*/
                p_model.save();
                Log.e("LISTSIZE",authors.size()+"");
                Toast.makeText(context, context.getResources().getString(R.string.addedsuccesfuly), Toast.LENGTH_LONG).show();
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
}
