package edu.sfsu.bartender.adapter;

import android.content.Context;
import android.net.ipsec.ike.exceptions.InvalidMajorVersionException;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import edu.sfsu.bartender.R;
import edu.sfsu.bartender.model.DrinkModel;

public class DetailRecyclerViewAdapter extends RecyclerView.Adapter<DetailRecyclerViewAdapter.ViewHolder> {
    ArrayList<DrinkModel> model;
    Context context;

    public DetailRecyclerViewAdapter(ArrayList<DrinkModel> model) {
        this.model = model;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.v("LOG", "onCreateViewHolder()");
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        return new DetailRecyclerViewAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailRecyclerViewAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final ImageView strDrinkThumb;
        public final TextView strDrink;
        public final TextView strDrinkAlternate;
        public final TextView strTags;
        public final TextView strVideo;
        public final TextView strCategory;
        public final TextView strIBA;
        public final TextView strAlcoholic;
        public final TextView strGlass;
        public final TextView strInstructions;
        public final TextView strInstructionsES;
        public final TextView strInstructionsDE;
        public final TextView strInstructionsFR;
        public final TextView strInstructionsIT;
        public final TextView strInstructionsZH_HANS;
        public final TextView strInstructionsZH_MANT;
        //public final TextView strDrinkThumb;
        public final TextView strIngredient1;
        public final TextView strIngredient2;
        public final TextView strIngredient3;
        public final TextView strIngredient4;
        public final TextView strIngredient5;
        public final TextView strIngredient6;
        public final TextView strIngredient7;
        public final TextView strIngredient8;
        public final TextView strIngredient9;
        public final TextView strIngredient10;
        public final TextView strIngredient11;
        public final TextView strIngredient12;
        public final TextView strIngredient13;
        public final TextView strIngredient14;
        public final TextView strIngredient15;
        public final TextView strMeasure1;
        public final TextView strMeasure2;
        public final TextView strMeasure3;
        public final TextView strMeasure4;
        public final TextView strMeasure5;
        public final TextView strMeasure6;
        public final TextView strMeasure7;
        public final TextView strMeasure8;
        public final TextView strMeasure9;
        public final TextView strMeasure10;
        public final TextView strMeasure11;
        public final TextView strMeasure12;
        public final TextView strMeasure13;
        public final TextView strMeasure14;
        public final TextView strMeasure15;
        public final TextView strImageSource;
        public final TextView strImageAttraction;
        public final TextView strCreativeCommonsConfirmed;
        public final TextView dateModified;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //idDrink = itemView.findViewById(R.id.id);
            strDrinkThumb = itemView.findViewById(R.id.drinkThumb);
            strDrink = itemView.findViewById(R.id.drink);
            strDrinkAlternate = itemView.findViewById(R.id.drinkAlternate);
            strTags = itemView.findViewById(R.id.tags);
            strVideo = itemView.findViewById(R.id.video);
            strCategory = itemView.findViewById(R.id.category);
            strIBA = itemView.findViewById(R.id.iba);
            strAlcoholic = itemView.findViewById(R.id.alcoholic);
            strGlass = itemView.findViewById(R.id.glass);
            strInstructions = itemView.findViewById(R.id.instructions);
            strInstructionsES = itemView.findViewById(R.id.instructionsES);
            strInstructionsDE  = itemView.findViewById(R.id.instructionsDE);
            strInstructionsFR = itemView.findViewById(R.id.instructionsFR);
            strInstructionsIT = itemView.findViewById(R.id.instructionsIT);
            strInstructionsZH_HANS = itemView.findViewById(R.id.instructionsZH_HANS);
            strInstructionsZH_MANT = itemView.findViewById(R.id.instructionsZH_HANT);
            strIngredient1 = itemView.findViewById(R.id.ingredient1);
            strIngredient2 = itemView.findViewById(R.id.ingredient2);
            strIngredient3 = itemView.findViewById(R.id.ingredient3);
            strIngredient4 = itemView.findViewById(R.id.ingredient4);
            strIngredient5 = itemView.findViewById(R.id.ingredient5);
            strIngredient6 = itemView.findViewById(R.id.ingredient6);
            strIngredient7 = itemView.findViewById(R.id.ingredient7);
            strIngredient8 = itemView.findViewById(R.id.ingredient8);
            strIngredient9 = itemView.findViewById(R.id.ingredient9);
            strIngredient10 = itemView.findViewById(R.id.ingredient10);
            strIngredient11 = itemView.findViewById(R.id.ingredient11);
            strIngredient12 = itemView.findViewById(R.id.ingredient12);
            strIngredient13 = itemView.findViewById(R.id.ingredient13);
            strIngredient14 = itemView.findViewById(R.id.ingredient14);
            strIngredient15 = itemView.findViewById(R.id.ingredient15);
            strMeasure1 = itemView.findViewById(R.id.measure1);
            strMeasure2 = itemView.findViewById(R.id.measure2);
            strMeasure3 = itemView.findViewById(R.id.measure3);
            strMeasure4 = itemView.findViewById(R.id.measure4);
            strMeasure5 = itemView.findViewById(R.id.measure5);
            strMeasure6 = itemView.findViewById(R.id.measure6);
            strMeasure7 = itemView.findViewById(R.id.measure7);
            strMeasure8 = itemView.findViewById(R.id.measure8);
            strMeasure9 = itemView.findViewById(R.id.measure9);
            strMeasure10 = itemView.findViewById(R.id.measure10);
            strMeasure11 = itemView.findViewById(R.id.measure11);
            strMeasure12 = itemView.findViewById(R.id.measure12);
            strMeasure13 = itemView.findViewById(R.id.measure13);
            strMeasure14 = itemView.findViewById(R.id.measure14);
            strMeasure15 = itemView.findViewById(R.id.measure15);
            strImageSource = itemView.findViewById(R.id.imageSource);
            strImageAttraction = itemView.findViewById(R.id.imageAttraction);
            strCreativeCommonsConfirmed = itemView.findViewById(R.id.creativeCommonsConfirmed);
            dateModified = itemView.findViewById(R.id.date);
        }
    }
}