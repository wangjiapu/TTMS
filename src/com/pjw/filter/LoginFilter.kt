package com.pjw.filter

import javax.servlet.*
import javax.servlet.annotation.WebFilter
import javax.servlet.annotation.WebInitParam
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
@WebFilter(urlPatterns = arrayOf("/*"), initParams = arrayOf(WebInitParam(name ="encoding",value = "UTF-8")))
class LoginFilter : Filter {
    private lateinit var encoding:String
    /**
     * 将不需要过滤的url写入这个数组
     */
    private val dofilters= arrayOf("index.jsp","loginServlet",
            "registerServlet","register.jsp")

    override fun doFilter(request: ServletRequest, response: ServletResponse,
                          p2: FilterChain) {
        val req=request as HttpServletRequest
        val resp=response as HttpServletResponse
        if (!req.method.equals("POST")){
            req.getRequestDispatcher("jsp/index.jsp").forward(req,resp)
        }

        val session=request.getSession(false)
        val userInfo=session.getAttribute("SEEESIONID")
        request.characterEncoding=encoding
        val path=req.requestURL
        println(path)
        var flag=false
        run breaking@{
            dofilters.forEach continuing@{
                if (path.contains(it)|| path.endsWith(".js")){
                    flag=true
                    p2.doFilter(request,response)
                   return@breaking
                }
                println(it)
            }
        }
        if (!flag){
            if (userInfo==null || "".equals(userInfo)){
                resp.sendRedirect("jsp/index.jsp")
            }else
                p2.doFilter(request,response)
        }
    }

    override fun init(p0: FilterConfig) {
        println("初始化过滤器BFilter")
        encoding=p0.getInitParameter("encoding")
    }
    override fun destroy() {
        println("销毁过滤器BFilter")
    }
}