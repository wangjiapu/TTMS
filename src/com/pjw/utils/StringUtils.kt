package com.pjw.utils

object StringUtils {
    /**
     * 判空
     */
    fun isEmpty(s:String?):Boolean{
        if (s==null){
            return false
        }else if (s.equals("")){
            return false
        }
        return true
    }
}