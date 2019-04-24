package com.faya.majd.demo5;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class EventActivity extends AppCompatActivity {

    ImageView eventImg;
    TextView eventName;
    TextView eventCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        eventImg = findViewById(R.id.EventImage);
        eventName = findViewById(R.id.textView);
        eventCategory = findViewById(R.id.textView2);

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            int pos=bundle.getInt("EventName");
            eventName.setText(MainActivity.NAMES[pos]);
            eventCategory.setText(MainActivity.CATEGORY[pos]);
            eventImg.setImageResource(MainActivity.IMAGES[pos]);
        }

        eventImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder().url("https://www.101apps.co.za/images/headers/101_logo_very_small.jpg").get().build();

                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.i("Tag","error"+e.getMessage());
                    }

                    @Override
                    public void onResponse(Call call, final Response response) throws IOException {

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {



                                ResponseBody in = response.body();
                                InputStream inputStream = in.byteStream();
                                Log.i("inputStream","inputstream value = "+inputStream);
                                // convert inputstram to bufferinoutstream
                                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                                Bitmap bitmap= BitmapFactory.decodeStream(bufferedInputStream);
                                Log.i("bitmap","bitmap value = "+bitmap);
                                eventImg.setImageBitmap(bitmap);

                            }
                        });

                    }
                });
            }
        });


    }


}
