package com.example.modulea.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.modulea.MyApp
import com.example.modulea.ui.adapter.UniversityAdapter
import com.example.modulea.ui.callback.OnListItemCallBack
import com.example.modulea.databinding.FragmentScreenABinding
import com.example.modulea.domain.model.UniversityDTO
import com.example.modulea.utills.sealedclass.ApiCallState
import com.example.modulea.utills.AppUtils
import com.example.modulea.utills.showOrHide
import javax.inject.Inject


class ListingScreen : Fragment() {

    @Inject
    lateinit var viewModel: ListingScreenViewModel
    private var _binding: FragmentScreenABinding? = null
    private lateinit var adapter: UniversityAdapter
    private lateinit var callback : OnListItemCallBack
    private lateinit var mContext: Context
    private val binding get() = _binding!!


    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.callback = context as OnListItemCallBack
        this.mContext = context
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        _binding = FragmentScreenABinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        MyApp.applicationComponent.inject(this)

        if (AppUtils.isInternetAvailable(mContext)){
            viewModel.fetchDataFromRemote("Pakistan")
        }else{
            viewModel.fetchDataFromLocal()
        }
        viewModel.liveData.observe(viewLifecycleOwner){
            handleData(it)
        }
        adapter = UniversityAdapter{ item->
            callback.onListItemClick(item)
        }
        binding.rvUniversity.adapter = adapter

 }

    private fun handleData(apiData: ApiCallState<List<UniversityDTO>>) {
        when(apiData){
            is ApiCallState.Error ->
            { handleLoadingBar(false)
                AppUtils.showAlert(mContext , apiData.message!!)
            }
            is  ApiCallState.Loading -> handleLoadingBar(true)
            is ApiCallState.Success -> handleData(apiData.data)
        }
    }

    private fun handleData(apiData: List<UniversityDTO>) {
        handleLoadingBar(false)
        if (apiData.isNotEmpty()){
            adapter.submitList(apiData)
        }

    }

    private fun handleLoadingBar(wantToShow:Boolean){
        binding.progress.showOrHide(wantToShow)
        binding.rvUniversity.showOrHide(wantToShow.not())
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}