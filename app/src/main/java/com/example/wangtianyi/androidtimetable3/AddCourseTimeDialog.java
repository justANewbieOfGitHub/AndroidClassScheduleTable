package com.example.wangtianyi.androidtimetable3;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2019/5/11.
 */

public class AddCourseTimeDialog extends Dialog {

    @BindView(R.id.no)
    Button buttonCancel;
    @BindView(R.id.yes)
    Button buttonOk;
    @BindView(R.id.editStartTime)
    EditText editStartTime;
    @BindView(R.id.editEndTime)
    EditText editEndTime;

    public AddCourseTimeDialog(@NonNull Context context) {
        super(context, R.style.dialog_add_course);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_add_course_time);
        // 将对话框的大小按屏幕大小的百分比设置
        WindowManager m = getWindow().getWindowManager();
        Display d = m.getDefaultDisplay();
        final WindowManager.LayoutParams p = getWindow().getAttributes();
        p.height = (int) (d.getHeight() * 0.7);
        p.width = (int) (d.getWidth() * 0.7);
        getWindow().setAttributes(p);

        setCanceledOnTouchOutside(false);
        ButterKnife.bind(this);
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    public void setBtnSure(View.OnClickListener listener) {
        buttonOk.setOnClickListener(listener);
    }

    public void setBtnCancel(View.OnClickListener listener) {
        buttonCancel.setOnClickListener(listener);
    }

    public void setEdStartTime(String str) {
        editStartTime.setText(str);
    }

    public EditText getEdStartTime() {
        return editStartTime;
    }

    public void setEdEndTime(String str) {
        editEndTime.setText(str);
    }

    public EditText getEdEndTime() {
        return editEndTime;
    }
}
