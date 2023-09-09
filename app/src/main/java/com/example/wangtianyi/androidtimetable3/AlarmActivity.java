package com.example.wangtianyi.androidtimetable3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

public class AlarmActivity extends AppCompatActivity implements View.OnClickListener {
    private Button bt_select,bt_time;
    private String result, time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.height = LinearLayout.LayoutParams.WRAP_CONTENT;
        params.width = LinearLayout.LayoutParams.MATCH_PARENT;
        getWindow().setAttributes(params);
        bt_select = (Button) findViewById(R.id.bt_select);
        bt_time = (Button) findViewById(R.id.bt_time);

        bt_select.setOnClickListener(this);
        bt_time.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_select:
                Intent intent = new Intent(AlarmActivity.this, NotesActivity.class);
                intent.putExtra("code",2);
                startActivityForResult(intent,1);
                break;
            case R.id.bt_time:
                Intent intent1 = new Intent(AlarmActivity.this, AlarmSetting.class);
                intent1.putExtra("thing",result);
                startActivityForResult(intent1, 3);
                break;
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK){
            result = data.getStringExtra("result");
            bt_select.setText(result);
        }
        if (requestCode == 3 && resultCode == RESULT_OK){
            time = data.getStringExtra("time");
            bt_time.setText(time);
        }
    }
}
