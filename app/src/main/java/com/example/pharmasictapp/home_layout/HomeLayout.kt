package com.example.pharmasictapp.home_layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.pharmasictapp.R
import com.example.pharmasictapp.home_layout.fragments.calendar.CalenderFragment
import com.example.pharmasictapp.home_layout.fragments.courses.CoursesFragment
import com.example.pharmasictapp.home_layout.fragments.drugindex.DrugIndexFragment
import com.example.pharmasictapp.home_layout.fragments.home.HomeFragment
import com.example.pharmasictapp.home_layout.fragments.products_catalogue.ProductsCatalogueFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeLayout : AppCompatActivity() {


    private  val homeFragment=HomeFragment()
    private  val calenderFragment=CalenderFragment()
    private  val coursesFragment=CoursesFragment()
    private  val drugIndexFragment=DrugIndexFragment()
    private  val productsCatalogueFragment=ProductsCatalogueFragment()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_layout)
        val toolBar:androidx.appcompat.widget.Toolbar= findViewById(R.id.toolBar)
        toolBar.title=""

        setSupportActionBar(toolBar)
        replaceFragment(homeFragment)
        findViewById<BottomNavigationView>(R.id.bottom_nav_bar).setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.homeIcon-> replaceFragment(homeFragment)
                R.id.calendarIcon-> replaceFragment(calenderFragment)
                R.id.courses-> replaceFragment(coursesFragment)
                R.id.drugIndex-> replaceFragment(drugIndexFragment)
                R.id.prouductCatalogue-> replaceFragment(productsCatalogueFragment)

            }
            true

        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.action_bar_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.profileIcon -> Toast.makeText(this,"Profile", Toast.LENGTH_SHORT).show()
            R.id.notificationIcon -> Toast.makeText(this,"notification", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

private fun replaceFragment(fragment:Fragment){
    if (fragment != null){
        val transaction=supportFragmentManager.beginTransaction()
        transaction.replace(R.id.home_fragment_container,fragment)
        transaction.commit()
    }
}





}