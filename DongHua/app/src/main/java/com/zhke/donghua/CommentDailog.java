package com.zhke.donghua;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2017/8/10.
 */

public class CommentDailog extends Dialog implements TextWatcher, View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private final int mScreenWidth;
    private EditText mEtContent;
    private ImageButton mIbRelevance;
    public CheckBox mCbRetransmission;
    private Button mSend;
    private final int mScreenHeight;
    private LinearLayout mDialogLatout;
    private ImageButton mExpression;

    public CommentDailog(Context context) {
        super(context, R.style.BottomDialog);
        //设置在dailog区域外点击消失属性
        setCanceledOnTouchOutside(true);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        mScreenWidth = displayMetrics.widthPixels;
        mScreenHeight = displayMetrics.heightPixels;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_content_normal);
        Window window = getWindow();
        window.setBackgroundDrawableResource(R.drawable.bg);
        WindowManager.LayoutParams params = window.getAttributes();
        params.gravity = Gravity.CENTER ;
        params.width = mScreenWidth*3/4;
        window.setAttributes(params);
        initView();
        initEvent();

    }

    private void initEvent() {
        mEtContent.addTextChangedListener(this );
        mSend.setOnClickListener(this);
        mIbRelevance.setOnClickListener(this);
        mCbRetransmission.setOnCheckedChangeListener(this);
        mSend.setClickable(false);
    }

    private void initView() {
        mEtContent = (EditText) findViewById(R.id.comment_ed_content);
        mIbRelevance = (ImageButton) findViewById(R.id.comment_relevance1);
        mCbRetransmission = (CheckBox) findViewById(R.id.comment_retransmission);
        mSend = (Button) findViewById(R.id.comment_send);
        mDialogLatout = (LinearLayout) findViewById(R.id.dialog_geng);
        mExpression = (ImageButton) findViewById(R.id.comment_expression);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        if (!TextUtils.isEmpty(editable)) {
            mSend.setClickable(true);

        }else {
            mSend.setClickable(false);

        }
    }

    @Override
    public void onClick(View view) {
        if (view ==mSend &&mSend.isClickable()) {
            //TODO:发送到评论
                dismiss();
            mSend.setClickable(false);

        }else if (mIbRelevance == view) {
            //TODO:@

        }
    }
    //TODO:发表到动弹
    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        if (isChecked) {

        }else {

        }
    }

    //设置表情图标的是否显示方法
    public void  seteXpressionOpenOrClose(boolean isOpen) {
        mExpression.setVisibility(isOpen ? View.VISIBLE:View.GONE);
    }

    //是否转发到都动弹是否显示
    public  void  setCbOpenOrClose(boolean isOpen) {
        mCbRetransmission.setVisibility(isOpen ? View.VISIBLE:View.GONE);
    }
}
