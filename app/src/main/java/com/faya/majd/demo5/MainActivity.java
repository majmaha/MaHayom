package com.faya.majd.demo5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
    public static int [] IMAGES = { R.drawable.hourwithkid,R.drawable.fooddonations,R.drawable.lightrun,R.drawable.moonparty,R.drawable.samievent1, R.drawable.legoclass , R.drawable.karateclass , R.drawable.hapoelbash , R.drawable.hackathon};
    public static String [] NAMES = { "Good Hour with kid","Food Donations","Light Run","Party for Birashit","purim donations SCE" , "Lego Robotics", "Karate class", "Br7 vs Haifa" , "Community hackathon "};
    public static String [] CATEGORY = { "Donations/Free","Donations/Free","Free/Sport","Free/Famiily","Donations", "Kids classes", "Adult classes" , "Sport Event" , "Community"};
    public static String [] DATE = { "11/4/2019","11/4/2019","21/5/2019","11/4/2019","1-20/3/2019" , "25/3/2019", "25/3/2019" ,"25/3/2019" ,"25/3/2019"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.Toolbar_Mahayom);
        setSupportActionBar(toolbar);

        final ListView listView = findViewById(R.id.listView);

        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent= new Intent(MainActivity.this,EventActivity.class);
                intent.putExtra("EventName",position);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return IMAGES.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.customlayout,null);
            ImageView imageView = (ImageView)convertView.findViewById(R.id.imageView);
            TextView textView_name = (TextView) convertView.findViewById(R.id.textView_name);
            TextView textView_category = (TextView) convertView.findViewById(R.id.textView2_category);


            imageView.setImageResource(IMAGES[position]);
            textView_name.setText(NAMES[position]);
            textView_category.setText(CATEGORY[position]);

            return convertView;
        }
    }
}
