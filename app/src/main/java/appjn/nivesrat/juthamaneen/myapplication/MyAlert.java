package appjn.nivesrat.juthamaneen.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by juthamanee.n on 16/05/2017.
 */

public class MyAlert {

    //Explicit การประกาศตัวแปร
    private Context context;

    public MyAlert(Context context) {
        this.context = context;
    }// Main Method

    public void myDialog(String strTitle, String strMessage) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(false);
        builder.setIcon(R.mipmap.ic_user);
        builder.setTitle(strTitle);
        builder.setMessage(strMessage);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }
}// Main Class
