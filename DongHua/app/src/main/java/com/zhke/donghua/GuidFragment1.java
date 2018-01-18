package com.zhke.donghua;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

/**
 * Created by Administrator on 2017/12/12.
 */

public class GuidFragment1 extends BaseFragment {
    @Override
    protected void lazyLoad() {

    }


    @Override
    public View getBaseView(LayoutInflater inflater, ViewGroup container) {
        View inflate = inflater.inflate(R.layout.fragment_guide1, container, false);
        return inflate;
    }

    @Override
    protected void initView(View view) {
        ImageView imageView1 = (ImageView) view.findViewById(R.id.iv1);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.iv2);
        initAnmi1(imageView1);
        initAnmi2(imageView2);
    }

    private void initAnmi2(ImageView imageView2) {
        TranslateAnimation ta = new TranslateAnimation(Animation.RELATIVE_TO_SELF,
                10f,
                Animation.RELATIVE_TO_PARENT,
                0,

                Animation.RELATIVE_TO_SELF,
                10f,
                Animation.RELATIVE_TO_SELF,
                0);

        //动画播放的时间长度
        ta.setDuration(2000);
        //让iv播放aa动画
        imageView2.startAnimation(ta);
    }

    private void initAnmi1(ImageView imageView1) {
      /*
		 * 第一个参数fromXType 位移的x 轴起始坐标的类型(相对于自己还是相对父容器)
		 * 第二参数fromXValue x 轴起点(0:自身最左边的x 坐标1：最右边的x 坐标)
		 * 第三个参数toXType X 轴终点坐标的类型
		 * 第四个参数toXValue X 轴的终点
		 * 第五个参数fromYType Y 轴起始坐标的类型
		 * 第六个参数fromYValue Y 轴的起始坐标
		 * 第七个参数toYType Y 轴的终点坐标的类型
		 * 第八个参数toYValue Y 轴的终点坐标
		*/
        TranslateAnimation ta = new TranslateAnimation(Animation.RELATIVE_TO_SELF,
                -10f,
                Animation.RELATIVE_TO_PARENT,
                0,

                Animation.RELATIVE_TO_SELF,
                -10f,
                Animation.RELATIVE_TO_SELF,
               0);

        //动画播放的时间长度
        ta.setDuration(2000);
        //让iv播放aa动画
        imageView1.startAnimation(ta);
    }

    @Override
    protected void initEvent() {

    }
}
