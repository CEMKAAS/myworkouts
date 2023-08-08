package com.zaroslikov.myworkouts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;


import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.zaroslikov.myworkouts.db.MyDatabaseHelper;

public class MainActivity extends AppCompatActivity {

    private MaterialToolbar appBar;
    private int position = 0;
    private ExtendedFloatingActionButton fab;
    private MyDatabaseHelper myDB;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        myDB = new MyDatabaseHelper(this);
        if (savedInstanceState == null) {  //при повороте приложение не брасывается

        }
        fab = findViewById(R.id.extended_fab);
        fab.setVisibility(View.GONE);

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

        set();
        binding.navView.setVisibility(View.GONE);
        binding.navView.setOnNavigationItemSelectedListener(item -> {
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