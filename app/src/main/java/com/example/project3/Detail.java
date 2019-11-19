package com.example.project3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project3.db.Dao;
import com.example.project3.db.Game;

public class Detail extends AppCompatActivity {
  Dao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        dao = new Dao(Detail.this);
        int position = getIntent().getIntExtra("position",0)+1;

        ImageView imageView = findViewById(R.id.image);
        TextView textname = findViewById(R.id.textname);
        TextView textprice = findViewById(R.id.textprice);
        TextView textinfo = findViewById(R.id.textInfo);
        dao.open();
        Game game = dao.getAllToDoList(position);
        imageView.setImageResource(game.getPicid());
        textname.setText(game.getName());
        textinfo.setText(game.getDetail());
        textprice.setText(game.getPrice()+"$");






    }
}
