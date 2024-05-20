package com.example.modulea.utills.customview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.LinearLayout
import com.example.modulea.databinding.CustomItemViewBinding

class RecyclerItemCustomView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val binding: CustomItemViewBinding = CustomItemViewBinding.inflate(
        LayoutInflater.from(context), this, true
    )

    fun setName(name: String?) {
        if (null!=name){
            binding.tvUniName.text = name
        }


    }
    fun setState(state: String?) {
        if (null!=state){
            binding.tvUniState.text = state
        }
    }
}
