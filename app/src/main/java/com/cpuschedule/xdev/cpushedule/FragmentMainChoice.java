package com.cpuschedule.xdev.cpushedule;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentMainChoice extends Fragment {

    FragmentMainChoiceBinding mBinding;
    public static final String TAG = "MainFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(!MainActivity.isNetworkAvailable(getContext())){
            return inflater.inflate(R.layout.view_internet_missing,container,false);
        }
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_main_choidce,container,false);
        return mBinding.getRoot();
    }

}
