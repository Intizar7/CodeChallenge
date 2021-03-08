package com.najimaddinova.autoscout24codechallenge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import static com.najimaddinova.autoscout24codechallenge.ItemColorUtil.calculateColor;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerViewClickListener listener;
    private ArrayList<ListItemData> colorList;
    private RecyclerView recyclerView;
    private ColorItemRecyclerViewAdapter colorItemRecyclerViewAdapter;
    private FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        colorList = new ArrayList<>();
        initClickListener();
        populateDataset();
        viewSettings();
    }

    private void initClickListener() {
        class ClickListener implements RecyclerViewClickListener {
            @Override
            public void onClick(ListItemData listItemData) {
                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.content, ItemFragment.newInstance(listItemData));
                ft.commit();
            }
        }
        this.listener = new ClickListener();
    }

    private void populateDataset() {
        for (int i = 1; i <= 100000; i++){
            int colorValue = calculateColor(i);
            ListItemData color = new ListItemData("Item " + i, colorValue);
            colorList.add(color);
        }
    }
    private void viewSettings(){
        colorItemRecyclerViewAdapter = new ColorItemRecyclerViewAdapter(colorList,listener);
        recyclerView.setAdapter(colorItemRecyclerViewAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}