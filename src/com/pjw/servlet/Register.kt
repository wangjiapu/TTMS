package com.pjw.servlet

import com.pjw.idao.DaoFactory
import com.pjw.model.User
import com.pjw.utils.Data2Gson
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet("/registerServlet")
class Register:HttpServlet() {

    override fun doGet(req: HttpServletRequest, resp: HttpServletResponse) {
        val name=req.getParameter("user_name")
        val userDao= DaoFactory.createUserDao()
        val list= userDao.findDataByName(name)
        if (list!=null || list?.size != 0 ){
            resp.writer.print(Data2Gson.isRegister(false))
        }else{
            resp.writer.print(Data2Gson.isRegister(true))
        }
    }
    override fun doPost(req: HttpServletRequest, resp: HttpServletResponse) {
        val user=User(req.getParameter("user_name"),
                req.getParameter("pwd"),
                req.getParameter("type").toInt(),
                "")
        val userDao= DaoFactory.createUserDao()
        resp.writer.print(Data2Gson.isRegister(userDao.insert(user)))
    }
}