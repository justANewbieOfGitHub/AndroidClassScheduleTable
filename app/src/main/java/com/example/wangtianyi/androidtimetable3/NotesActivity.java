package com.example.wangtianyi.androidtimetable3;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2019/5/27.
 */

public class NotesActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @BindView(R.id.toolbar2)
    Toolbar toolbar;

    @BindView(R.id.list)
    ListView listView;
    private List<NoteMode> noteList;
    private NoteAdapter noteAdapter;

    private NotesHelper notesHelper = new NotesHelper(this, "databaseNotes.db", null, 1);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        loadNotes();     //从数据库中加载所有备注信息
        listView.setOnItemClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_notes, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings:
                addNoteDialog();
                break;
        }
        return true;
    }

    /*
    *加载所有备注信息
    */
    private void loadNotes() {
        SQLiteDatabase sqLiteDatabase = notesHelper.getWritableDatabase();
        noteList = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from notes", null);
        if (cursor.moveToNext()) {
            do {
                NoteMode note = new NoteMode(
                        cursor.getString(cursor.getColumnIndex("text")),
                        cursor.getString(cursor.getColumnIndex("texttime")),
                        cursor.getString(cursor.getColumnIndex("alarm"))
                );
                note.setId(cursor.getInt(cursor.getColumnIndex("id")));
                noteList.add(note);
            } while (cursor.moveToNext());
        }
        noteAdapter = new NoteAdapter(this,noteList);
        listView.setAdapter(noteAdapter);
        cursor.close();
    }



    /**
     * 添加Note具体信息
     */
    private void addNoteDialog() {
        AlertDialog.Builder build = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(this).inflate(R.layout.my_view, null);
        final EditText editId = (EditText) view.findViewById(R.id.edit_thing);
        build.setPositiveButton("确定", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                String text = editId.getText().toString();
                String time = TimeUtil.getDate();
                if(text != null && time != null) {
                    if (addNote(text, time)){
                        loadNotes();
                    }
                }
            }
        });

        build.setNegativeButton("取消", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                dialog.dismiss();
            }
        });

        AlertDialog dialog = build.create();
        dialog.setTitle("添加");
        dialog.setView(view);
        dialog.show();
    }

    private boolean addNote(String text, String textTime){
        SQLiteDatabase sqLiteDatabase = notesHelper.getWritableDatabase();
        NoteMode noteMode = new NoteMode(text, textTime, null);

        ContentValues values = new ContentValues();
        values.put("text", noteMode.getText());
        values.put("texttime", noteMode.getTextTime());
        long rowId = sqLiteDatabase.insert("notes", null, values);//返回新添记录的行号，与主键id无关
        if (rowId != -1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (getIntent().getIntExtra("code",0) == 2) {
            Intent intent = new Intent();
            //把返回数据存入Intent
            intent.putExtra("result", noteList.get(position).getText());
            //设置返回数据
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}
