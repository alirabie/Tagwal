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

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.gitonway.lee.niftymodaldialogeffects.lib.Effectstype;
import com.gitonway.lee.niftymodaldialogeffects.lib.NiftyDialogBuilder;
import com.orm.query.Condition;
import com.orm.query.Select;

import java.util.HashMap;
import java.util.List;

import MODEL.WishlistModel;
import tagawl.com.tagwal.PRODUCT_SUGAR;
import tagawl.com.tagwal.R;

/**
 * Created by Asmaa on 5/29/2017.
 */

public class CartAdapter extends ArrayAdapter {
    private List<PRODUCT_SUGAR> CART_LIST;
    Context context;
    View departView;
    ImageView basket_img,img_delete;
    TextView basket_name,basket_price,basket_quantity,basket_total;
    public CartAdapter(Context context, List<PRODUCT_SUGAR> CART_LIST){
        super(context, R.layout.basket_item, CART_LIST);
        this.context = context;
        this.CART_LIST = CART_LIST;
    }
    @Override
    public int getCount() {
        return CART_LIST.size();
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
         departView = inflater.inflate(R.layout.basket_item, parent, false);
        findViewsId();
        basket_name.setText(CART_LIST.get(position).getName());
        basket_price.setText(String.valueOf(CART_LIST.get(position).getPrice()));
        basket_quantity.setText(String.valueOf(CART_LIST.get(position).getQuantity())+"");

        Log.e("cart adb q",String.valueOf(CART_LIST.get(position).getQuantity()));

        img_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<PRODUCT_SUGAR> all_compared_list = PRODUCT_SUGAR.listAll(PRODUCT_SUGAR.class);
                Log.i("listcompared", all_compared_list.size() + "");
                Select youngAuthorQuery = Select.from(PRODUCT_SUGAR.class)
                        .where(Condition.prop("itemid").eq(CART_LIST.get(position).getItemid()));
                Log.i("sellllec", youngAuthorQuery + "");

                deletecompare(position);
            }
        });

        return departView;
    }

    private void deletecompare(int position) {
        List<PRODUCT_SUGAR> authors = PRODUCT_SUGAR.find(PRODUCT_SUGAR.class, "itemid = ?", String.valueOf(CART_LIST.get(position).getItemid()));
        Log.e("author",CART_LIST.get(position).getItemid() +"");
        PRODUCT_SUGAR.deleteAll(PRODUCT_SUGAR.class, "itemid = ?", String.valueOf(CART_LIST.get(position).getItemid()));
        CART_LIST.remove(position);
        notifyDataSetChanged();
       /* ((Activity)context).finish();
        Intent intent = ((Activity) context).getIntent();
        // intent.putExtra("subj_id", deplist.get(pos));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
        context.getApplicationContext().startActivity(intent);*/
    }

    private void findViewsId() {
        basket_img =(ImageView)departView.findViewById(R.id.basket_img);
        img_delete =(ImageView)departView.findViewById(R.id.img_delete);
        basket_name =(TextView) departView.findViewById(R.id.basket_name);
        basket_price =(TextView)departView.findViewById(R.id.basket_price);
        basket_quantity =(TextView)departView.findViewById(R.id.basket_quantity);
        basket_total =(TextView)departView.findViewById(R.id.basket_total);
    }
}
