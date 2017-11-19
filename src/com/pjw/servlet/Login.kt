package com.pjw.servlet

import com.pjw.idao.DaoFactory
import com.pjw.utils.Data2Gson

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet("/loginservlet")
class Login:HttpServlet() {

    override fun doPost(req: HttpServletRequest, resp: HttpServletResponse) {
        req.characterEncoding="utf-8"
        resp.characterEncoding="utf-8"
        val out=resp.writer
        val name=req.getParameter("user_name")
        val pwd=req.getParameter("user_password")
        if (name!=null || pwd!=null){
            out.print(loginMsg(name,pwd))
        }
    }

     fun loginMsg(name: String, pwd: String): String{
         var result:String ?= null
         val emplyoeeDao=DaoFactory.createEmployeeDao()
         val list=emplyoeeDao.findEmplyoeeByName(name)
        // val list=emplyoeeDao.findEmployeeAll()
         if (list==null){
             result=Data2Gson.islogin(null)
             println(result+"==========")
         }else{
             list.forEach {
                 result=Data2Gson.islogin(it)
                 println(result)
             }
         }
         println(result+"-------------")
         //return result!!
         return name
     }
}

