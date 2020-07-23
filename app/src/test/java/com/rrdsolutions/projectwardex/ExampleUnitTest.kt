package com.rrdsolutions.projectwardex

import androidx.annotation.Keep
import com.google.gson.Gson
import com.rrdsolutions.projectwardex.repo.Repo
//import com.rrdsolutions.projectwardex.repo.RetrofitRepo
import com.rrdsolutions.projectwardex.ui.selection.SelectionType
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}

class RetrofitTest{

    @Test
    fun dog(){
        val dogurl = "https://dog.ceo/api/breeds/image/random/"
        val test = Repo.RetrofitModel(dogurl).getDog()
        println(test)
    }

    @Test
    fun cetus(){
        val url = "https://api.warframestat.us/pc/cetusCycle/"
        val result = Repo.RetrofitModel(url).getCetus()
        println(result)
    }

    @Test
    fun weapon(){
        val url = "https://api.warframestat.us/weapons/panthera/"
        val result = Repo.RetrofitModel(url).getWeapon()
        println(result)
    }

    @Test
    fun category(){
        val url = "https://api.warframestat.us/weapons/"
        val url2 = "https://api.warframestat.us/items/"
        val result = Repo.RetrofitModel(url, "Bow").getCategory()
        println(result)
    }
    @Test
    fun categoryfetch(){
        val url = "https://api.warframestat.us/weapons/"
        val url2 = "https://api.warframestat.us/items/"
        val result = Repo.RetrofitModel(url, "Primary").categoryFetchTest()
        println(result)

        //doesnt' work with Archwing. Might need to manually search.
    }





}