/*package com.example.projectimages;

import android.app.ListActivity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class ItemList extends ListActivity {

    private listAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_view_content_layout);

        this.adapter = new listAdapter(this, R.layout.activity_view_content_layout, );
        setListAdapter(this.adapter);
    }

    private class ItemsAdapter extends ArrayAdapter<String> {

        private String[] items;

        public ItemsAdapter(Context context, int textViewResourceId, String[] items) {
            super(context, textViewResourceId, items);
            this.items = items;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            if (view == null) {
                LayoutInflater vi = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = vi.inflate(R.layout.activity_view_content_layout_image, null);
            }

            String pathToFile = items[position];
            if (pathToFile != null) {
                ImageView imageview = (ImageView) view.findViewById(R.id.imageView1);
                if (imageview != null) {
                    Bitmap bitmap = BitmapFactory.decodeFile(pathToFile);
                    imageview.setImageBitmap(bitmap);
                }
            }

            return view;
        }
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        this.adapter.getItem(position).click(this.getApplicationContext());
    }
}

}*/
