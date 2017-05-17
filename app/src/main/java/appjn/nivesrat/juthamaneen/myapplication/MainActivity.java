package appjn.nivesrat.juthamaneen.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.EmptyStackException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //Explicit พื้นที่ประกาศตัวแปรอยู่ใน Class แต่นอก Method
    //ประกาศตัวแปรประกอบด้วย 3 อย่าง Access, File, Name
    //ประกาศตัวแปรแบบ Public จะใช้ได้ทั้งหมด
    //ประกาศตัวแปรแบบ Private จะใช้ได้เฉพาะใน class หรือ Method
    private EditText userEditText, passwordEditText;
    private TextView textView;//Shift+Ctrl+Enter จะเป็นการใส่เครื่องหมายปิดใน Code 
    private Button button;
    private String userString, passwordString;
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
            //Get Value From EditText
            userString = userEditText.getText().toString().trim();
            passwordString = passwordEditText.getText().toString().trim();

            //Check Space
            if (userString.equals("")||passwordString.equals("")){
                //Have Space
                MyAlert myAlert = new MyAlert(this);
                myAlert.myDialog(getResources().getString(R.string.title_HaveSpace),
                        getResources().getString(R.string.massage_HaveSpace));
            } else {
                //No Space
                checkUserAnPass();

            }

        }

    }

    private void checkUserAnPass() {

        try {
            GetData getData = new GetData(this);
            MyConstant myConstant = new MyConstant();
            getData.execute(myConstant.getUrlGetUser());
            String strJSON = getData.get();
            Log.d("17MayV2", "JSON ==> " + strJSON);
            //showMessage(strJSON);

            JSONArray jsonArray = new JSONArray(strJSON);
            boolean b = true;// User False
            String strName = null, strPassword = null;
            MyAlert myAlert = new MyAlert(this);


            for (int i = 0;i<jsonArray.length();i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                if (userString.equals(jsonObject.getString("User"))) {
                    b = false;
                    strName = jsonObject.getString("Name");
                    strPassword = jsonObject.getString("Password");
                }
            }// For

            if (b) {
                //User False
                myAlert.myDialog(getResources().getString(R.string.title_UserFalse),
                        getResources().getString(R.string.message_UserFalse));
            } else if (passwordString.equals(strPassword)) {
                //Password True
                Toast.makeText(MainActivity.this, "Welcome " + strName, Toast.LENGTH_SHORT).show();
                //Intent to Service
                Intent intent = new Intent(MainActivity.this, ServiceActivity.class);
                intent.putExtra("Login", strName);
                startActivity(intent);
                finish();

            } else {
                //Password False
                myAlert.myDialog(getResources().getString(R.string.title_PasswordFalse),
                        getResources().getString(R.string.title_PasswordFalse));
            }



        } catch (Exception e) {
            Log.d("17MayV2", "e checkUser ==> " + e.toString());

        }

    }

    private void showMessage(String strJSON) {
        Toast.makeText(MainActivity.this, strJSON, Toast.LENGTH_SHORT).show();
    }
} //Main Class นี่คือ คลาสหลัก
