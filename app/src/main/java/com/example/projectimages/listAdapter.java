package com.example.projectimages;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
/*
public class listAdapter extends AppCompatActivity {

    DatabaseHandler myDb = new DatabaseHandler(this);

    String[] images = (String[]) myDb.getli().toArray();
    String[] images = {"hello"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_view_content_layout);

        ListView mListView = findViewById(R.id.listView);

        CustomAdapter customAdapter = new CustomAdapter();
        mListView.setAdapter(customAdapter);
    }

    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup viewGroup) {
            View view = getLayoutInflater().inflate(R.layout.activity_view_content_layout_image, null);
            ImageView mImageView = (ImageView) view.findViewById(R.id.imageView1);

            TextView mTextView = (TextView) view.findViewById(R.id.textView);

            mTextView.setText(images[position]);

            Log.w("lol", "Got before");
            /*Bitmap bitmap = BitmapFactory.decodeFile(images[position]);
            mImageView.setImageBitmap(bitmap);
            Log.w("lol", "Got After");

            return view;
        }
    }
}*/
