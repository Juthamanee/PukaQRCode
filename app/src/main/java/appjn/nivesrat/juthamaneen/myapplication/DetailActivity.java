package appjn.nivesrat.juthamaneen.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    private ImageView backImageView, imageView;
    private TextView titleTextView, detailTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //Initial View
        initialView();


        //Show View
        showView();

        backImageView = (ImageView) findViewById(R.id.imvBack);
        imageView = (ImageView) findViewById(R.id.imvImage);
        titleTextView = (TextView) findViewById(R.id.txtTitle);
        detailTextView = (TextView) findViewById(R.id.txtDetail);


    }//Main Class

    private void showView() {

        String stringTitle = getIntent().getStringExtra("Name");
        String strDetail = getIntent().getStringExtra("Detail");
        String strIcon = getIntent().getStringExtra("Icon");

        titleTextView.setText(stringTitle);
        detailTextView.setText(strDetail);
        Picasso.with(DetailActivity.this).load(strIcon).into(imageView);
    }

    private void initialView() {
    }
}//Main Class
