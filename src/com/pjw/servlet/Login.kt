package com.pjw.servlet

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet("/loginservlet")
class Login:HttpServlet() {
    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
        super.doGet(req, resp)
    }

    override fun doPost(req: HttpServletRequest, resp: HttpServletResponse) {

        val name=req.getParameter("name")
        val pwd=req.getParameter("pwd")
        if (name.equals("pppp")) {
            resp.writer.print("${name}----${pwd}")
        }else{
            println("jfcdslkjnflkds")
        }
    }
}