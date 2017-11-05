package com.example.testlistview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.testlistview.adapter.AnimalListAdapter;
import com.example.testlistview.model.Animal;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    //private ArrayList<Animal> mData;

    private ArrayList<Animal> aList = AnimalData.animalList;
    private AnimalListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.list_view);

        if (savedInstanceState == null) {
            aList.add(new Animal("Cat", "แมว", R.drawable.cat, getString(R.string.details_cat)));
            aList.add(new Animal("Dog", "หมา", R.drawable.dog, getString(R.string.details_dog)));
            aList.add(new Animal("Dolphin", "โลมา", R.drawable.dolphin, getString(R.string.details_dolphin)));
            aList.add(new Animal("Koala", "โคอาลา", R.drawable.koala, getString(R.string.details_koala)));
            aList.add(new Animal("Owl", "นกฮูก", R.drawable.owl, getString(R.string.details_owl)));
            aList.add(new Animal("Rabbit", "กระต่าย", R.drawable.rabbit, getString(R.string.details_rabbit)));
            aList.add(new Animal("Penguin", "เพนกวิน", R.drawable.penguin, getString(R.string.details_penguin)));
            aList.add(new Animal("Tiger", "เสือ", R.drawable.tiger, getString(R.string.details_tiger)));
            aList.add(new Animal("Pig", "หมู", R.drawable.pig, getString(R.string.details_pig)));
            aList.add(new Animal("Lion", "สิงโต", R.drawable.lion, getString(R.string.details_lion)));
        }

        mAdapter = new AnimalListAdapter(
                 this,
                R.layout.item,
                aList
        );

        mListView.setAdapter(mAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Animal animal = aList.get(i);
                Toast.makeText(MainActivity.this, animal.englishName, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, AnimalDetailsActivity.class);
                //intent.putExtra("englishName", animal.englishName);
                //intent.putExtra("picture", animal.picture);
                intent.putExtra("position", i);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        //if (itemId == R.id.action_add)

        switch (itemId) {
            case R.id.action_add:
                addAnimal();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void addAnimal() {
        Animal a = new Animal(
                "Snake",
                "งู",
                R.mipmap.ic_launcher,
                "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"
        );

        aList.add(0, a);

        mAdapter.notifyDataSetChanged();


    }
}
