package com.pjw.servlet

import com.pjw.idao.DaoFactory
import com.pjw.utils.Data2Gson

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet("/loginServlet")
class Login:HttpServlet() {

    override fun doPost(req: HttpServletRequest, resp: HttpServletResponse) {
        val name=req.getParameter("user_name")
        val pwd=req.getParameter("user_password")
        resp.writer.print(loginMsg(name,pwd))
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

