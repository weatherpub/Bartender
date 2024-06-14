package edu.sfsu.bartender.activity.category;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import edu.sfsu.bartender.R;
import edu.sfsu.bartender.adapter.RecyclerViewAdapter;
import edu.sfsu.bartender.model.CategoryModel;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CategoryActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_category);

        new AsyncCategory().execute("https://www.thecocktaildb.com/api/json/v1/1/filter.php?c=Cocktail");

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public class AsyncCategory extends AsyncTask<String, Integer, String> {
        Context context;
        ProgressBar progressBar;
        ArrayList<CategoryModel> categoryModel = new ArrayList<>();
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        /*
        protected void onPreExecute() {
            super.onPreExecute();
            Log.v("LOG", "onPreExecute() on the main thread");
        }
        */
        @Override
        protected String doInBackground(String... param) {
            Request request = new Request.Builder().url(param[0]).build();

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

        protected void onPostExecute(String result) { // onPostExecute - runs on the main thread.
            super.onPostExecute(result);

            try {
                JSONObject root = new JSONObject(result);
                JSONArray list = root.getJSONArray("drinks");

                for(int i =  0; i < list.length(); i++) {
                    categoryModel.add(new CategoryModel(
                            list.getJSONObject(i).getString("idDrink"),
                            list.getJSONObject(i).getString("strDrink"),
                            list.getJSONObject(i).getString("strDrinkThumb")));
                }
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }

            this.recyclerView.setLayoutManager(new LinearLayoutManager(context));
            this.recyclerView.setAdapter(new RecyclerViewAdapter(categoryModel));
        }
    }
}