package com.example.modulea.ui.callback

import com.example.modulea.domain.model.UniversityDTO

interface OnListItemCallBack {
   fun onListItemClick(position: UniversityDTO)
}