package com.example.modulea.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.modulea.customview.RecyclerItemCustomView
import com.example.modulea.diffutil.UniversityDiffCallback
import com.example.modulea.model.UniversityDTO


class UniversityAdapter(private val onItemClick: (UniversityDTO) -> Unit) : ListAdapter<UniversityDTO, UniversityAdapter.MyViewHolder>(UniversityDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = RecyclerItemCustomView(parent.context)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class MyViewHolder(private val myView: RecyclerItemCustomView) : RecyclerView.ViewHolder(myView) {
        fun bind(item: UniversityDTO) {
            myView.setName(item.name)
            myView.setState(item.stateProvince)
            itemView.setOnClickListener {
                onItemClick.invoke(item)
            }
        }
    }
}
