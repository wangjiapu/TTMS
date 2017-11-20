package com.pjw.filter

import javax.servlet.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class LoginFilter : Filter {
    private lateinit var encoding:String
    override fun destroy() {
        println("销毁过滤器BFilter")
    }

    override fun doFilter(request: ServletRequest, response: ServletResponse,
                          p2: FilterChain) {
        request.characterEncoding="utf-8"
        response.characterEncoding="utf-8"

        val req=request as HttpServletRequest
        val resp=response as HttpServletResponse
        val path=req.requestURL

        if (path.indexOf("/index.jsp") > -1){ //无需过滤的页面，可以有多个
            println("${path}---2222222222222")
            p2.doFilter(request,response)
        }else{
            val userInfo=request.getSession().getAttribute("SEEESIONID")
            if (userInfo==null || "".equals(userInfo)){
                println("----"+userInfo)
                req.getRequestDispatcher("/index.jsp").forward(req,resp)
               // resp.sendRedirect("index.jsp")
            }else
                p2.doFilter(request,response)
        }
    }

    override fun init(p0: FilterConfig?) {
        println("初始化过滤器BFilter")
    }

}