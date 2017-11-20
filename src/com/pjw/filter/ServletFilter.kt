package com.pjw.filter

import javax.servlet.*
import javax.servlet.annotation.WebFilter
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebFilter(filterName = "LoginFilter",urlPatterns = arrayOf("/*"))
class ServletFilter : Filter {
    override fun destroy() {
        println("销毁过滤器")
    }

    override fun doFilter(request: ServletRequest, response: ServletResponse,
                          p2: FilterChain) {
        request.characterEncoding="utf-8"
        response.characterEncoding="utf-8"

        val req=request as HttpServletRequest
        val resp=response as HttpServletResponse
        val path=req.requestURL
        val userInfo=request.getSession().getAttribute("SEEESIONID")

        if (path.indexOf("/index.jsp")>-1){//无需过滤的页面，可以有多个
            p2.doFilter(request,response)
            return
        }else{
            if (userInfo==null || "".equals(userInfo)){
                println("----"+userInfo)
                resp.sendRedirect("index.jsp")
            }else
                p2.doFilter(request,response)
        }
    }

    override fun init(p0: FilterConfig?) {
        println("初始化过滤器")
    }

}