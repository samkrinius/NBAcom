package com.example.nbacom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class detailActivity : AppCompatActivity() {

    private lateinit var textDetailName: TextView
    private lateinit var textPelatih: TextView
    private lateinit var textPemilik: TextView
    private lateinit var textpublishTim: TextView
    private lateinit var textTags: TextView
    private lateinit var textStadionTim: TextView
    private lateinit var textDetailDesc: TextView
    private lateinit var ImageDetailLogo: ImageView
    private lateinit var ShareButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        var actionBar = getSupportActionBar()
        if (actionBar != null){

            actionBar.setHomeAsUpIndicator(R.drawable.backbutton);

            actionBar.setDisplayHomeAsUpEnabled(true);

        }

        supportActionBar?.apply {
            title = getString(R.string.about_actionBar)
        }

        textDetailName = findViewById(R.id.textV_detail_title)
        textPelatih = findViewById(R.id.textV_pelatih)
        textPemilik = findViewById(R.id.textV_pemilik)
        textpublishTim = findViewById(R.id.textV_publishTim)
        textTags = findViewById(R.id.textV_tags)
        textStadionTim = findViewById(R.id.textV_stadionTim)
        textDetailDesc = findViewById(R.id.textV_detail_desc)
        ImageDetailLogo = findViewById(R.id.Image_detail_logo)
        ShareButton = findViewById(R.id.action_share)

        val dataNba = intent.getParcelableExtra<Basket>("key_game") as Basket

        textDetailName.text = dataNba.title
        textPelatih.text = dataNba.pelatih
        textPemilik.text = dataNba.pemilik
        textpublishTim.text = dataNba.releaseYear
        textTags.text = dataNba.tags
        textStadionTim.text = dataNba.stadion
        textDetailDesc.text = dataNba.description
        ImageDetailLogo.setImageResource(dataNba.gameLogo)

        ShareButton.setOnClickListener{
            val send:String = textDetailDesc.text.toString()

            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT,send)
            intent.type = "text/plain"

            startActivity(Intent.createChooser(intent,"bagikan lewat : "))
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                intent = Intent(this@detailActivity, MainActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}