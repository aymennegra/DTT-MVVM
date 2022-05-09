package com.example.dtt_mvvm

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.coroutines.Dispatchers.Main

class HouseDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_house_details)

        //get Data with intent
        var house_fragment_intent: Intent
        house_fragment_intent = getIntent()
        var image: String = house_fragment_intent.getStringExtra("image").toString()
        var price: Int = house_fragment_intent.getIntExtra("price", 0)
        var bedrooms: Int = house_fragment_intent.getIntExtra("bedrooms", 0)
        var bathrooms: Int = house_fragment_intent.getIntExtra("bathrooms", 0)
        var description: String = house_fragment_intent.getStringExtra("description").toString()
        var size: Int = house_fragment_intent.getIntExtra("size", 0)

        //Define labels
        val bedroomdetail: TextView = findViewById(R.id.beddetail)
        val bathroomdetail: TextView = findViewById(R.id.bathdetail)
        val sizedetail: TextView = findViewById(R.id.sizedetail)
        //val locdetail : TextView= findViewById(R.id.locdetail)
        val pricedetail: TextView = findViewById(R.id.pricedetail)
        val descriptiondetail: TextView = findViewById(R.id.description)
        val imagedetail: ImageView = findViewById(R.id.imagedetail)
        val backbtn: Button = findViewById(R.id.backbtn)
        val maps: ImageView = findViewById(R.id.maps)

        //Set Data
        bedroomdetail.text = bedrooms.toString()
        bathroomdetail.text = bathrooms.toString()
        descriptiondetail.text = description
        sizedetail.text = size.toString()
        pricedetail.text = price.toString()
        val url = "https://intern.docker-dev.d-tt.nl/" + image
        val imgurl="https://maps.googleapis.com/maps/api/staticmap?center="+52+","+5+"&zoom=12&size=400x400&key=AIzaSyABHPCoHcvMbWutAHIsjWbmD8ukg3zBZhE"
        Glide.with(applicationContext)
            .load(url)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(imagedetail)
        Glide.with(applicationContext)
            .load(imgurl)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(maps)


        backbtn.setOnClickListener {
            //val fragment = HousesFragment()
            //supportFragmentManager.beginTransaction().replace(R.id.content,fragment).commit()

        }
    }
}