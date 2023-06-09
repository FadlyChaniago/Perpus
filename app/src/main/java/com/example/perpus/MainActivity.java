package com.example.perpus;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.perpus.databinding.ActivityMainBinding;
import com.example.perpus.volleyCrud.LoginActivity;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sharedPreferences = getSharedPreferences("LoginFile" , MODE_PRIVATE);
        editor = sharedPreferences.edit();

        binding.logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("isLoggedIn", "false");
                editor.commit();
                startActivity(new Intent(MainActivity.this , LoginActivity.class));
                finishAffinity();
            }
        });

        /**
         String url = "https://jsonplaceholder.typicode.com/users";
         ArrayList<String> nameArraylist = new ArrayList<>();

         StringRequest request = new StringRequest(url, new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
        try {
        JSONArray jsonArray = new JSONArray(response);
        for (int i = 0; i < jsonArray.length(); i++) {
        JSONObject jsonObject = jsonArray.getJSONObject(i);
        String name = jsonObject.getString("name");
        nameArraylist.add(name);
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this
        , android.R.layout.simple_expandable_list_item_1, nameArraylist);
        binding.listview.setAdapter(arrayAdapter);

        } catch (JSONException e) {
        e.printStackTrace();
        }
        }
        }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
        Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
        }
        });
         RequestQueue requestQueue = Volley.newRequestQueue(this);
         requestQueue.add(request);*/
    }
}