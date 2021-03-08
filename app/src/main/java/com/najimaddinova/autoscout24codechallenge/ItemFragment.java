package com.najimaddinova.autoscout24codechallenge;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
public class ItemFragment extends Fragment {

    ListItemData listItemData;
    TextView textView;
    FrameLayout frameLayout;

    public static ItemFragment newInstance(ListItemData listItemData) {
        Bundle args = new Bundle();
        args.putString("text", listItemData.getName());
        args.putInt("colorValue", listItemData.getColorValue());
        ItemFragment fragment = new ItemFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String text = getArguments().getString("text", "");
        int colorValue = getArguments().getInt("colorValue", 0);
        this.listItemData = new ListItemData(text, colorValue);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_item, container, false);
        textView = view.findViewById(R.id.fragmentItem);
        frameLayout = view.findViewById(R.id.frameLayoutFragment);
        textView.setText(this.listItemData.getName());
        frameLayout.setBackgroundColor(listItemData.getColorValue());
        return  view;

    }
}