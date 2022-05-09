package com.example.dtt_mvvm.adapters


import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dtt_mvvm.R
import com.example.dtt_mvvm.models.HousesData
import javax.xml.transform.ErrorListener

class HousesAdapter : RecyclerView.Adapter<HousesAdapter.MyViewHolder>(){

    private var housesList: List<HousesData>? = null

    private lateinit var mListener : onItemClickListener


    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }

    fun setUpdatedData(housesList: List<HousesData>?){

        this.housesList = housesList
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HousesAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.house_item, parent, false)

        return MyViewHolder(view,mListener)
    }

    override fun onBindViewHolder(holder: HousesAdapter.MyViewHolder, position: Int) {
        holder.bind(housesList?.get(position)!!)
    }

    override fun getItemCount(): Int {
        if(housesList == null)return 0
        else return housesList?.size!!
    }

    class MyViewHolder(view : View , listener: onItemClickListener): RecyclerView.ViewHolder(view){
        val bathrooms = view.findViewById<TextView?>(R.id.bathrooms)
        val bedrooms = view.findViewById<TextView?>(R.id.bedrooms)
        val price = view.findViewById<TextView?>(R.id.price)
        val city = view.findViewById<TextView?>(R.id.city)
        val zip = view.findViewById<TextView?>(R.id.zip)
        val size = view.findViewById<TextView?>(R.id.size)
        val houseimg = view.findViewById<android.widget.ImageView?>(R.id.imageView)

        fun bind(data: HousesData) {
            bathrooms.text = data.bathrooms.toString()
            bedrooms.text = data.bedrooms.toString()
            price.text = data.price.toString()
            city.text = data.city
            zip.text = data.zip
            size.text = data.size.toString()
            val url = "https://intern.docker-dev.d-tt.nl/"+data.image
            Glide.with(itemView)
                .load(url)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(houseimg)
        }
        init {
            view.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }



    }

}
