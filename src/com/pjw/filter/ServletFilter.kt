package com.pjw.filter

import javax.servlet.*
import javax.servlet.annotation.WebFilter

@WebFilter(filterName = "LoginFilter",urlPatterns = arrayOf("/*"))
class ServletFilter : Filter {
    override fun destroy() {
        println("销毁过滤器")
    }

    override fun doFilter(request: ServletRequest, response: ServletResponse,
                          p2: FilterChain) {
        request.characterEncoding="utf-8"
        response.characterEncoding="utf-8"
        /*if(request.getParameter("user_name")!=null ||
                null!=request.getParameter("user_password")){
            p2.doFilter(request,response)
        }*/

       p2.doFilter(request,response)
    }

    override fun init(p0: FilterConfig?) {
        println("初始化过滤器")
    }

}