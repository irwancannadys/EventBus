package com.domikado.eventbus;
// Created by Arif Ariyan (me@arifariyan.com) on 1/12/17.

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class FragmentA extends Fragment {


    private EventBus eventBus = EventBus.getDefault();
    private TextView textView;

    public FragmentA() {

        //membutuhkan constructor kosong
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        textView = (TextView) view.findViewById(R.id.user_status);
        return view;
    }

    @Subscribe
    public void onLogingEvent(LoginEvent loginEvent){
        textView.setText("user Status : " + loginEvent.username);

    }

    @Override
    public void onStart() {
        super.onStart();
        eventBus.register(this);
    }

    @Override
    public void onStop() {
        eventBus.unregister(this);
        super.onStop();

    }
}
