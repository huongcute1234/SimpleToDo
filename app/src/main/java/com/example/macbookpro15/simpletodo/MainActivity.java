package com.example.macbookpro15.simpletodo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> items;
    ArrayAdapter<String>  itemsAdapter;
    ListView lvItems;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        items= new ArrayList<>();
        itemsAdapter =  new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        lvItems = (ListView) findViewById(R.id.lvItems);
        lvItems.setAdapter(itemsAdapter);
        //mock date
        items.add("First item" );
        items.add("Second item");
        setupListViewListener();
    }

    public void onAddItem (View v) {
        EditText etNewItem = (EditText) findViewById(R.id.etNewItem);
        String itemText = etNewItem.getText().toString();
        itemsAdapter.add(itemText);
        etNewItem.setText(" ");

        Toast.makeText(getApplicationContext(), "Item added to list" , Toast.LENGTH_SHORT).show();



    }
private void setupListViewListener(){
        Log.i("MainActivity","Setting up Listener on List view");


        lvItems.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("MainActivity","Item removed from list " + position);

                items.remove(position);
                itemsAdapter.notifyDataSetChanged();

                return false;
            }
        });
}
}
