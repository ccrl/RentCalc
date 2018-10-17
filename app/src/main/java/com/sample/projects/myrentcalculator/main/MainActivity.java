package com.sample.projects.myrentcalculator.main;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.sample.projects.myrentcalculator.R;
import com.sample.projects.myrentcalculator.adapters.HomeViewPagerAdapter;
import com.sample.projects.myrentcalculator.data.DataProvider;
import com.sample.projects.myrentcalculator.databinding.ActivityMainBinding;
import com.sample.projects.myrentcalculator.dialog.AddUnitDialog;
import com.sample.projects.myrentcalculator.eventhandler.MainEventHandler;
import com.sample.projects.myrentcalculator.fragments.DipologFragment;
import com.sample.projects.myrentcalculator.fragments.ManilaFragment;
import com.sample.projects.myrentcalculator.interfaces.MainInterface;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        ViewPager.OnPageChangeListener,
        MainInterface.OnClick {

    //region VARIABLES
    private ActivityMainBinding binding;
    private DataProvider dataProvider;
    private MainEventHandler eh;
    private Bundle bundle;

    public static String KEY_TITLE =  "key_title";
    public static String KEY_FRAGMENT =  "key_fragment";
    public static String VALUE_FRAGMENT_MANILA =  "key_fragment_manila";
    public static String VALUE_FRAGMENT_DIPOLOG =  "key_fragment_dipolog";
    public static String VALUE_MANILA =  "value_manila";
    public static String VALUE_DIPOLOG =  "value_dipolog";
    //endregion

    //region VIEWS
    private AppCompatImageButton mImageButtonHamburger;
    private DrawerLayout mDrawerLayout;
    private FrameLayout mLayoutMainContainer;
    private NavigationView mNavigationView;
    private RecyclerView mNavDrawerRecyclerView;
    private RecyclerView mPersonsRecyclerView;
    private TabLayout mTabLayout;
    private Toolbar mToolbar;
    private ViewPager mViewPager;
    //endregion

    //region SETUP
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, getLayoutResourceId());

        bundle = new Bundle();
        dataProvider = new DataProvider();

        setupToolbar();
        setupViewBinding();
        setupMainViewPager();
    }

    private void setupToolbar() {
        mToolbar = binding.mIncludeToolbar.mToolbarMain;
        setSupportActionBar(mToolbar);
    }

    private void setupViewBinding() {
        eh = new MainEventHandler(this, this, this);
        binding.mIncludeToolbar.setEh(eh);
        binding.mIncludeMainLayout.setEh(eh);

        mDrawerLayout = binding.mDrawerLayout;
        mNavigationView = binding.mNavigationView;
        mImageButtonHamburger = binding.mIncludeToolbar.mImageButtonHamburger;
        mViewPager = binding.mIncludeMainLayout.mMainViewPager;
        mTabLayout = binding.mIncludeMainLayout.mTabLayoutTabs;

        mNavigationView.setNavigationItemSelectedListener(this);
    }

    private void setupMainViewPager() {
        String manila = getString(R.string.label_manila);
        String dipolog = getString(R.string.label_dipolog);

        HomeViewPagerAdapter adapter = new HomeViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ManilaFragment(), manila);
        adapter.addFragment(new DipologFragment(), dipolog);

        mViewPager.setAdapter(adapter);
        mViewPager.addOnPageChangeListener(this);

        mTabLayout.setupWithViewPager(mViewPager);
    }
    //endregion

    //region ON CLICK
    @Override
    public void onClickHamburgerButton() {
        if (!mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.openDrawer(GravityCompat.START);
        }
    }

    @Override
    public void onClickAddUnitButton() {
        Log.i("MAIN", "ADD UNIT BUTTON");
//        bundle

        AddUnitDialog dialog = new AddUnitDialog();
        dialog.setArguments(bundle);
        dialog.show(getSupportFragmentManager(), "AddUnitDialog");
    }

    @Override
    public void onClickRemoveUnitButton() {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mItemHome:
                Log.d("Main", "HOME");
                break;
            case R.id.mItemManila:
                Log.d("Main", "ELEC");

                break;
            case R.id.mItemDipolog:
                Log.d("Main", "WATER");

                break;
        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
    //endregion

    //region VIEWPAGER ONPAGECHANGELISTENER
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (position == 0) {
            Log.d("MAIN_PAGE_SCROLLED", "MANILA");
            bundle.putString(KEY_TITLE, VALUE_MANILA);
            bundle.putString(KEY_FRAGMENT, VALUE_FRAGMENT_MANILA);
        } else if (position == 1) {
            Log.d("MAIN_PAGE_SCROLLED", "DIPOLOG");
            bundle.putString(KEY_TITLE, VALUE_DIPOLOG);
            bundle.putString(KEY_FRAGMENT, VALUE_FRAGMENT_DIPOLOG);
        }
    }

    @Override
    public void onPageSelected(int position) {
        if (position == 0) {
            Log.d("MAIN_PAGE_SELECTED", "MANILA");
            bundle.putString(KEY_TITLE, VALUE_MANILA);
            bundle.putString(KEY_FRAGMENT, VALUE_FRAGMENT_MANILA);
        } else if (position == 1) {
            Log.d("MAIN_PAGE_SELECTED", "DIPOLOG");
            bundle.putString(KEY_TITLE, VALUE_DIPOLOG);
            bundle.putString(KEY_FRAGMENT, VALUE_FRAGMENT_DIPOLOG);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
    //endregion

    //region GETTERS AND SETTERS
    private int getLayoutResourceId() {
        return R.layout.activity_main;
    }
    //endregion
}
