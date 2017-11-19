package com.pjw.utils

import com.google.gson.Gson
import com.pjw.model.Employee

object Data2Gson {
    val gson=Gson()
    /**
     * 返回登录状态
     */
    fun islogin(empl:Employee?):String{
        if (empl==null){
            return gson.toJson("Login_Fail")
        }
        return gson.toJson(empl)
    }
}