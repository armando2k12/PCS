package com.armando.pos_armando.ui.auth

import android.content.Context
import com.armando.pos_armando.data.model.ActionState
import com.armando.pos_armando.data.repository.AuthRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

object PosAuth {

    fun signout(context: Context,callback:((ActionState<Boolean>) -> Unit)? = null){
        val repo = AuthRepository(context)
        CoroutineScope(Dispatchers.IO).launch {
            val resp = repo.signout()
            withContext(Dispatchers.Main){
                callback?.invoke(resp)
            }
        }
    }

}