package edu.sfsu.bartender.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import static edu.sfsu.bartender.activity.detail.DetailActivity.EXTRA_ID;

import java.util.ArrayList;

import edu.sfsu.bartender.R;
import edu.sfsu.bartender.activity.detail.DetailActivity;
import edu.sfsu.bartender.model.CategoryModel;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    ArrayList<CategoryModel> categoryModel;
    Context context;
    /**
     * Constructor
     */
    public RecyclerViewAdapter(ArrayList<CategoryModel> categoryModel) {
        this.categoryModel = categoryModel;
        Log.v("LOG", "2.0 Constructor -> RecyclerViewAdapter()");
    }
    // ...because it is 'static', it must access the non-static members of its enclosing class through an object.
    @NonNull
    @Override
    //public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.v("LOG", "onCreateViewHolder()");
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        return new ViewHolder(v);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.v("LOG", "onBindViewHolder()");

        CategoryModel model = categoryModel.get(position);

        holder.drkId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context = view.getContext();

                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(EXTRA_ID, model.getIdDrink());

                context.startActivity(intent);
            }
        });


        holder.drkId.setText(String.format("%s",  model.getIdDrink()));
        holder.drkName.setText(String.format("%s",  model.getStrDrink()));
        //holder.drkThumb.setBackgroundResource(model.getStrDrinkThumb());
    }
    @Override
    public int getItemCount() {
        return categoryModel.size(); // the number of items in RecyclerView
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView drkId;
        public final TextView drkName;
        public final ImageView drkThumb;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            drkId = itemView.findViewById(R.id.strId);
            drkName = itemView.findViewById(R.id.strDrink);
            drkThumb= itemView.findViewById(R.id.strDrinkThumb);
        }
    }
}