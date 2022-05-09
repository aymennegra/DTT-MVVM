package com.example.dtt_mvvm

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

class MainActivity : AppCompatActivity() {

    lateinit var fusedLocationProviderClient: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
        fetchLocation()


        setupFragment()
        fragmentNavigation()
    }

    private fun fetchLocation (){
        val task = fusedLocationProviderClient.lastLocation
        if (ActivityCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_FINE_LOCATION)
        != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_COARSE_LOCATION)
            != PackageManager.PERMISSION_GRANTED
        ){
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),101)
            return
        }
        task.addOnSuccessListener {
            if (it!=null){
                Toast.makeText(applicationContext,"${it.latitude} ${it.longitude}",Toast.LENGTH_SHORT).show()
                Log.d("latitude",it.latitude.toString())
                Log.d("longitude",it.longitude.toString())
                println(it)
            }
        }
    }

    private fun setupFragment(){
        val fragment = HousesFragment.newInstance()
        val fragmentManager : FragmentManager = supportFragmentManager
        val fragmentTransaction : FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.container,fragment)
        fragmentTransaction.commit()

    }
    private fun fragmentNavigation(){
        val aboutBtn : Button = findViewById(R.id.about)
        val Homebtn : Button = findViewById(R.id.home)


        aboutBtn.setOnClickListener{
            val fragment = AboutFragment()
            supportFragmentManager.beginTransaction().replace(R.id.parentview,fragment).addToBackStack(null).commit()
        }

        Homebtn.setOnClickListener{
            val fragment = HousesFragment()
            supportFragmentManager.beginTransaction().replace(R.id.container,fragment).addToBackStack(null).commit()

        }
    }
}