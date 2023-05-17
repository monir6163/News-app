package com.monir.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    HashMap<String, String> hashMap = new HashMap<>();
    ArrayList< HashMap<String, String> > arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //call listview id
        listView = findViewById(R.id.listView);



        //call data function
        createDataTable();
        //call adapter
        MyAdapter myAdapter = new MyAdapter();
        listView.setAdapter(myAdapter);

    }

    //custom adapter
    private class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return arrayList.size();
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
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View myView = inflater.inflate(R.layout.item, parent, false);

            ImageView itemCover = myView.findViewById(R.id.itemCover);
            TextView itemCategory = myView.findViewById(R.id.itemCategory);
            TextView itemTitle = myView.findViewById(R.id.itemTitle);
            TextView itemDescription = myView.findViewById(R.id.itemDescription);
            LinearLayout itemLayout = myView.findViewById(R.id.itemLayout);


            HashMap<String, String> hashMap = arrayList.get(position);
            String cat_name = hashMap.get("cat_name");
            String image_url = hashMap.get("image_url");
            String title = hashMap.get("title");
            String description = hashMap.get("description");
            //set random color set cat bg
            Random rnd = new Random();
            int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            itemCategory.setBackgroundColor(color);

            itemCategory.setText(cat_name);
            Picasso.get().load(image_url).placeholder(R.drawable.monir).into(itemCover);
            itemTitle.setText(title);
            itemDescription.setText(description);

            //item details layout
            itemLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    NewsDetails.TITLE = title;
                    NewsDetails.DESCRIPTION = description;
                    Bitmap bitmap = ( (BitmapDrawable) itemCover.getDrawable() ).getBitmap();
                    NewsDetails.MY_BITMAP = bitmap;
                    startActivity(new Intent(MainActivity.this, NewsDetails.class));
                }
            });




            return myView;
        }
    }

    //create data table hashmap with user define function

    private void createDataTable (){
        hashMap = new HashMap<>();
        hashMap.put("cat_name", "Tech");
        hashMap.put("image_url", "https://i0.wp.com/techzoom.tv/wp-content/uploads/2023/02/%E0%A6%85%E0%A7%8D%E0%A6%AF%E0%A6%BE%E0%A6%A8%E0%A7%8D%E0%A6%A1%E0%A7%8D%E0%A6%B0%E0%A7%9F%E0%A7%87%E0%A6%A1-%E0%A7%A7%E0%A7%AA-%E0%A6%A4%E0%A7%87-%E0%A6%AA%E0%A7%8D%E0%A6%B0%E0%A6%BF-%E0%A6%87%E0%A6%A8%E0%A6%B8%E0%A7%8D%E0%A6%9F%E0%A6%B2%E0%A6%A1-%E0%A6%85%E0%A7%8D%E0%A6%AF%E0%A6%BE%E0%A6%AA-%E0%A6%A1%E0%A6%BF%E0%A6%B2%E0%A6%BF%E0%A6%9F%E0%A7%87%E0%A6%B0-%E0%A6%B8%E0%A7%81%E0%A6%AC%E0%A6%BF%E0%A6%A7%E0%A6%BE-%E0%A6%A5%E0%A6%BE%E0%A6%95%E0%A6%AC%E0%A7%87.jpg");
        hashMap.put("title", "অ্যান্ড্রয়েড ১৪-এ যেসব আকর্ষণীয় সুবিধা আসছে");
        hashMap.put("description", "যুক্তরাষ্ট্রের ক্যালিফোর্নিয়ার মাউন্টেন ভিউয়ে শোরলাইন অ্যাম্ফিথিয়েটারে ডেভেলপার বা প্রোগ্রামারদের নিয়ে ১০ মে অনুষ্ঠিত বার্ষিক ‘গুগল আইও ২০২৩’ সম্মেলনে অ্যান্ড্রয়েড ১৪ অপারেটিং সিস্টেম নিয়ে আসার ঘোষণা দিয়েছে গুগল। ধারণা করা হচ্ছে, চলতি বছরের আগস্টের শেষ সপ্তাহ বা সেপ্টেম্বরের প্রথম সপ্তাহে চালু হতে পারে অ্যান্ড্রয়েড ১৪। অ্যান্ড্রয়েড ১৪ অপারেটিং সিস্টেমে যেসব সুবিধা যুক্ত হতে যাচ্ছে, তা নিয়ে নিজেদের পর্যবেক্ষণ তুলে ধরেছে অনলাইন গণমাধ্যম দ্য ভার্জ। দেখে নেওয়া যাক যেসব আকর্ষণীয় সুবিধা যুক্ত হতে যাচ্ছে নতুন এই অপারেটিং সিস্টেমে।");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("cat_name", "Game");
        hashMap.put("image_url", "https://i0.wp.com/techzoom.tv/wp-content/uploads/2023/05/%E0%A6%86%E0%A6%87%E0%A6%AB%E0%A7%8B%E0%A6%A8-%E0%A7%A7%E0%A7%AB-%E0%A6%A4%E0%A7%88%E0%A6%B0%E0%A6%BF-%E0%A6%B9%E0%A6%AC%E0%A7%87-%E0%A6%AD%E0%A6%BE%E0%A6%B0%E0%A6%A4%E0%A7%87.jpg");
        hashMap.put("title", "ভারতে তৈরি হবে আইফোন ১৫");
        hashMap.put("description", "আইফোন ১৫ এবং ১৫ প্লাস তৈরি হবে ভারতেই। এই ফোন তৈরি করবে টাটা। চলতি বছরের সেপ্টেম্বরেই নতুন আইফোন উৎপাদন শুরু হবে। iphoneরিসার্চ ফার্ম ট্রেন্ড ফোর্সের প্রতিবেদন অনুযায়ী, টাটা ইতিমধ্যে নতুন দুই আইফোন তৈরি অর্ডার পেয়েছে।\n" +
                "\n" +
                "প্রতিবেদনে আরও উল্লেখ করা হয়েছে, ভারতে উইস্ট্রনের প্রোডাকশন লাইন অধিগ্রহণের কারণে টাটা এই অর্ডারটি নিতে সক্ষম হচ্ছে।\n" +
                "\n" +
                "২০২৩ সালে বিভিন্ন আইফোন মডেলের অ্যাসেম্বলি অর্ডারে টাটার অংশ ৫ শতাংশ হলেও অ্যাপল চীনের বাইরে তাদের ইউপাদন স্থানান্তর করছে, বিষয়টি তারই ইঙ্গিত দিয়েছে।\n" +
                "\n" +
                "উল্লেখ্য, অ্যাপল ইতিমধ্যে ভারতে আইফোন এসই, আইফোন ১২ এবং আইফোন ১৪ তৈরি করছে।");
        arrayList.add(hashMap);
    }
}