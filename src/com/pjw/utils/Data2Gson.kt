package com.pjw.utils

import com.google.gson.Gson
import com.pjw.model.Employee
import com.pjw.model.User

object Data2Gson {
    val gson=Gson()
    /**
     * 返回登录状态
     */
    fun islogin(user:User?):String{
        if (user==null){
            return gson.toJson("Login_Fail")
        }
        return gson.toJson(user)
    }
}