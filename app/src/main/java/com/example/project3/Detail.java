package com.example.project3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        int idimage = getIntent().getIntExtra("image",0);
        String name = getIntent().getStringExtra("name");
        String price = getIntent().getStringExtra("price");
        String detail = getIntent().getStringExtra("detail");
        ImageView imageView = findViewById(R.id.image);
        TextView textname = findViewById(R.id.textname);
        TextView textprice = findViewById(R.id.textprice);
        TextView textinfo = findViewById(R.id.textInfo);
        imageView.setImageResource(idimage);
        textname.setText(name);
        textprice.setText(price+"$");
        textinfo.setText(detail);


    }
}
