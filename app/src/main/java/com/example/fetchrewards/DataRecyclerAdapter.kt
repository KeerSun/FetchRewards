package com.example.fetchrewards

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fetchrewards.network.dataModel
import kotlinx.android.synthetic.main.data_item.view.*

class DataRecyclerAdapter : RecyclerView.Adapter<DataRecyclerAdapter.ViewHolder>()
 {
     private var items:List<dataModel> = ArrayList()
//   update if data changes
     set(value) {
         field = value
         notifyDataSetChanged()
     }

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
         Log.d("create dataViewHolder", "True")
         return ViewHolder(
             LayoutInflater.from(parent.context).inflate(R.layout.data_item, parent, false)
         )
     }

     override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         holder.bind(items[position])
     }

     override fun getItemCount(): Int {
         return items.size
     }

     fun populate(dataList: List<dataModel>){
        items = dataList
         Log.d("items", items.toString())
     }

     class ViewHolder constructor(
         itemView: View
     ): RecyclerView.ViewHolder(itemView) {
         val id = itemView.id_text
         val listId = itemView.list_id_text
         val name = itemView.name_text
         fun bind(dataModel: dataModel){
             id.text = dataModel.id.toString()
             listId.text = dataModel.listId.toString()
             name.text = dataModel.name
         }
     }

 }