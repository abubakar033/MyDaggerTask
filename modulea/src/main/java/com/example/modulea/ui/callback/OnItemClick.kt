package com.example.modulea.ui.callback

import com.example.modulea.domain.model.UniversityDTO

interface OnItemClick {
   fun onItemClick(position: UniversityDTO)
}