package com.rrdsolutions.projectwardex

import androidx.annotation.Keep
import com.google.gson.Gson
import com.rrdsolutions.projectwardex.repo.RetrofitRepo
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

class HTTPCallTest{

    @Test
    fun dogTest(){
        val dogurl = "https://dog.ceo/api/breeds/image/random/"
        val test = RetrofitRepo(dogurl).getDog()
        println(test)
    }

    @Test
    fun cetusTest(){
        val url = "https://api.warframestat.us/pc/cetusCycle/"
        val result = RetrofitRepo(url).getCetus()
        println(result)
    }

}