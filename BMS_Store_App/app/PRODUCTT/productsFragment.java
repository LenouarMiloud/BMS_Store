package com.example.junction.PRODUCTT;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.junction.R;

import java.util.ArrayList;

public class productsFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getActivity ().setTitle ("Régimes");

        return inflater.inflate( R.layout.products,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated ( view, savedInstanceState );


        ArrayList<Product> lstreg = new ArrayList<> (  );
        lstreg.add(new Product ("Rallonge","Category: AB 5min","3 wilaya",R.drawable.ralonge11));
        lstreg.add(new Product ("Lampe","Category: Led","6 Wilaya",R.drawable.ralonge12));
        lstreg.add(new Product ("Lampe","Categorie : Book","4 Wilaya",R.drawable.ralonge2));
        lstreg.add(new Product ("Disjoncteur","Categorie : BPM","4& Wilaya",R.drawable.ralonge3));
        lstreg.add(new Product ("Lampe","Categorie : Filament Gold","36 Wilaya",R.drawable.ralonge4));
        lstreg.add(new Product ("Interrupteur","Categorie : Continum","15 Wilaya",R.drawable.ralonge6));
        lstreg.add(new Product ("Rallonge","La douille H/F","49 Wilaya",R.drawable.ralonge5));
        lstreg.add(new Product ("Prise","Categorie : noir","48 Wilaya",R.drawable.ralonge7));
        lstreg.add(new Product ("Interrupteur","Categorie: Blanc","46 Wilaya",R.drawable.ralonge8));

        RecyclerView myrv = (RecyclerView)getView (). findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(getActivity (),lstreg);
        myrv.setLayoutManager(new GridLayoutManager (getActivity (),2));
        myrv.setAdapter(myAdapter);


    }



}
