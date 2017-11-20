package com.pjw.servlet

import com.pjw.dao.UserDao
import com.pjw.idao.DaoFactory
import com.pjw.model.User
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

     fun loginMsg(name: String, pwd: String): String {
         val userDao=DaoFactory.createUserDao()
         val list= userDao.findDataByName(name)
         if (list!=null || list?.size != 0 ){
             list!!.forEach {
                 if (it.pwd.equals(pwd)){
                     return Data2Gson.islogin(it)
                 }
             }
         }
         return Data2Gson.islogin(null)
     }
}

