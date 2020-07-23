package com.rrdsolutions.projectwardex.repo

import androidx.annotation.Keep
import androidx.lifecycle.LiveData
import kotlinx.coroutines.*

import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url


data class Dog(var message:String, var status: String)

data class Cetus(var id:String)



data class DamageTypes(
    val blast: Int,
    val cold: Int,
    val corrosive: Int,
    val electric: Int,
    val gas: Int,
    val heat: Int,
    val impact: Int,
    val magnetic: Int,
    val puncture: Int,
    val radiation: Int,
    val slash: Int,
    val toxin: Int,
    val `true`: Int,
    val viral: Int,
    val void: Int
)
data class Patchlogs(
    val additions: String,
    val changes: String,
    val date: String,
    val fixes: String,
    val name: String,
    val url: String
)
data class Components(
    val name: String,
    val uniqueName: String
)
data class Weapon2(
    val accuracy: Int,
    val ammo: Int,
    val buildPrice: Int,
    val buildQuantity: Int,
    val buildTime: Int,
    val category: String,
    val components: List<Components>,
    val consumeOnBuild: Boolean,
    val criticalChance: Double,
    val criticalMultiplier: Double,
    val damage: Int,
    val damagePerSecond: Int,
    val damageTypes: DamageTypes,
    val description: String,
    val disposition: Int,
    val dmagePerShot: List<Int>,
    val fireRate: Double,
    val flight: Int,
    val imageName: String,
    val magazineSize: Int,
    val masteryReq: Int,
    val name: String,
    val noise: String,
    val omegaAttenuation: Double,
    val patchlogs: List<Patchlogs>,
    val polarities: List<String>,
    val procChance: Double,
    val projectile: String,
    val releaseDate: String,
    val reloadTime: Int,
    val secondsPerShot: Int,
    val sentinel: Boolean,
    val skipBuildTimePrice: Int,
    val slot: Int,
    val tags: List<String>,
    val totalDamage: Int,
    val tradable: Boolean,
    val trigger: String,
    val type: String,
    val uniqueName: String,
    val vaultDate: String,
    val vaulted: Boolean,
    val wikiaThumbnail: String,
    val wikiaUrl: String
)
data class Weapon(
    var wikiaThumbnail:String,
    var wikiaUrl:String
)

data class Category(
    var name:String,
    var type:String
)

data class CategoryFetch(
    // primary, meelee, etc
    var category:String,
    // bow, rifle, etc
    var type: String
)


interface ApiClient {
    @GET(".")
    suspend fun getDog(): Response<Dog>

    @GET(".")
    suspend fun getCetus():Response<Cetus>

    @GET(".")
    suspend fun getWeapon():Response<Weapon2>

    @GET(".")
    suspend fun getCategory():Response<List<Category>>

    @GET(".")
    suspend fun categoryFetch():Response<List<CategoryFetch>>
}

class RetrofitRepo(val url:String, val param: String = ""){
    companion object ApiAdapter{
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

    fun getWeapon(): String{
        var result = ""
        runBlocking{
            client.getWeapon().let{
                if (it.isSuccessful && it.body()!= null){
                    val data = it.body()!!
                    result = data.wikiaThumbnail
                }
            }
        }
        return result
    }

    fun getCategory():MutableList<String>{
        val result1 = mutableListOf<String>()
        runBlocking{
            client.getCategory().let{
                if (it.isSuccessful && it.body()!= null){
                    val data = it.body()!!

                    for (elements in data){
                        if(elements.type == param)
                        result1.add(elements.name)
                    }

                }
            }
        }
        return result1
    }

    fun categoryFetchTest():List<String>{
        val result1 = mutableListOf<String>()
        runBlocking{
            client.categoryFetch().let{
                if (it.isSuccessful && it.body()!= null){
                    val data = it.body()!!

                    for (elements in data){
                        if(elements.category == param)
                            result1.add(elements.type)
                    }

                }
            }
        }
        return result1.distinct()
    }

    fun categoryFetch(callback:(List<String>)->Unit){
        val result1 = mutableListOf<String>()
        GlobalScope.launch{
            client.categoryFetch().let{
                if (it.isSuccessful && it.body()!= null){
                    val data = it.body()!!
                    for (elements in data){
                        if(elements.category == param && elements.type!="")
                            result1.add(elements.type)
                    }
                }
            }
            withContext(Dispatchers.Main) {
                callback(result1.distinct())
            }
        }
    }

}


