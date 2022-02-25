package com.example.task1;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    ListView listView;
    int imageId[] = {R.drawable.iphone,R.drawable.coca,R.drawable.nikon,R.drawable.laptop,R.drawable.shoe,R.drawable.system};
    String productname[] = {"iphone","coca","nikon","laptop","shoe","system"};
    String productprice[] = {"Rs. 30,000","Rs. 75","Rs. 59,999","Rs. 58,999","Rs. 999","Rs,99,999"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

      listView = findViewById(R.id.list_view);

      MyAdapter adapter = new MyAdapter(this,productname,productprice,imageId);
      listView.setAdapter(adapter);

    }

    class MyAdapter extends ArrayAdapter<String>{
        Context context;
        String productname[];
        String productprice[];
        int imageId[];

       MyAdapter(Context c, String productname[],String productprice[],int imageId[]){
           super(c,R.layout.list_item, R.id.name,productname);
           this.context = c;
           this.productname = productname;
           this.productprice = productprice;
           this.imageId = imageId;
       }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View list_item = layoutInflater.inflate(R.layout.list_item,parent,false);
            ImageView image = list_item.findViewById(R.id.iphone);
            TextView prdtname = list_item.findViewById(R.id.name);
            TextView prdtprice = list_item.findViewById(R.id.price);

            image.setImageResource(imageId[position]);
            prdtname.setText(productname[position]);
            prdtprice.setText(productprice[position]);


            return list_item;
        }
    }

}