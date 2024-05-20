package com.example.modulea.utills

import android.view.View


fun View.showOrHide(show: Boolean) {
    visibility = if (show) View.VISIBLE else View.GONE
}
