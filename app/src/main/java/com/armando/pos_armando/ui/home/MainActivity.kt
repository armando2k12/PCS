package com.armando.pos_armando.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.armando.pos_armando.R
import com.armando.pos_armando.databinding.ActivityMainBinding
import com.armando.pos_armando.ui.auth.AuthActivity
import com.armando.pos_armando.ui.auth.PosAuth

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.btnSignout.setOnClickListener {
            PosAuth.signout(this){
                startActivity(Intent(this,AuthActivity::class.java))
                finish()
            }
        }
    }
}