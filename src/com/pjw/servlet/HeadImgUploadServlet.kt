package com.pjw.servlet

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * 用户头像上传类
 */
@WebServlet("/Uploadservlet")
class HeadImgUploadServlet:HttpServlet() {
    override fun doPost(req: HttpServletRequest?, resp: HttpServletResponse?) {
        resp.writer.print("上传成功")
    }
}