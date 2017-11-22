package com.pjw.servlet

import com.pjw.idao.DaoFactory
import com.pjw.model.Employee
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

        val id=req.getParameter("emp_id").toInt()
        val emp_no=req.getParameter("emp_no")
        val emp_name=req.getParameter("emp_name")
        val tel_num=req.getParameter("emp_tel_num")
        val addr=req.getParameter("emp_addr")
        val email=req.getParameter("emp_email")
        /**
         * 判空
         * 先插入员工表，再插用户表，用户信息后修改
         */
        val employee=DaoFactory.createEmployeeDao()
        if (employee.insert(Employee(id,emp_no,emp_name,tel_num,addr,email))){
            val user = User(emp_no,"123456",0,"")
            val userDao = DaoFactory.createUserDao()
            resp.writer.print(Data2Gson.isRegister(userDao.insert(user)))

        }else{
            resp.writer.print(Data2Gson.isRegister(false))
        }
    }
}