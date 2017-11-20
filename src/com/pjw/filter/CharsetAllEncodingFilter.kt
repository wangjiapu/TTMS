package com.pjw.filter

import javax.servlet.*
import javax.servlet.http.HttpServletRequest

class CharsetAllEncodingFilter :Filter {

    private lateinit var encoding:String
    override fun destroy() {
        println("销毁过滤器AFilter")
    }

    override fun doFilter(p0: ServletRequest, p1: ServletResponse, p2: FilterChain) {
        val httpreq=p0 as HttpServletRequest
        if (httpreq.method.equals("POST")){
            p0.characterEncoding=encoding
            println("charSetFilter")
        }
        p2.doFilter(p0,p1)
    }

    override fun init(p0: FilterConfig) {
        encoding=p0.getInitParameter("encoding")
        println("初始化过滤器AFilter")
    }
}