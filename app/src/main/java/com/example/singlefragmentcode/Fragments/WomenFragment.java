package com.example.singlefragmentcode.Fragments;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.singlefragmentcode.ApiInterface;
import com.example.singlefragmentcode.Models.Product;
import com.example.singlefragmentcode.R;
import com.example.singlefragmentcode.RetrofitInstance;
import com.example.singlefragmentcode.myAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WomenFragment extends Fragment {

    RecyclerView rcview1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_women, container, false);

        rcview1 = view.findViewById(R.id.rcview1);


        ApiInterface apiInterface = RetrofitInstance.getRetrofit().create(ApiInterface.class);
        apiInterface.getDetails().enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                if(response.body().size()>0){

                    List<Product> list2 = new ArrayList<>();
                    List<Product> list1 = response.body();

                    for(int i=0;i<list1.size();i++){
                        if(list1.get(i).getCategory().equals("women's clothing")){
                            list2.add(list1.get(i));
                        }
                    }

                    myAdapter adapter = new myAdapter(getContext(),list2);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                    rcview1.setLayoutManager(linearLayoutManager);
                    rcview1.setAdapter(adapter);

                }
                else
                {
                    Toast.makeText(getContext(), "List is empty", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Toast.makeText(getContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });












        return view;
    }
}