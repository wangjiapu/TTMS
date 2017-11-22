package com.pjw.servlet

import com.pjw.idao.DaoFactory
import com.pjw.model.User
import com.pjw.utils.Data2Gson
import com.pjw.utils.StringUtils
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet("/registerServlet")
class RegisterServlet : HttpServlet() {

    override fun doGet(req: HttpServletRequest, resp: HttpServletResponse) {
        val name = req.getParameter("user_name")
        val userDao = DaoFactory.createUserDao()
        val list = userDao.findDataByName(name)
        if (list != null || list?.size != 0) {
            resp.writer.print(Data2Gson.isRegister(false))
        } else {
            resp.writer.print(Data2Gson.isRegister(true))
        }
    }

    override fun doPost(req: HttpServletRequest, resp: HttpServletResponse) {
        val username = req.getParameter("name")
        val userpwd = req.getParameter("pwd")
        val usertype = req.getParameter("type")

        if (StringUtils.isEmpty(username) && StringUtils.isEmpty(userpwd)
                && StringUtils.isEmpty(usertype)) {
            val user = User(username,userpwd,usertype.toInt(),"")
            val userDao = DaoFactory.createUserDao()
            resp.writer.print(Data2Gson.isRegister(userDao.insert(user)))
        }else{
            resp.writer.print(Data2Gson.isRegister(true))
        }
    }
}