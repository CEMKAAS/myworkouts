package com.zaroslikov.myworkouts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;


import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;
import com.zaroslikov.myworkouts.db.MyDatabaseHelper;

public class MainActivity extends AppCompatActivity {

    private MaterialToolbar appBar;
    private int position = 0;
    private MyDatabaseHelper myDB;
    private BottomNavigationView bottomNavigation;
    private ViewPagerAdapter viewPagerAdapter;
    private ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigation = findViewById(R.id.nav_view);
        viewPager2 =findViewById(R.id.conteiner);
        viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager2.setAdapter(viewPagerAdapter);

        myDB = new MyDatabaseHelper(this);
        if (savedInstanceState == null) {  //при повороте приложение не брасывается
        }

        appBar = findViewById(R.id.topAppBar);
        // AppBar

        appBar.setOnMenuItemClickListener(item -> {
            switch (item.getItemId()) {
//                case R.id.menu:
//                    replaceFragment(new InFragment());
//                    appBar.setTitle("Информация");
//                    fab.hide();
//                    fab.setVisibility(View.GONE);
//                    break;
//
//                case R.id.deleteAll:
//                    beginIncubator();
//                    break;
            }
            return true;
        });

        bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                position = item.getItemId();
                switch (position) {
                    case R.id.me_button:
                        viewPager2.setCurrentItem(0);
                        break;
                    case R.id.workout_button:
                        viewPager2.setCurrentItem(1);
                        break;
                    case R.id.static_button:
                        viewPager2.setCurrentItem(2);
                        break;
                }
                return false;
            }
        });


        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        bottomNavigation.getMenu().findItem(R.id.me_button).setChecked(true);
                        break;
                    case 1:
                        bottomNavigation.getMenu().findItem(R.id.workout_button).setChecked(true);
                        break;
                    case 2:
                        bottomNavigation.getMenu().findItem(R.id.static_button).setChecked(true);
                        break;

                }

                super.onPageSelected(position);
            }
        });

    }
    //Переходим на фрагмент
    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.conteiner, fragment, "visible_fragment")
                .addToBackStack(null)
                .commit();
    }
}