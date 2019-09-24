package com.example.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EditActivity extends AppCompatActivity {

    EditText editItem;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        editItem  = findViewById(R.id.updateText);
        save = findViewById(R.id.saveBtn);

        getSupportActionBar().setTitle("Edit An Item");

        editItem.setText(getIntent().getStringExtra(MainActivity.KEY_ITEM_TEXT));
        //when user done editing, button clicked
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create intent which contains results
                Intent intent = new Intent();
                //pass results
                intent.putExtra(MainActivity.KEY_ITEM_TEXT,editItem.getText().toString());
                intent.putExtra(MainActivity.KEY_ITEM_POSITION,getIntent().getExtras().getInt(MainActivity.KEY_ITEM_POSITION));
                //set result of intent
                setResult(RESULT_OK,intent);
                //finish activity, close
                finish();
            }
        });

    }
}
