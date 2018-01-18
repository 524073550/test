package com.zhke.donghua;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements  ViewPager.OnPageChangeListener {

    private ViewPager mViewPager;
    private List<Fragment> mFragments = new ArrayList<>();
    private LinearLayout containerGrayPoint;
    private View redPoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CommentDailog commentDailog = new CommentDailog(this);
        commentDailog.show();
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        containerGrayPoint = (LinearLayout) findViewById(R.id.container_gray_point);
        redPoint = (View) findViewById(R.id.red_point);
        mFragments.add(new GuidFragment1());
        mFragments.add(new GuidFragment2());
        mFragments.add(new GuidFragment3());
        mViewPager.setOffscreenPageLimit(3);
        initIndicator();
        mViewPager.setAdapter(new GuidAdapter(this,mFragments,getSupportFragmentManager()));
        mViewPager.addOnPageChangeListener(this);
    }

    private void initIndicator() {
        for (int i = 0; i < mFragments.size(); i++) {
            View view = new View(this);
            view.setBackgroundResource(R.drawable.point_gray_bg);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(10,10);
            params.rightMargin = 20;//设置右边距
            containerGrayPoint.addView(view,params);
        }


    }

    //小灰点之间的宽度
    private int width;
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if(width == 0){
            width = containerGrayPoint.getChildAt(1).getLeft() - containerGrayPoint.getChildAt(0).getLeft();
        }

        //修改小红点与相对布局的左边距
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) redPoint.getLayoutParams();
        params.leftMargin = (int)(position*width + width*positionOffset);
        redPoint.setLayoutParams(params);
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


}
