package com.example.class_work_l8

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

fun main(){
    val retrofit = Retrofit.Builder().
            baseUrl("https://cat-fact.herokuapp.com/facts/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    val service = retrofit.create(MyAPI::class.java)
    val call = service.getFacts()
    val listOfFacts = call.execute().body()
    listOfFacts?.forEach { println(it) }
}

interface MyAPI{
    @GET("/facts/")
    fun getFacts(): Call<List<Fact>>
}


data class Fact (
    @SerializedName("status")
    var status: Status? = null,

    @SerializedName("type")
    var type: String? = null,

    @SerializedName("deleted")
    var deleted: Boolean? = null,

    @SerializedName("_id")
    var id: String? = null,

    @SerializedName("user")
    var user: String? = null,

    @SerializedName("text")
    var text: String? = null,

    @SerializedName("__v")
    var v: Int? = null,

    @SerializedName("source")
    var source: String? = null,

    @SerializedName("updatedAt")
    var updatedAt: String? = null,

    @SerializedName("createdAt")
    var createdAt: String? = null,

    @SerializedName("used")
    var used: Boolean? = null
)


data class Status (
    @SerializedName("verified")
    var verified: Boolean? = null,

    @SerializedName("sentCount")
    var sentCount: Int? = null,

    @SerializedName("feedback")
    var feedback: String? = null

)