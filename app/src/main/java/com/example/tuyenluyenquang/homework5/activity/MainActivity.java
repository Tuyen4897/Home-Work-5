package com.example.tuyenluyenquang.homework5.activity;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.example.tuyenluyenquang.homework5.R;
import com.example.tuyenluyenquang.homework5.adapter.ContactAdapter;
import com.example.tuyenluyenquang.homework5.contructor.Contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btn_add, btn_save,btn_cancel;
    RecyclerView rcv_list;
    EditText txt_name, txt_phone;
    ArrayList<Contact> list;
    ContactAdapter conAp;
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        handle();
    }

    public void initView(){
        btn_add = (Button) findViewById(R.id.btn_add);
        rcv_list = (RecyclerView) findViewById(R.id.rcv_list);
        layoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        rcv_list.setLayoutManager(layoutManager);
        list = new ArrayList<>();
        list.add(new Contact("cho lam", "1234456"));
        list.add(new Contact("cho lam 2", "123445678"));
        conAp = new ContactAdapter(MainActivity.this,list);
        rcv_list.setAdapter(conAp);
    }

    private void handle(){
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog();
            }
        });
    }

    private void getDialog(){
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_add_item);
        txt_name = (EditText) dialog.findViewById(R.id.txt_name);
        txt_phone = (EditText) dialog.findViewById(R.id.txt_phone);
        btn_save = (Button) dialog.findViewById(R.id.btn_save);
        btn_cancel = (Button) dialog.findViewById(R.id.btn_cancel);
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
