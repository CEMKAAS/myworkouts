package com.zaroslikov.myworkouts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigation = findViewById(R.id.nav_view);
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


        new NavigationBarView.OnItemSelectedListener(item ->{});

        bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                position = item.getItemId();
                if(position == R.id.warehouse_button){

                    replaceFragment(new WarehouseFragment());
                    appBar.setTitle("Мой Склад");
                    fab.hide();
                    fab.setVisibility(View.GONE);
                } else if (position==R.id.add_button){
                    replaceFragment(new AddFragment());
                } else if (position == R.id.writeOff_button){
                    replaceFragment(new WriteOffFragment());
                } else if (position == R.id.finance_button) {
                    replaceFragment(new FinanceFragment());
                }

                return false;
            }
        });


       bottomNavigation.setOnItemSelectedListener(item -> {
           position = item.getItemId();
           if(position == R.id.warehouse_button){

               replaceFragment(new WarehouseFragment());
               appBar.setTitle("Мой Склад");
               fab.hide();
               fab.setVisibility(View.GONE);
           } else if (position==R.id.add_button){
               replaceFragment(new AddFragment());
           } else if (position == R.id.writeOff_button){
               replaceFragment(new WriteOffFragment());
           } else if (position == R.id.finance_button) {
               replaceFragment(new FinanceFragment());
           }
       });




        bottomNavigation.setOnNavigationItemSelectedListener(item -> {
            position = item.getItemId();

            if(position == R.id.warehouse_button){
                replaceFragment(new WarehouseFragment());
                appBar.setTitle("Мой Склад");
                fab.hide();
                fab.setVisibility(View.GONE);
            } else if (position==R.id.add_button){
                replaceFragment(new AddFragment());
            } else if (position == R.id.writeOff_button){
                replaceFragment(new WriteOffFragment());
            } else if (position == R.id.finance_button) {
                replaceFragment(new FinanceFragment());
            }

            return true;
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