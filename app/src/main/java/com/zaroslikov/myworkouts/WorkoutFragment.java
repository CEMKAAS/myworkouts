package com.zaroslikov.myworkouts;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.zaroslikov.myworkouts.db.MyDatabaseHelper;

public class WorkoutFragment extends Fragment {
    private  MyDatabaseHelper myDB;
    private ImageView empty_imageview;
    private TextView no_data;
    private Button buttonAdd;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        myDB = new MyDatabaseHelper(getActivity());
        View layuot = inflater.inflate(R.layout.fragment_workout, container, false);

        empty_imageview = layuot.findViewById(R.id.empty_imageview);
        no_data = layuot.findViewById(R.id.no_data);
        buttonAdd = layuot.findViewById(R.id.workout_button);

        open();

        return layuot;
    }


    public void open(){

        Cursor cursor = myDB.readProject();
        if (cursor.getCount() == 0) {
        empty_imageview.setVisibility(View.VISIBLE);
        no_data.setVisibility(View.VISIBLE);
        buttonAdd.setVisibility(View.VISIBLE);
        }
        cursor.close();
        empty_imageview.setVisibility(View.GONE);
        no_data.setVisibility(View.GONE);

    }


}