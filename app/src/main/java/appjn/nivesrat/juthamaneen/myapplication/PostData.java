package appjn.nivesrat.juthamaneen.myapplication;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

/**
 * Created by juthamanee.n on 17/05/2017.
 */

public class PostData extends AsyncTask<String, Void, String>{


    private Context context;

    public PostData(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... params) {
        //doInBackground เป็น Method ที่ทำงานเบื้อลหลัง ถึงแม้ไม่เปิดหน้าขึนมา

        try {

            OkHttpClient okHttpClient = new OkHttpClient();
            //OkHttpClient ได้มาจากการติดตั้ง Library
            RequestBody requestBody = new FormEncodingBuilder()
                    .add("isAdd", "true")
                    .add("Name", params[0])
                    .add("User", params[1])
                    .add("Password", params[2])
                    .build();

            MyConstant myConstant = new MyConstant();
            String urlPHP = myConstant.getUrlPostUser();

            Request.Builder builder = new Request.Builder();
            Request request = builder.url(urlPHP).post(requestBody).build();
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();

        } catch (Exception e) {
            //Exception คือ ค่า error ที่ยอมรับได้
            Log.d("17MayV1", "e doin ==> " + e.toString());
            return null;
        }


    }
}//Main Class
