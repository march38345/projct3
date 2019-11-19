package com.example.project3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.project3.adapter.ListAdapter;
import com.example.project3.db.Dao;
import com.example.project3.db.Game;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    List<Game> gameList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setdata();
        listView =  (ListView)findViewById(R.id.list_item);
        //Adapter
        ListAdapter adapter = new ListAdapter(MainActivity.this,gameList);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast toast = Toast.makeText(MainActivity.this,"Position = "+position,Toast.LENGTH_SHORT);
                toast.show();

                Intent intent = new Intent(MainActivity.this,Detail.class);
                intent.putExtra("position",position);
                intent.putExtra("image",gameList.get(position).getPicid());
                intent.putExtra("name",gameList.get(position).getName());
                intent.putExtra("price",gameList.get(position).getPrice());
                intent.putExtra("detail",gameList.get(position).getDetail());
                startActivity(intent);
            }
        });


    }
    Dao dao;
    SQLiteDatabase database;

    private void setdata() {
      //  dao = new Dao(MainActivity.this);
       // gameList =  dao.getall();

         int []id = {0,1,2,3};
        int picid[] ={R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.pic4};
        String name[] = {"overcooking","Mario","Overwatch","Payday"};
        String price[] = {"250$","300$","350$","400$"};
        String detail[] = {getString(R.string.detaildovercooking),getString(R.string.detailmario),getString(R.string.detailoverwatch),getString(R.string.detailpayday)};
    int datasize = picid.length;
        for(int i=0;i<datasize;i++){
            Game game = new Game(id[i],picid[i],name[i],price[i],detail[i]);
            gameList.add(game);

        }

    }
}
