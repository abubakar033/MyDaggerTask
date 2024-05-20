package com.example.modulea.callback

import com.example.modulea.model.UniversityDTO

interface OnItemClick {
   fun onItemClick(position: UniversityDTO)
}