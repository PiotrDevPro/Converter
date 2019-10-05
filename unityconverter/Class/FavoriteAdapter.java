package com.piotrdevelop.unityconverter.Class;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.piotrdevelop.unityconverter.DlinnaActivity;
import com.piotrdevelop.unityconverter.FavoriteNav;
import com.piotrdevelop.unityconverter.MainActivity;
import com.piotrdevelop.unityconverter.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>{

    private static int viewHolderCount;
    private int numberItems;
    private Context parent;

    public FavoriteAdapter(int numberOfItems,Context parent){
        numberItems = numberOfItems;
        viewHolderCount = 0;

        this.parent=parent;

    }
    @NonNull
    @Override
    public FavoriteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.row_item;

        LayoutInflater inflater = LayoutInflater.from(context);

      View view =  inflater.inflate(layoutIdForListItem, parent,false);
        FavoriteViewHolder viewHolder = new FavoriteViewHolder(view);
        viewHolder.listItemFavoriteView.setText("ViewHolder index:" + viewHolderCount);

        viewHolderCount++;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteViewHolder holder, int position) {

        holder.bind(position);
    }

    @Override
    public int getItemCount() {


        return numberItems;
    }

    class FavoriteViewHolder extends RecyclerView.ViewHolder{

        TextView listItemFavoriteView;
      //  TextView viewHolderIndex;

        public FavoriteViewHolder(@NonNull View itemView) {
            super(itemView);

            listItemFavoriteView = itemView.findViewById(R.id.tx_recycler_view);
           // viewHolderIndex = itemView.findViewById(R.id.holder_number);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int positionIndex = getAdapterPosition();
                    //   switch (positionIndex){
                    // case 0:
                    // Toast.makeText()
                    //Intent Dlinna = new Intent(FavoriteNav.this, DlinnaActivity.class);

                    Toast toast = Toast.makeText(parent, "" + positionIndex + "", Toast.LENGTH_SHORT);
                    toast.show();


                          //  break;

                   // Toast toast = Toast.makeText(parent, "" + positionIndex + "" , Toast.LENGTH_SHORT);
                  //  toast.show();
                }
            });
        }

        void bind(int listIndex){
            listItemFavoriteView.setText(String.valueOf(listIndex));
        }
    }
}
