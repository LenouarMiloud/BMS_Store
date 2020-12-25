package com.example.junction.HISTORI;

import android.annotation.SuppressLint;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.junction.PRODUCTT.Product;
import com.example.junction.R;

import java.util.ArrayList;
import java.util.List;

public class GestRecyclerViewAdapter extends RecyclerView.Adapter<GestRecyclerViewAdapter.ExampleViewHolder> implements Filterable{

    private ArrayList<Product> mExampleList;
    private boolean adherents;//ou coach
        private  static FragmentManager fragment ;




    public static class ExampleViewHolder extends RecyclerView.ViewHolder
    {

        public Button open_close;

        public LinearLayout l;
        public TextView line1;
        public TextView heure;
        public TextView line2;

        private RecyclerView recyclerView;





        public ExampleViewHolder(final View itemView) {
            super ( itemView );

            l=itemView.findViewById ( R.id.linear );
            line1=itemView.findViewById ( R.id.idA );
            line2=itemView.findViewById ( R.id.poid );
            heure=itemView.findViewById ( R.id.heure );
            open_close=itemView.findViewById ( R.id.btn_arrow );
            l.setVisibility ( itemView.GONE );


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

        }
    }

    public GestRecyclerViewAdapter(ArrayList<Product> lp , FragmentManager f) {
        mExampleList = lp;

        fragment=f;

    }


    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from ( parent.getContext () ).inflate ( R.layout.example_item, parent, false );
        ExampleViewHolder evh = new ExampleViewHolder ( v );
        return evh;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(final ExampleViewHolder holder, int position) {

        holder.line2.setText ( mExampleList.get(position).getDescription () );
        holder.line1.setText ( mExampleList.get(position).getTitle () );
        holder.heure.setText ( mExampleList.get(position).getCategory () );

    holder.open_close.setOnClickListener ( new View.OnClickListener () {
        @SuppressLint("NewApi")
        @Override
        public void onClick(View v) {
            if (holder.l.getVisibility () == View.GONE) {
                TransitionManager.beginDelayedTransition ( holder.l, new AutoTransition () );
                holder.open_close.setBackgroundResource ( R.drawable.ic_keyboard_arrow_up_black_24dp );
                holder.l.setVisibility ( View.VISIBLE );
            } else {
                TransitionManager.beginDelayedTransition ( holder.l, new AutoTransition () );
                holder.open_close.setBackgroundResource ( R.drawable.ic_keyboard_arrow_down_black_24dp );
                holder.l.setVisibility ( View.GONE );
            }
        }
    } );




    }

    @Override
    public int getItemCount() {
      return mExampleList.size ();


    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }
    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Product> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(mExampleList);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (Product item : mExampleList) {
                    if (item.getTitle ().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mExampleList.clear();
            mExampleList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };


}

