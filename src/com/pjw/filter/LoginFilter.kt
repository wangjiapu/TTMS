package com.pjw.filter

import javax.servlet.*
import javax.servlet.annotation.WebFilter
import javax.servlet.annotation.WebInitParam
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
@WebFilter(urlPatterns = arrayOf("/jsp/admin.jsp",
        "/jsp/hall.jsp","/jsp/seat.jsp","/jsp/user.jsp"),
        initParams = arrayOf(WebInitParam(name ="encoding",value = "UTF-8")))
class LoginFilter : Filter {
    private lateinit var encoding:String
    override fun doFilter(request: ServletRequest, response: ServletResponse,
                          p2: FilterChain) {
        val re = request as HttpServletRequest
        val res = response as HttpServletResponse
        re.characterEncoding=encoding
        res.contentType = "text/html;charset=UTF-8"
        val session = re.session.getAttribute("SEEESIONID")

        if (session!=null) {
            p2.doFilter(re, res)
        } else {
            res.sendRedirect(re.contextPath+"/jsp/index.jsp")
            return
        }
    }

    override fun init(p0: FilterConfig) {
        println("初始化LoginFilter")
        encoding=p0.getInitParameter("encoding")
    }
    override fun destroy() {
        println("销毁LoginFilter")
    }
}