package com.vinrak.app2;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SampleFragment extends Fragment {

    private String mTag = "SampleFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sample, container, false);
    }

    boolean firstTouch = false;
    long time;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final LinearLayout fragmentMainLayout = view.findViewById(R.id.fragmentMainLayout);

        fragmentMainLayout.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == event.ACTION_DOWN) {
                    if (firstTouch && (System.currentTimeMillis() - time) <= 300) {
                        firstTouch = false;
                        //showDropDown();//In my case I want to showDropDown() change this line for whatever you want to do
                        Log.d(mTag, "if executed");
                        fragmentMainLayout.setBackgroundColor(Color.BLUE);
                    } else {
                        firstTouch = true;
                        time = System.currentTimeMillis();
                        Log.d(mTag, "else executed");
                        fragmentMainLayout.setBackgroundColor(Color.RED);
                        return true;
                    }
                }
                return true;
            }
        });
    }
}