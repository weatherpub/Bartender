package edu.sfsu.bartender.activity.detail;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import edu.sfsu.bartender.R;
import edu.sfsu.bartender.model.DrinkModel;
import edu.sfsu.bartender.picasso.RoundedTransformation;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DetailActivity extends AppCompatActivity {
    public ArrayList<DrinkModel> drinkModel = new ArrayList<>();
    public static final String EXTRA_ID = "id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);

        new AsyncDetail().execute("https://www.thecocktaildb.com/api/json/v1/1/lookup.php?i=" + getIntent().getStringExtra(EXTRA_ID));
        Log.v("LOG", "DetailActivity -> [ EXTRA_ID ] -> " + getIntent().getStringExtra(EXTRA_ID));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public class AsyncDetail extends AsyncTask<String, Integer, String> {
        Context context;
        ProgressBar progressBar;
        ArrayList<DrinkModel> drinkModel = new ArrayList<>();

        @Override
        protected String doInBackground(String... param) {
            Request request = new Request.Builder()
                    .url(param[0])
                    .build();

            OkHttpClient client = new OkHttpClient();

            try {
                Response response = client.newCall(request).execute();

                if(!response.isSuccessful())
                    return null;

                return response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            Log.v("LOG", "Result -> " + result);
            Log.v("LOG", "Parsing JSON into Java Objects");

            try {
                JSONObject root = new JSONObject(result);
                JSONArray list = root.getJSONArray("drinks");

                Log.v("LOG", "list.length()-> " + list.length());

                for(int i =  0; i < list.length(); i++) {
                    drinkModel.add(new DrinkModel(
                            list.getJSONObject(i).getString("idDrink"),
                            list.getJSONObject(i).getString("strDrink"),
                            list.getJSONObject(i).getString("strDrinkAlternate"),
                            list.getJSONObject(i).getString("strTags"),
                            list.getJSONObject(i).getString("strVideo"),
                            list.getJSONObject(i).getString("strCategory"),
                            list.getJSONObject(i).getString("strIBA"),
                            list.getJSONObject(i).getString("strAlcoholic"),
                            list.getJSONObject(i).getString("strGlass"),
                            list.getJSONObject(i).getString("strInstructions"),
                            list.getJSONObject(i).getString("strInstructionsES"),
                            list.getJSONObject(i).getString("strInstructionsDE"),
                            list.getJSONObject(i).getString("strInstructionsFR"),
                            list.getJSONObject(i).getString("strInstructionsIT"),
                            list.getJSONObject(i).getString("strInstructionsZH-HANS"),
                            list.getJSONObject(i).getString("strInstructionsZH-HANT"),
                            list.getJSONObject(i).getString("strDrinkThumb"),
                            list.getJSONObject(i).getString("strIngredient1"),
                            list.getJSONObject(i).getString("strIngredient2"),
                            list.getJSONObject(i).getString("strIngredient3"),
                            list.getJSONObject(i).getString("strIngredient4"),
                            list.getJSONObject(i).getString("strIngredient5"),
                            list.getJSONObject(i).getString("strIngredient6"),
                            list.getJSONObject(i).getString("strIngredient7"),
                            list.getJSONObject(i).getString("strIngredient8"),
                            list.getJSONObject(i).getString("strIngredient9"),
                            list.getJSONObject(i).getString("strIngredient10"),
                            list.getJSONObject(i).getString("strIngredient11"),
                            list.getJSONObject(i).getString("strIngredient12"),
                            list.getJSONObject(i).getString("strIngredient13"),
                            list.getJSONObject(i).getString("strIngredient14"),
                            list.getJSONObject(i).getString("strIngredient15"),
                            list.getJSONObject(i).getString("strMeasure1"),
                            list.getJSONObject(i).getString("strMeasure2"),
                            list.getJSONObject(i).getString("strMeasure3"),
                            list.getJSONObject(i).getString("strMeasure4"),
                            list.getJSONObject(i).getString("strMeasure5"),
                            list.getJSONObject(i).getString("strMeasure6"),
                            list.getJSONObject(i).getString("strMeasure7"),
                            list.getJSONObject(i).getString("strMeasure8"),
                            list.getJSONObject(i).getString("strMeasure9"),
                            list.getJSONObject(i).getString("strMeasure10"),
                            list.getJSONObject(i).getString("strMeasure11"),
                            list.getJSONObject(i).getString("strMeasure12"),
                            list.getJSONObject(i).getString("strMeasure13"),
                            list.getJSONObject(i).getString("strMeasure14"),
                            list.getJSONObject(i).getString("strMeasure15"),
                            list.getJSONObject(i).getString("strImageSource"),
                            list.getJSONObject(i).getString("strImageAttribution"),
                            list.getJSONObject(i).getString("strCreativeCommonsConfirmed"),
                            list.getJSONObject(i).getString("dateModified")));
                }
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }

            ImageView t01 = findViewById(R.id.drinkThumb);
            TextView t02 = findViewById(R.id.drink);
            TextView t03 = findViewById(R.id.drinkAlternate);
            TextView t04 = findViewById(R.id.tags);
            TextView t05 = findViewById(R.id.video);
            TextView t06 = findViewById(R.id.category);
            TextView t07 = findViewById(R.id.iba);
            TextView t08 = findViewById(R.id.alcoholic);
            TextView t09 = findViewById(R.id.glass);
            TextView t10 = findViewById(R.id.instructions);
            TextView t11 = findViewById(R.id.instructionsES);
            TextView t12 = findViewById(R.id.instructionsDE);
            TextView t13 = findViewById(R.id.instructionsFR);
            TextView t14 = findViewById(R.id.instructionsIT);
            TextView t15 = findViewById(R.id.instructionsZH_HANS);
            TextView t16 = findViewById(R.id.instructionsZH_HANT);
            TextView t18 = findViewById(R.id.ingredient1);
            TextView t19 = findViewById(R.id.ingredient2);
            TextView t20 = findViewById(R.id.ingredient3);
            TextView t21 = findViewById(R.id.ingredient4);
            TextView t22 = findViewById(R.id.ingredient5);
            TextView t23 = findViewById(R.id.ingredient6);
            TextView t24 = findViewById(R.id.ingredient7);
            TextView t25 = findViewById(R.id.ingredient8);
            TextView t26 = findViewById(R.id.ingredient9);
            TextView t27 = findViewById(R.id.ingredient10);
            TextView t28 = findViewById(R.id.ingredient11);
            TextView t29 = findViewById(R.id.ingredient12);
            TextView t30 = findViewById(R.id.ingredient13);
            TextView t31 = findViewById(R.id.ingredient14);
            TextView t32 = findViewById(R.id.ingredient15);
            TextView t33 = findViewById(R.id.measure1);
            TextView t34 = findViewById(R.id.measure2);
            TextView t35 = findViewById(R.id.measure3);
            TextView t36 = findViewById(R.id.measure4);
            TextView t37 = findViewById(R.id.measure5);
            TextView t38 = findViewById(R.id.measure6);
            TextView t39 = findViewById(R.id.measure7);
            TextView t40 = findViewById(R.id.measure8);
            TextView t41 = findViewById(R.id.measure9);
            TextView t42 = findViewById(R.id.measure10);
            TextView t43 = findViewById(R.id.measure11);
            TextView t44 = findViewById(R.id.measure12);
            TextView t45 = findViewById(R.id.measure13);
            TextView t46 = findViewById(R.id.measure14);
            TextView t47 = findViewById(R.id.measure15);
            TextView t48 = findViewById(R.id.imageSource);
            TextView t49 = findViewById(R.id.imageAttraction);
            TextView t50 = findViewById(R.id.creativeCommonsConfirmed);
            TextView t51 = findViewById(R.id.date);

            Picasso.get().load(Uri.parse(drinkModel.get(0).getStrDrinkThumb())).resize(500, 500).centerCrop().transform(new RoundedTransformation(50, 0)).into(t01);

            t02.setText(drinkModel.get(0).getStrDrink());
            t03.setText(drinkModel.get(0).getStrDrinkAlternate());
            t05.setText(drinkModel.get(0).getStrVideo());
            t06.setText(drinkModel.get(0).getStrCategory());
            t07.setText(drinkModel.get(0).getStrIBA());
            t08.setText(drinkModel.get(0).getStrAlcoholic());
            t09.setText(drinkModel.get(0).getStrGlass());
            t10.setText(drinkModel.get(0).getStrInstructions());
            t11.setText(drinkModel.get(0).getStrInstructionsES());
            t12.setText(drinkModel.get(0).getStrInstructionsDE());
            t13.setText(drinkModel.get(0).getStrInstructionsFR());
            t14.setText(drinkModel.get(0).getStrInstructionsIT());
            t15.setText(drinkModel.get(0).getStrInstructionsZH_HANS());
            t16.setText(drinkModel.get(0).getStrInstructionsZH_HANT());
            // moved thumb to t01
            t18.setText(drinkModel.get(0).getStrIngredient1());
            t19.setText(drinkModel.get(0).getStrIngredient2());
            t20.setText(drinkModel.get(0).getStrIngredient3());
            t21.setText(drinkModel.get(0).getStrIngredient4());
            t22.setText(drinkModel.get(0).getStrIngredient5());
            t23.setText(drinkModel.get(0).getStrIngredient6());
            t24.setText(drinkModel.get(0).getStrIngredient7());
            t25.setText(drinkModel.get(0).getStrIngredient8());
            t26.setText(drinkModel.get(0).getStrIngredient9());
            t27.setText(drinkModel.get(0).getStrIngredient10());
            t28.setText(drinkModel.get(0).getStrIngredient11());
            t29.setText(drinkModel.get(0).getStrIngredient12());
            t30.setText(drinkModel.get(0).getStrIngredient13());
            t31.setText(drinkModel.get(0).getStrIngredient14());
            t32.setText(drinkModel.get(0).getStrIngredient15());
            t33.setText(drinkModel.get(0).getStrMeasure1());
            t34.setText(drinkModel.get(0).getStrMeasure2());
            t35.setText(drinkModel.get(0).getStrMeasure3());
            t36.setText(drinkModel.get(0).getStrMeasure4());
            t37.setText(drinkModel.get(0).getStrMeasure5());
            t38.setText(drinkModel.get(0).getStrMeasure6());
            t39.setText(drinkModel.get(0).getStrMeasure7());
            t40.setText(drinkModel.get(0).getStrMeasure8());
            t41.setText(drinkModel.get(0).getStrMeasure9());
            t42.setText(drinkModel.get(0).getStrMeasure10());
            t43.setText(drinkModel.get(0).getStrMeasure11());
            t44.setText(drinkModel.get(0).getStrMeasure12());
            t45.setText(drinkModel.get(0).getStrMeasure13());
            t46.setText(drinkModel.get(0).getStrMeasure14());
            t47.setText(drinkModel.get(0).getStrMeasure15());
            t48.setText(drinkModel.get(0).getStrImageSource());
            t49.setText(drinkModel.get(0).getStrImageAttribution());
            t50.setText(drinkModel.get(0).getStrCreativeCommonsConfirmed());
            t51.setText(drinkModel.get(0).getDateModified());
        }
    }
}