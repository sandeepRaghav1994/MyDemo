package com.example.sandeepdemo.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.sandeepdemo.data.model.Data
import com.example.sandeepdemo.databinding.ItemLayoutBinding


class MainAdapter(private val dataList: ArrayList<Data>, val onClick:()->Unit) : RecyclerView.Adapter<MainAdapter.DataViewHolder>(),
    Filterable {
    var dataListFiltered: ArrayList<Data> = ArrayList()


   inner class DataViewHolder(private val itemBinding: ItemLayoutBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(data: Data) {
           itemBinding.tvCountry.text=data.country
           itemBinding.tvCities.text=data.cities.toString()
            /*data.cities.forEach {city->
                itemBinding.tvCities.text= "${itemBinding.tvCities.text} $city"
            }*/
            itemView.setOnClickListener {
                onClick()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val itemBinding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(itemBinding)
    }

    override fun getItemCount(): Int = dataListFiltered.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(dataListFiltered[position])
    }

    fun addData(list: List<Data>) {
        this.dataListFiltered=this.dataList
        this.dataListFiltered.apply {
            clear()
            addAll(list)
        }

    }

    override fun getFilter(): Filter {
        return object : Filter(){
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charString = constraint?.toString() ?: ""
                if (charString.isEmpty()) dataListFiltered = dataList else {
                    val filteredList = ArrayList<Data>()
                    dataList
                        .filter {
                            (it.country.toLowerCase().contains(constraint!!)) or
                                    (it.cities.toString().toLowerCase().contains(constraint))

                        }
                        .forEach { filteredList.add(it) }
                    dataListFiltered = filteredList

                }
                return FilterResults().apply { values = dataListFiltered }
            }

            override fun publishResults(p0: CharSequence?, results: FilterResults?) {
                dataListFiltered = if (results?.values == null)
                    ArrayList()
                else
                    results.values as ArrayList<Data>

                notifyDataSetChanged()
            }

        }
    }
}