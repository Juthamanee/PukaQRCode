package appjn.nivesrat.juthamaneen.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //Explicit พื้นที่ประกาศตัวแปรอยู่ใน Class แต่นอก Method
    //ประกาศตัวแปรประกอบด้วย 3 อย่าง Access, File, Name
    //ประกาศตัวแปรแบบ Public จะใช้ได้ทั้งหมด
    //ประกาศตัวแปรแบบ Private จะใช้ได้เฉพาะใน class หรือ Method
    private EditText userEditText, passwordEditText;
    private TextView textView;//Shift+Ctrl+Enter จะเป็นการใส่เครื่องหมายปิดใน Code 
    private Button button;
    //Ctrl+Alt+L เป็นการสั่งเรียงโคด shortkey ดูได้ที่ Help--Keymap preference

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initial View การผูกความสัมพันธ์ ของตัวแปร และชื่อ view
        initialView();

        //controller
        controller();

    } //Main Method ชื่อต้องตั้งเป็นตัวเล็กตัวแรกและไม่มีช่องว่าง สามารถใส่ตัวใหญ่ในชื่อได้

    private void controller() {
        textView.setOnClickListener(MainActivity.this);
        button.setOnClickListener(MainActivity.this);

    }

    private void initialView() {
        //สร้าง method หลังพิมพ์ initialView แล้ว กด Ctrl+Enter
        //Void ทำงานเสร็จไม่ส่งค่า
        //...ทำงานสร็จ return data
        userEditText = (EditText) findViewById(R.id.edtUser);
        passwordEditText = (EditText) findViewById(R.id.edtPassword);
        textView = (TextView) findViewById(R.id.txtNewRegist);
        button = (Button) findViewById(R.id.btnLogin);

    }

    @Override
    public void onClick(View v) {

        //For TextView
        if (v == textView) {
            //Intent to Register
            Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
            startActivity(intent);
        }

        //For Button
        if (v == button) {

        }

    }
} //Main Class นี่คือ คลาสหลัก
