package com.example.wangtianyi.androidtimetable3;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;




import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2019/5/17.
 */

public class MessageDialog extends Dialog {

    @BindView(R.id.tv_content)
    TextView tvContent;
    @BindView(R.id.btn_cancel)
    TextView btnCancel;
    @BindView(R.id.btn_sure)
    TextView btnSure;

    public MessageDialog(Context context) {
        super(context, R.style.dialog_add_course);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_message);

        setCanceledOnTouchOutside(false);
        ButterKnife.bind(this);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    public void setContent(String content){
        tvContent.setText(content);
    }
    public void setBtnSure(String str, View.OnClickListener listener){
        btnSure.setText(str);
        btnSure.setOnClickListener(listener);
    }
    public void setBtnCancel(String str, View.OnClickListener listener){
        btnCancel.setText(str);
        btnCancel.setOnClickListener(listener);
    }
}
