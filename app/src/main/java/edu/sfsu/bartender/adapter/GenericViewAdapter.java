package edu.sfsu.bartender.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

import edu.sfsu.bartender.R;
import edu.sfsu.bartender.activity.category.CategoryActivity;
import edu.sfsu.bartender.model.CategoryModel;
import edu.sfsu.bartender.model.DrinkModel;

public class GenericViewAdapter extends RecyclerView.Adapter<GenericViewAdapter.ViewHolder> {
    public ArrayList<CategoryModel> model; // when a variable is declared static, it means it belongs to the class itself rather than to any specific instance of the class.
    public GenericViewAdapter(ArrayList<CategoryModel> model) {
        this.model = model;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
    @NonNull
    @Override
    public GenericViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /**
         * Instantiaate the view holder.
         * 1. call the ViewHolder constructor with the CardView object. ViewHolder(cardView);
         * 2.
         */
        View view = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GenericViewAdapter.ViewHolder holder, int position) {
        CategoryModel model_position = model.get(position);
    }

    @Override
    public int getItemCount() {
        return 0;
    } // ViewHolder is used to specify which views should be used for each data item.
}


/**
 * 1. Create a new Class and extend RecyclerView.Adapter<ClassName.ViewHolder>.
 * 2. Define ViewHolder as an InnerClass.
 * 3. Define the kind of data for ViewHolder: ArrayList<Model>; .
 * 4. implement the getItemCount() method: return model.size(); ...the size of the model.
 */