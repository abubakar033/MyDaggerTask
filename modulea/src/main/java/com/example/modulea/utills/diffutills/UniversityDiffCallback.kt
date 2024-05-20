package com.example.modulea.utills.diffutills

import androidx.recyclerview.widget.DiffUtil
import com.example.modulea.domain.model.UniversityDTO

class UniversityDiffCallback : DiffUtil.ItemCallback<UniversityDTO>() {

    override fun areItemsTheSame(oldItem: UniversityDTO, newItem: UniversityDTO): Boolean {
        return oldItem.alphaTwoCode == newItem.alphaTwoCode
    }

    override fun areContentsTheSame(oldItem: UniversityDTO, newItem: UniversityDTO): Boolean {
        return oldItem == newItem
    }
}