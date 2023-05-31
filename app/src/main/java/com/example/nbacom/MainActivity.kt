package com.example.nbacom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recycleVnba: RecyclerView
    private val list = ArrayList<Basket>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.apply {
            title = getString(R.string.Main_actionBar)
        }

        recycleVnba = findViewById(R.id.recyclerV_nba)
        recycleVnba.setHasFixedSize(true)

        list.addAll(getListNba())
        showRecycleList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_about, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.about_page ->{
                intent = Intent(this@MainActivity, aboutActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showRecycleList() {
        recycleVnba.layoutManager = LinearLayoutManager(this)
        val listBasketAdapter = ListBasketAdapter(list)
        recycleVnba.adapter = listBasketAdapter

    }

    private fun getListNba(): ArrayList<Basket> {
        val basketTitle = resources.getStringArray(R.array.data_title)
        val basketDesc = resources.getStringArray(R.array.desc_nba)
        val basketDev = resources.getStringArray(R.array.pelatih_tim)
        val basketPubs = resources.getStringArray(R.array.pemilik_tim)
        val basketRelease = resources.getStringArray(R.array.publishTim_year)
        val basketTag = resources.getStringArray(R.array.tags_tim)
        val stadionBasket = resources.getStringArray(R.array.stadion_tim)
        val basketLogo = resources.obtainTypedArray(R.array.nba_logo)
        val listBasket = ArrayList<Basket>()

        for (i in basketTitle.indices) {
            val game = Basket(basketTitle[i], basketDesc[i],basketDev[i],basketPubs[i],basketRelease[i],basketTag[i],stadionBasket[i],basketLogo.getResourceId(i,-1))
            listBasket.add(game)
        }
        return listBasket
    }
}