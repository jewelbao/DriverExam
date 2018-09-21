package com.jewel.driverexam;

import android.os.Bundle;

import me.yokeyword.fragmentation.SupportFragment;

public class FragmentTopicOne extends SupportFragment {

    public static FragmentTopicOne newInstance() {
        
        Bundle args = new Bundle();
        
        FragmentTopicOne fragment = new FragmentTopicOne();
        fragment.setArguments(args);
        return fragment;
    }
}
