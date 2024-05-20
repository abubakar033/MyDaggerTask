package com.example.mytask

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.modulea.ui.callback.OnItemClick
import com.example.modulea.domain.model.UniversityDTO
import com.example.moduleb.callback.OnRefreshClick


class MainActivity : AppCompatActivity() , OnItemClick, OnRefreshClick {
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

    override fun onItemClick(item: UniversityDTO) {
        val data = Bundle()
        data.putString("name", item.name)
        data.putString("state", item.stateProvince)
        data.putString("code", item.alphaTwoCode)
        data.putString("page", item.webPages[0])
        data.putString("domains", item.domains[0])
      navController.navigate(R.id.action_screenA_to_screenB, data)
    }

    override fun onClick() {
        navController.popBackStack(R.id.screenA, false)
    }

}



