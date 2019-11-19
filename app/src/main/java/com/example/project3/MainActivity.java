package com.example.project3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
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
    /*   dao = new Dao(MainActivity.this);
        ArrayList<Game> game = new ArrayList<Game>();

        Cursor cursor = database.rawQuery("SELECT * FROM GAME_LIST;",null);
        cursor.moveToFirst();
        Game games;
        while(!cursor.isAfterLast()){
            games = new Game(cursor.getInt(cursor.getColumnIndex("id")),cursor.getInt(cursor.getColumnIndex("picid")),cursor.getString(cursor.getColumnIndex("name"))
                    ,cursor.getString(cursor.getColumnIndex("price")),cursor.getString(cursor.getColumnIndex("detail")));
            game.add(games);
            cursor.moveToNext();


        }
        cursor.close();

        gameList =  game;*/

        int []id = {0,1,2,3,4,5,6,7,8,9};
        int picid[] ={R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.pic4,R.drawable.pic5,R.drawable.pic6,R.drawable.pic7,R.drawable.pic8,R.drawable.pic9,R.drawable.pic10};
        String name[] = {"overcooking","Mario","Overwatch","Payday","Pub G","Counter Striker","STAR WARS","XERA","Dead by Daylight","Secret Neighbor"};
        String price[] = {"250$","300$","350$","400$","200$","300$","100$","50$","125$","400$"};
        String detail[] = {getString(R.string.detaildovercooking),getString(R.string.detailmario),getString(R.string.detailoverwatch),getString(R.string.detailpayday),
                getString(R.string.detail5), getString(R.string.detail6), getString(R.string.detail7), getString(R.string.detail8), getString(R.string.detail9), getString(R.string.detail10),};
    int datasize = picid.length;
        for(int i=0;i<datasize;i++){
            Game game = new Game(id[i],picid[i],name[i],price[i],detail[i]);
            gameList.add(game);

        }

    }
}
