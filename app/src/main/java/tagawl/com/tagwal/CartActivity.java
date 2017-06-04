package tagawl.com.tagwal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import Adapter.CartAdapter;

public class CartActivity extends AppCompatActivity {
ListView list_cart;
    private List<PRODUCT_SUGAR> CART_LIST;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_itemcart);
        CART_LIST =new ArrayList<>();
        ListView list_cart=(ListView)findViewById(R.id.list_cart);
        CART_LIST = PRODUCT_SUGAR.listAll(PRODUCT_SUGAR.class);
        CartAdapter cart_adapter = new CartAdapter(CartActivity.this,CART_LIST);
        list_cart.setAdapter(cart_adapter);
    }
}
