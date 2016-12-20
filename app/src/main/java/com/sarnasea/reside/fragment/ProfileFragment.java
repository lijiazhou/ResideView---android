package com.sarnasea.reside.fragment;

import com.sarnasea.reside.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ProfileFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        
    	View v = inflater.inflate(R.layout.profile, container, false);
    	return v;
    }

}
