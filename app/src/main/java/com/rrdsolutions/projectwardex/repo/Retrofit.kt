package com.rrdsolutions.projectwardex.repo

import androidx.annotation.Keep
import com.github.kittinunf.fuel.httpGet
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url


data class Dog(var message:String, var status: String)

data class Cetus(var id:String)

interface ApiClient {
    @GET(".")
    suspend fun getDog(): Response<Dog>

    @GET(".")
    suspend fun getCetus():Response<Cetus>

}

class RetrofitRepo(val url:String){
    companion object ApiAdapter2{
        lateinit var client:ApiClient
    }
    init{
        client = Retrofit.Builder()
            .baseUrl(url)
            .client(OkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiClient::class.java)
    }

    fun getDog(): String{
        var result = ""
        runBlocking{
            client.getDog().let{
                if (it.isSuccessful && it.body()!= null){
                    val data = it.body()!!
                    result = data.message
                }
            }
        }
        return result
    }

    fun getCetus(): String{
        var result = ""
        runBlocking{
            client.getCetus().let{
                if (it.isSuccessful && it.body()!= null){
                    val data = it.body()!!
                    result = data.id
                }
            }
        }
        return result
    }
}


