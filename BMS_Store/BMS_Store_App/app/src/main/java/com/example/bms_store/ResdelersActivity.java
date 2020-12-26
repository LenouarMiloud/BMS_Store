package com.example.bms_store;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class ResdelersActivity extends AppCompatActivity {

    String [] resdelersFamilyNames = {"FamilyName1","FamilyName2","FamilyName3","FamilyName4","FamilyName5"};
    String [] resdelersFirstNames = {"FirstName1","FirstName2","FirstName3","FirstName4","FirstName5"};
    String [] resdelersAdress = {"Adress1","Adress2","Adress3","Adress4","Adress5"};
    String [] resdelersPhone = {"0697845123","0785263194","0775642319","0794123654","0778564221"};
    int [] images = {R.drawable.icon_traducteur,R.drawable.icon_notaire,R.drawable.icon_huissier,R.drawable.icon_expert,R.drawable.icon_avocat};
    int [] resdelersRating = {2,5,5,3,4};

    ListView ResdelerList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resdelers);

        ResdelerList = findViewById(R.id.Resdeler_listView);
        MyAdapter adapter = new MyAdapter(getApplicationContext(),resdelersFamilyNames,resdelersFirstNames,resdelersAdress,resdelersPhone,images,resdelersRating);
        ResdelerList.setAdapter(adapter);
        ResdelerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ResdelersActivity.this,ResdelerResultActivity.class);
                Bundle bundle = new Bundle();
            }
        });
    }
}
class MyAdapter extends ArrayAdapter{
    int[] imageArray;
    String[] FamilyNamesArray;
    String[] FirstNamesArray;
    String[] AdressArray;
    String[] PhoneArray;
    int[] RatingsArray;

    public MyAdapter(Context context,String[] familyName1,String[] firstName1,String[] adress1,String[] phone1,int[] image1,int[] rating1){
        super(context,R.layout.list_item_view,R.id.result_familyName,familyName1);
        this.imageArray = image1;
        this.FamilyNamesArray = familyName1;
        this.FirstNamesArray = firstName1;
        this.AdressArray = adress1;
        this.PhoneArray = phone1;
        this.RatingsArray = rating1;
    }

    @NonNull
    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        //inflating the layout
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.list_item_view,parent,false);

        //get the reference to the view object
        ImageView myImage = row.findViewById(R.id.result_image);
        TextView familyName = row.findViewById(R.id.result_familyName);
        TextView firstName = row.findViewById(R.id.result_firstName);
        TextView adress = row.findViewById(R.id.result_adress);
        TextView phone = row.findViewById(R.id.result_phone);
        RatingBar ratingBar = row.findViewById(R.id.result_rating);

        //Providing the element of an array by specifying its position
        myImage.setImageResource(imageArray[position]);
        familyName.setText(FamilyNamesArray[position]);
        firstName.setText(FirstNamesArray[position]);
        adress.setText(AdressArray[position]);
        phone.setText(PhoneArray[position]);
        ratingBar.setRating(RatingsArray[position]);

        return row;
    }
}














