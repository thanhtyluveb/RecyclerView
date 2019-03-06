package com.example.recyclerview;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.recyclerview.model.ApiGitHub;
import com.example.recyclerview.remote.retrofit.ApiUtils;
import com.example.recyclerview.remote.retrofit.SOService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private SOService mService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mService = ApiUtils.getSOService();




        loadata();
    }

    private void loadata() {
        mService.EXAMPLE_CALL().enqueue(new Callback<List<ApiGitHub>>() {
            @Override
            public void onResponse(Call<List<ApiGitHub>> call, Response<List<ApiGitHub>> response) {
                ArrayList<ApiGitHub> apiGitHubs = new ArrayList<>();
                for(int i =0;i<response.body().size();i++)
                {
                    apiGitHubs.add(response.body().get(i));

                }
                RecyclerView recyclerView = findViewById(R.id.rv);
                Adapter adapter = new Adapter(MainActivity.this,apiGitHubs );
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            }

            @Override
            public void onFailure(Call<List<ApiGitHub>> call, Throwable t) {

            }
        });
    }


}
