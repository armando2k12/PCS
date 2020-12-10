package com.armando.pos_armando.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.armando.pos_armando.R
import com.armando.pos_armando.data.model.AuthUser
import com.armando.pos_armando.databinding.ActivityAuthBinding
import com.armando.pos_armando.ui.home.MainActivity

class AuthActivity : AppCompatActivity() {
    lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_auth)
    }

    fun onSuccess(user:AuthUser?){
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}