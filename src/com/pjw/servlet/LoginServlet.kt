package com.pjw.servlet

import com.pjw.idao.DaoFactory
import com.pjw.utils.Data2Gson

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.HttpSession

@WebServlet("/loginServlet")
class LoginServlet :HttpServlet() {
    private lateinit var session:HttpSession
    override fun doPost(req: HttpServletRequest, resp: HttpServletResponse) {
        val name=req.getParameter("user_name")
        val pwd=req.getParameter("user_password")
        println("loginServlet")
        session=req.getSession(false)
        session.maxInactiveInterval=10*60
       login2jsp(name,pwd,req,resp)
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
                    session.setAttribute("SEEESIONID",name)
                    when(it.type){
                        1 -> req.getRequestDispatcher("/jsp/admin.jsp").forward(req,resp)
                        0 -> req.getRequestDispatcher("/jsp/user.jsp").forward(req,resp)
                    }
                }
            }
        }
        req.getRequestDispatcher("/jsp/error.jsp").forward(req,resp)
    }

    fun loginMsg(name: String, pwd: String): String {
        val userDao=DaoFactory.createUserDao()
        val list= userDao.findDataByName(name)
        if (list!=null || list?.size != 0 ){
            list!!.forEach {
                if (it.pwd.equals(pwd)){
                    session.setAttribute("SEEESIONID",name)
                    when(it.type){
                    //1 ->
                    }
                    return Data2Gson.islogin(it)
                }
            }
        }
        return Data2Gson.islogin(null)
    }
}

