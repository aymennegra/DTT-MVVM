package com.example.dtt_mvvm

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dtt_mvvm.adapters.HousesAdapter
import com.example.dtt_mvvm.models.HousesData
import com.example.dtt_mvvm.viewmodel.HousesViewModel
import com.google.android.gms.location.FusedLocationProviderClient


class HousesFragment : Fragment() {

private lateinit var recyclerAdapter : HousesAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_houses, container, false)
        initViewModel(view)
        initViewModel()
        return view
    }

    private fun initViewModel(view: View){
       val recyclerview=  view.findViewById<RecyclerView>(R.id.housesRecycler)
        recyclerview.layoutManager= LinearLayoutManager(activity)
        recyclerAdapter = HousesAdapter()
        recyclerview.adapter= recyclerAdapter


    }

    private fun initViewModel() {
        val viewModel:HousesViewModel = ViewModelProvider(this).get(HousesViewModel::class.java)
        viewModel.GetHousesListObserver().observe(viewLifecycleOwner, Observer {
            if(it != null) {
                recyclerAdapter.setUpdatedData(it)
                recyclerAdapter.notifyDataSetChanged()
                recyclerAdapter.setOnItemClickListener(object : HousesAdapter.onItemClickListener{
                    override fun onItemClick(position: Int) {
                        val house = it[position]
                        val intent = Intent (this@HousesFragment.context, HouseDetailsActivity::class.java)
                        intent.putExtra("price",house.price)
                        intent.putExtra("bedrooms",house.bedrooms)
                        intent.putExtra("bathrooms",house.bathrooms)
                        intent.putExtra("size",house.size)
                        intent.putExtra("description",house.description)
                        intent.putExtra("zip",house.zip)
                        intent.putExtra("city",house.city)
                        intent.putExtra("image",house.image)
                        startActivity(intent)
                    }
                })
            } else {
                Toast.makeText(context, "Error in getting list", Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.makeAPICall()
    }

    companion object {

        fun newInstance() = HousesFragment()
    }

}