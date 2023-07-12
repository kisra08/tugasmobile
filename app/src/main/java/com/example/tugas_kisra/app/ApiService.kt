package com.example.tugas_kisra.app

import com.example.tugas_kisra.model.ObatModel
import com.example.tugas_kisra.model.ResponModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @FormUrlEncoded
    @POST("tblobat/save")
    fun saveobat(
        @Body data: ObatModel,
    ): Call<ResponModel>

    @GET("obat")
    fun getObat(): Call<ResponModel>
}