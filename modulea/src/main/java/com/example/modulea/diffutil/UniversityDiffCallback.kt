package com.example.modulea.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.example.modulea.model.UniversityDTO

class UniversityDiffCallback : DiffUtil.ItemCallback<UniversityDTO>() {

    override fun areItemsTheSame(oldItem: UniversityDTO, newItem: UniversityDTO): Boolean {
        return oldItem.alphaTwoCode == newItem.alphaTwoCode
    }

    override fun areContentsTheSame(oldItem: UniversityDTO, newItem: UniversityDTO): Boolean {
        return oldItem == newItem
    }
}