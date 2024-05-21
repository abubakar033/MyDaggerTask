package com.example.mytask

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.modulea.ui.callback.OnListItemCallBack
import com.example.modulea.domain.model.UniversityDTO
import com.example.moduleb.callback.OnRefreshBtnCallback


class MainActivity : AppCompatActivity() , OnListItemCallBack, OnRefreshBtnCallback {
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        setupActionBarWithNavController(navController)

    }
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun onListItemClick(universityDTO: UniversityDTO) {
        val data = Bundle()
        data.putString("name", universityDTO.name)
        data.putString("state", universityDTO.stateProvince)
        data.putString("code", universityDTO.alphaTwoCode)
        data.putString("page", universityDTO.webPages[0])
        data.putString("domains", universityDTO.domains[0])
      navController.navigate(R.id.action_screenA_to_screenB, data)
    }

    override fun onRefreshBtnClick() {
        navController.popBackStack(R.id.screenA, false)
    }

}



