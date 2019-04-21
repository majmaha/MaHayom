package com.faya.majd.demo5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class EventActivity extends AppCompatActivity {

    ImageView eventImg;
    TextView eventName;
    TextView eventCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        eventImg = findViewById(R.id.imageView2);
        eventName = findViewById(R.id.textView);
        eventCategory = findViewById(R.id.textView2);

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            int pos=bundle.getInt("EventName");
            eventName.setText(MainActivity.NAMES[pos]);
            eventCategory.setText(MainActivity.CATEGORY[pos]);
            eventImg.setImageResource(MainActivity.IMAGES[pos]);
        }
    }
}
