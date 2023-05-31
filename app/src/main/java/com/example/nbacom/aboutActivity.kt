package com.example.nbacom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem

class aboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        var actionBar = getSupportActionBar()
        if (actionBar != null){

            actionBar.setHomeAsUpIndicator(R.drawable.backbutton);

            actionBar.setDisplayHomeAsUpEnabled(true);

        }

        supportActionBar?.apply {
            title = getString(R.string.about_actionBar)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                intent = Intent(this@aboutActivity, MainActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}