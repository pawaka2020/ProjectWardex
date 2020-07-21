package com.rrdsolutions.projectwardex

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.annotation.Keep
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.os.bundleOf
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.NavHostFragment.findNavController

import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)

        val host = supportFragmentManager.findFragmentById(R.id.host) as NavHostFragment
        navController = host.navController

        //Appbar will simply show "Project Wardex" if this is removed
        appBarConfiguration = AppBarConfiguration(setOf(R.id.nav_home, R.id.nav_selection), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)

        navView.setupWithNavController(navController)

        navView.setNavigationItemSelectedListener {
            if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
                drawer_layout.closeDrawer(GravityCompat.START)
            }
            val nav = Navigation.findNavController(this, R.id.host)
            val bundle:Bundle
            when (it.itemId){
                R.id.test1->{
                    bundle = bundleOf("Selectiontype" to "test1")
                    nav.navigate(R.id.nav_selection, bundle)
                    true
                }
                R.id.test2->{
                    bundle = bundleOf("Selectiontype" to "test2")
                    nav.navigate(R.id.nav_selection, bundle)
                    true
                }
                R.id.test3->{
                    bundle = bundleOf("Selectiontype" to "test3")
                    nav.navigate(R.id.nav_selection, bundle)
                    true
                }
                else->false
            }


        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onOptionsItemSelected(item: MenuItem):Boolean {
        return if (item.itemId == R.id.search ){
            Toast.makeText(this, "search clicked", Toast.LENGTH_SHORT).show()
            true
        }
        else super.onOptionsItemSelected(item)
    }
}