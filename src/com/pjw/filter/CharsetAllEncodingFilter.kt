package com.pjw.filter

import javax.servlet.*
import javax.servlet.annotation.WebFilter
import javax.servlet.annotation.WebInitParam
import javax.servlet.http.HttpServletRequest

@WebFilter(urlPatterns = arrayOf("/*"),
        initParams = arrayOf(WebInitParam(name = "encoding", value = "UTF-8")))
class CharsetAllEncodingFilter:Filter {

    private lateinit var encoding:String
    override fun destroy() {}

    override fun doFilter(p0: ServletRequest, p1: ServletResponse, p2: FilterChain) {
        val httpreq=p0 as HttpServletRequest
        if (httpreq.method.equals("POST")){
            p0.characterEncoding=encoding
        }
        p2.doFilter(p0,p1)
    }

    override fun init(p0: FilterConfig) {
        encoding=p0.getInitParameter("encoding")
    }
}