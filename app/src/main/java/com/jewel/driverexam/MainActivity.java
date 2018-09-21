package com.jewel.driverexam;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.yokeyword.fragmentation.Fragmentation;
import me.yokeyword.fragmentation.SupportActivity;
import me.yokeyword.fragmentation.SupportFragment;

public class MainActivity extends SupportActivity implements BottomNavigationView.OnNavigationItemSelectedListener {


    @BindView(R.id.nav_bottom)
    BottomNavigationView navBottom;
    @BindView(R.id.layout_content)
    FrameLayout layoutContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        navBottom.setItemIconTintList(null);
        navBottom.setOnNavigationItemSelectedListener(this);

        SupportFragment fragment = findFragment(FragmentTopicOne.class);
        if(fragment == null) {
            loadRootFragment(R.id.layout_content, FragmentTopicOne.newInstance());
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_one:
                navBottom.setItemTextColor(getResources().getColorStateList(R.color.selector_text_one));
                break;
            case R.id.action_four:
                navBottom.setItemTextColor(getResources().getColorStateList(R.color.selector_text_four));
                break;
            case R.id.action_category:
                navBottom.setItemTextColor(getResources().getColorStateList(R.color.selector_text_category));
                break;
        }
        return true;
    }
}
