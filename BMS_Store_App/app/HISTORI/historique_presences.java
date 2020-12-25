package com.example.junction.HISTORI;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.junction.PRODUCTT.Product;
import com.example.junction.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.HorizontalCalendarView;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;


public class historique_presences extends Fragment implements DatePickerDialog.OnDateSetListener {
private static HorizontalCalendar horizontalCalendar;

    private static RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
   private TextView vide;

    private RecyclerView.Adapter mAdapter;

    @SuppressLint("ResourceType")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        setMenuVisibility ( false );

        final View root = inflater.inflate ( R.layout.history_fragment, container, false );
        final TextView year =root.findViewById ( R.id.year );


        recyclerView = root.findViewById ( R.id.his_recycleview );
        vide = root.findViewById ( R.id.vide );
        vide.setVisibility ( root.GONE );
         Date Year = Calendar.getInstance().getTime ();
        DateFormat dateFormat = new SimpleDateFormat ( "yyyy" );

        String strDate = dateFormat.format ( Year );

        year.setText (strDate );

        afficher_presences (  Year,root);


       //  end after 1 month from now
        Calendar endDate = Calendar.getInstance();
        Calendar Date = Calendar.getInstance ();
        Date.add ( Calendar.DAY_OF_MONTH,-2 );
        endDate.add(Calendar.YEAR, 40);
        //  start before 1 month from now
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.YEAR, -10);
        horizontalCalendar = new HorizontalCalendar.Builder(root, R.id.calender)

                .datesNumberOnScreen(7)
                .range ( startDate,endDate )
                .defaultSelectedDate ( Date)

                .build();

        ImageView s=root.findViewById ( R.id.selectd );
   s .setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {


        DialogFragment datePicker = new DatePickerFragment ();
        datePicker.show(getActivity ().getSupportFragmentManager (), "date picker");



    }});


        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener () {
            @Override
            public void onDateSelected(Calendar date, int position) {
                //Date Year = horizontalCalendar.getDateAt ( position+1).getTime ();
                Date Year = horizontalCalendar.getSelectedDate ().getTime ();
                Calendar c= Calendar.getInstance ();


                DateFormat dateFormat = new SimpleDateFormat ( "yyyy" );
                String strDate = dateFormat.format ( Year );
                year.setText (strDate );
                Log.i("tttttttttttttt",strDate);
                Log.i("rrrrrrrrrrrrrrrr",Year.getDate ()+" "+position);

                                  afficher_presences ( Year,root );
            }

            @Override
            public void onCalendarScroll(HorizontalCalendarView calendarView,
                                         int dx, int dy) {
            }

            @Override
            public boolean onDateLongClicked(Calendar date, int position) {
                Date Year = horizontalCalendar.getDateAt ( position ).getTime ();
                DateFormat dateFormat = new SimpleDateFormat ( "yyyy" );
                String strDate = dateFormat.format ( Year );
                year.setText (strDate );
                Log.i("tttttttttttttt",strDate);

                return true;
            }

        });

        return root;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, dayOfMonth);

        DateFormat date4= new SimpleDateFormat("EEEE", Locale.getDefault());
        String localTime = date4.format(calendar.getTime());

        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.YEAR, 40);
    Log.i("rrrrrrrrrrrrrrrr",dayOfMonth+" "+  localTime  );
        Calendar startDate = Calendar.getInstance();

        startDate.add(Calendar.YEAR, -10);
        horizontalCalendar.selectDate ( calendar,false );





    }


    public void afficher_presences(Date date,   View view)
    {

        ArrayList<Product> la = new ArrayList<Product> ();
        layoutManager = new LinearLayoutManager ( getActivity () );

        recyclerView.setLayoutManager ( layoutManager );
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration ( recyclerView.getContext (),
                layoutManager.getOrientation () );
        recyclerView.addItemDecoration ( dividerItemDecoration );

        DateFormat dateForma = new SimpleDateFormat ( "yyyy-MM-dd" );
        String strDat= dateForma.format ( date.getTime () );

       Product c=new Product ();
        c.setCategory ( "08:00:03" );
        c.setDescription ( "has created a new resseler" );
        c.setTitle (" Radia djebrouni"  );
        la.add ( c );

        Product dc=new Product ();
        dc.setCategory ( "08 am" );
        dc.setDescription ( "has created a new resseler" );
        dc.setTitle (" Rania"  );
        la.add ( dc );
        Product cc=new Product ();
        cc.setCategory ( "10 am" );
        cc.setDescription ( "has created a new resseler" );
        cc.setTitle (" Miloud"  );
        la.add ( cc );
        Product ccc=new Product ();
        ccc.setCategory ( "9 pm" );
        ccc.setDescription ( "has created a new resseler" );
        ccc.setTitle (" Meriem meziane"  );
        la.add ( ccc );
        Product cs=new Product ();
        cs.setCategory ( "11 am" );
        cs.setDescription ( "has created a new resseler" );
        cs.setTitle (" "  );
        la.add ( cs );

        mAdapter = new GestRecyclerViewAdapter ( la , getActivity ().getSupportFragmentManager ());

        recyclerView.setAdapter ( mAdapter );
    }
}
