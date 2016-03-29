package com.example.esteban.legalmovil;

import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.TabHost;

import java.util.List;
import java.util.Vector;

@SuppressWarnings("deprecation")

public class MainMenu extends ActionBarActivity implements
        TabHost.OnTabChangeListener, ViewPager.OnPageChangeListener {

    private TabHost tabHost;
    private ViewPager viewPager;
    int i = 0;
    private Adapter myViewPagerAdapter;

       class FakeContent implements TabHost.TabContentFactory {
           private final Context mContext;

           public FakeContent(Context context) {
               mContext = context;
           }

           @Override
           public View createTabContent(String tag) {
               View v = new View(mContext);
               v.setMinimumHeight(0);
               v.setMinimumWidth(0);
               return v;
           }
       }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        setTitle(null);
        Toolbar topToolBar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(topToolBar);
        topToolBar.setLogo(R.drawable.logo_main);
        topToolBar.setLogoDescription(getResources().getString(R.string.logo_desc));

        i++;
        this.initializeTabHost(savedInstanceState);
        this.initializeViewPager();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    private void initializeViewPager() {
        List<Fragment> fragments = new Vector<Fragment>();

        fragments.add(new Opcion1());
        fragments.add(new Opcion2());
        fragments.add(new Opcion3());


        this.myViewPagerAdapter = new Adapter(
                getSupportFragmentManager(), fragments);
        this.viewPager = (ViewPager) super.findViewById(R.id.viewPager);
        this.viewPager.setAdapter(this.myViewPagerAdapter);
        this.viewPager.setOnPageChangeListener(this);

        onRestart();

    }

    private void initializeTabHost(Bundle args) {

        tabHost = (TabHost) findViewById(android.R.id.tabhost);
        tabHost.setup();
        TabHost.TabSpec tab1=tabHost.newTabSpec("Uno");
        TabHost.TabSpec tab2=tabHost.newTabSpec("Dos");
        TabHost.TabSpec tab3=tabHost.newTabSpec("Tres");

      //  tab1.setIndicator("Inicio");
        tab1.setIndicator("",getResources().getDrawable(R.mipmap.opcion));
       // tab2.setIndicator("Menu");
        tab2.setIndicator("",getResources().getDrawable(R.mipmap.noticia));

        //tab3.setIndicator("Salida");
        tab3.setIndicator("",getResources().getDrawable(R.mipmap.red));

        tab1.setContent(new FakeContent(this));
        tab2.setContent(new FakeContent(this));
        tab3.setContent(new FakeContent(this));


        tabHost.addTab(tab1);
        tabHost.addTab(tab2);
        tabHost.addTab(tab3);

        tabHost.setOnTabChangedListener(this);
    }

    @Override
    public void onTabChanged(String tabId) {
        int pos = this.tabHost.getCurrentTab();
        this.viewPager.setCurrentItem(pos);

        HorizontalScrollView hScrollView = (HorizontalScrollView) findViewById(R.id.hScrollView);
        View tabView = tabHost.getCurrentTabView();
        int scrollPos = tabView.getLeft()
                - (hScrollView.getWidth() - tabView.getWidth()) / 2;
        hScrollView.smoothScrollTo(scrollPos, 0);

    }

    @Override
    public void onPageScrollStateChanged(int arg0) {
    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {
    }

    @Override
    public void onPageSelected(int position) {
        this.tabHost.setCurrentTab(position);
    }
}
