package com.pjw.servlet

import com.pjw.dao.UserDao
import com.pjw.idao.DaoFactory
import com.pjw.model.User
import com.pjw.utils.Data2Gson

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.HttpSession

@WebServlet("/loginServlet")
class Login:HttpServlet() {
    private lateinit var session:HttpSession
    override fun doPost(req: HttpServletRequest, resp: HttpServletResponse) {
        val name=req.getParameter("user_name")
        val pwd=req.getParameter("user_password")
        session=req.getSession(false)
        session.maxInactiveInterval=10*60
       //login2jsp(name,pwd,req,resp)
        resp.writer.print(loginMsg(name,pwd))
    }

     fun loginMsg(name: String, pwd: String): String {
         val userDao=DaoFactory.createUserDao()
         val list= userDao.findDataByName(name)
         if (list!=null || list?.size != 0 ){
             list!!.forEach {
                 if (it.pwd.equals(pwd)){
                     session.setAttribute("SEEESIONID",name)
                     return Data2Gson.islogin(it)
                 }
             }
         }
         return Data2Gson.islogin(null)
     }

    /**
     * 登录用jsp页面显示
     */
    fun login2jsp(name: String, pwd: String,req: HttpServletRequest, resp: HttpServletResponse){
        val userDao=DaoFactory.createUserDao()
        val list= userDao.findDataByName(name)
        if (list!=null || list?.size != 0 ){
            list!!.forEach {
                if (it.pwd.equals(pwd)){
                    req.getRequestDispatcher("/LoginOK.jsp").forward(req,resp)
                }
            }
        }
        req.getRequestDispatcher("/index.jsp").forward(req,resp)
    }
}

