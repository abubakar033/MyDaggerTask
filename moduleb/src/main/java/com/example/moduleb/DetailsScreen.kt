package com.example.moduleb

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.moduleb.callback.OnRefreshBtnCallback
import com.example.moduleb.databinding.FragmentScreenBBinding


class DetailsScreen : Fragment() {
    private var _binding: FragmentScreenBBinding? = null
    private val binding get() = _binding!!
    private lateinit var context: Context
    private lateinit var onRefreshClick: OnRefreshBtnCallback


    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.context = context
        this.onRefreshClick = context as OnRefreshBtnCallback
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentScreenBBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val arguments = arguments
        if (arguments != null) {
            setData(arguments) }

        binding.ivRefresh.setOnClickListener {
            onRefreshClick.onRefreshBtnClick()
        }

    }

    private fun setData(arguments: Bundle) {
        val name = arguments.getString("name")
        val state = arguments.getString("state")
        val code = arguments.getString("code")
        val page = arguments.getString("page")

        with(binding){
            tvUniName.text = name
            tvUniState.text = state
            tvCountryCode.text = code
            tvWebPage.text = page
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}