package com.example.singlefragmentcode;


import com.example.singlefragmentcode.Models.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("products")
    Call<List<Product>> getDetails();

}
