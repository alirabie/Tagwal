package tagawl.com.tagwal;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.gitonway.lee.niftymodaldialogeffects.lib.Effectstype;
import com.gitonway.lee.niftymodaldialogeffects.lib.NiftyDialogBuilder;

import java.util.ArrayList;
import java.util.List;

import Adapter.CartAdapter;
import ConstantClasss.Constanturl;
import ConstantClasss.Idealinterface;
import Fragments.FragmentHome;
import MODEL.Area;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NavDrawerActivity extends ActionBarActivity implements View.OnClickListener {

    private  com.andexert.library.RippleView rel_home,rel_personaldata,cart,share,rel_contact,rel_logout;
    private TextView txt_shop,txt_data,txt_cart,txt_share,txt_contact,txt_logout,Txtcat;
    private DrawerLayout mDrawer;
    private ImageButton img_card;
    private LinearLayout sideMenu;
    ImageButton ic_menu;
    private Toolbar mToolbar;
    Fragment selectedFragment = null;
    NiftyDialogBuilder dialogBuildercard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_drawer);
        mDrawer = (DrawerLayout) findViewById(R.id.sideMenuDrawer);
        sideMenu = (LinearLayout) findViewById(R.id.sideMenu);
        setSelectedFragment(0);
        findViewsById();
        set_action_bar();
        setClickLisitner();
        ic_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mDrawer.isDrawerOpen(sideMenu))
                    mDrawer.closeDrawer(sideMenu);
                else
                    mDrawer.openDrawer(sideMenu);
            }
        });




        Constanturl.createService(Idealinterface.class).GetAreas().enqueue(new Callback<List<Area>>() {
            @Override
            public void onResponse(Call<List<Area>> call, Response<List<Area>> response) {

                if (response.isSuccessful()) {

                    Log.e("Success", response.code() + " ");


                } else {
                    Log.e("Not Success", response.code() + " "+response.message()+" "+response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<List<Area>> call, Throwable t) {

                Log.e("Failure",t.getMessage() + "");
            }

        });


















    }

    private void findViewsById() {
        rel_home = (com.andexert.library.RippleView) findViewById(R.id.rel_home);
        share = (com.andexert.library.RippleView) findViewById(R.id.share);
        rel_contact = (com.andexert.library.RippleView) findViewById(R.id.rel_contact);
        rel_logout = (com.andexert.library.RippleView) findViewById(R.id.rel_logout);
        rel_personaldata = (com.andexert.library.RippleView) findViewById(R.id.rel_personaldata);
        cart = (com.andexert.library.RippleView) findViewById(R.id.cart);
        txt_cart = (TextView) findViewById(R.id.txt_cart);
        txt_data = (TextView) findViewById(R.id.txt_data);
        txt_logout = (TextView) findViewById(R.id.txt_logout);
        txt_share = (TextView) findViewById(R.id.txt_share);
        txt_contact = (TextView) findViewById(R.id.txt_contact);
        txt_shop =(TextView)findViewById(R.id.txt_shop);
    }

    private void setClickLisitner() {
        rel_contact.setOnClickListener(this);
        rel_home.setOnClickListener(this);
        rel_logout.setOnClickListener(this);
        rel_personaldata.setOnClickListener(this);
       share.setOnClickListener(this);
        cart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
             case R.id.rel_home:
                selectedFragment = new FragmentHome();
                selectFragment();
                mDrawer.closeDrawer(sideMenu);
                break;
        }

    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void set_action_bar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        //  mToolbar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#c94929")));
        Txtcat = (TextView) findViewById(R.id.Txtcat);
        ic_menu = (ImageButton) findViewById(R.id.ic_menu);
        img_card = (ImageButton) findViewById(R.id.img_card);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //
        img_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*dialogBuildercard = NiftyDialogBuilder.getInstance(NavDrawerActivity.this);
                dialogBuildercard
                        .withDialogColor("#ededed")
                        .withDuration(700)                                          //def
                        .withEffect(Effectstype.Sidefill)
                        .isCancelableOnTouchOutside(false)                           //def    | isCancelable(true)
                        .setCustomView(R.layout.layout_itemcart, v.getContext())
                        .show();*/
                Intent intent = new Intent(NavDrawerActivity.this,CartActivity.class);
                startActivity(intent);


            }
        });
    }
    private void setSelectedFragment(int position) {

        switch (position) {
            case 0:
                selectedFragment = new FragmentHome();
                replace_fragment(selectedFragment,"container");
                // sub_title.setText("اخبار الاداره");
                break;
           /* case 1:
                selectedFragment = new Fragment_About();
                replace_fragment(selectedFragment,"");
                sub_title.setText(R.string.AboutAsia);
                break;

            case 2:
                selectedFragment = new Fragment_contact();
                replace_fragment(selectedFragment,"");
                sub_title.setText(R.string.contactus);
                break;

            case 3:
                selectedFragment = new Fragment_bestOffer();
                replace_fragment(selectedFragment,"");
                sub_title.setText(R.string.latestproduct);
                break;

            case 4:
                selectedFragment = new Fragment_latestproduct();
                replace_fragment(selectedFragment,"");
                break;*/
            default:
                break;
        }

    }
    private void selectFragment() {

        if (selectedFragment != null) {

            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, selectedFragment).addToBackStack("0").commit();

        }
    }
    public void replace_fragment(Fragment frag ,String frag_tag){
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragmentContainer, frag,frag_tag);
        ft.commit();

    }
}
