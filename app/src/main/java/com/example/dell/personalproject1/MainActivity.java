package com.example.dell.personalproject1;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String message = new String("查询失败");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        event();
    }

    public void event() {
        final EditText editText = (EditText)findViewById(R.id.search);
        final RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        final Button btn = (Button)findViewById(R.id.button);
        if(btn != null){
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    message = (editText.getText().toString().isEmpty() ? "搜索内容不能为空" :
                            (editText.getText().toString().equals("Health") ? ((RadioButton) findViewById(radioGroup.getCheckedRadioButtonId())).getText() + "搜索成功" : "搜索失败"));

                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);

                alertDialog.setTitle("提示").setMessage(message).setPositiveButton("确认",
                    new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick (DialogInterface dialog,int which){
                        Toast.makeText(getApplicationContext(), "对话框“确定”按钮被点击", Toast.LENGTH_SHORT).show();
                    }
                    }).
                setNegativeButton("取消",
                    new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick (DialogInterface dialog,int which){
                        Toast.makeText(getApplicationContext(), "对话框“取消”按钮被点击", Toast.LENGTH_SHORT).show();
                    }
                    }).create().show();
                }
            });
        }
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override public void onCheckedChanged(RadioGroup group, int checkedId) {
                Toast.makeText(getApplicationContext(),((RadioButton)findViewById(radioGroup.getCheckedRadioButtonId())).getText() + "被选中",Toast.LENGTH_SHORT).show();
            } });
    }
}
