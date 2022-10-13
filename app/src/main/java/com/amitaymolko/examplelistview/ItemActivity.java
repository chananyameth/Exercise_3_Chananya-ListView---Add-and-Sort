package com.amitaymolko.examplelistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class ItemActivity extends AppCompatActivity {

    ImageView itemImageView;
    EditText itemEditText;
    Button save;
    MyItem curItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        final Intent intent = getIntent();
        curItem = (MyItem)intent.getSerializableExtra("item");

        itemImageView = (ImageView)findViewById(R.id.itemImageView);
        itemImageView.setImageResource(curItem.getIconId());
        itemEditText = (EditText)findViewById(R.id.itemEditText);
        itemEditText.setText(curItem.getText());

        save = (Button)findViewById(R.id.saveButton);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curItem.setText(itemEditText.getText().toString());
                intent.putExtra("newItem", curItem);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
