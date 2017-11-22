package com.pjw.servlet

import java.io.File
import java.io.FileInputStream
import java.net.URLEncoder
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
@WebServlet("/GetHeadImge")
class DownFileServlet :HttpServlet() {
    override fun service(req: HttpServletRequest, resp: HttpServletResponse) {
        val url=req.getParameter("url")
        val filePath = servletContext.getRealPath("/WEB-INF/uploadFile")

        val file= File("$filePath${File.separator}$url")
        if (file.exists()){
            val fis = FileInputStream(file)
            val filename = URLEncoder.encode(file.getName(), "utf-8") //解决中文文件名下载后乱码的问题
            val b = ByteArray(fis.available())
            fis.read(b)
            resp.setCharacterEncoding("utf-8")
            resp.setHeader("Content-Disposition", "attachment; filename=" + filename + "")
            //获取响应报文输出流对象
            val out = resp.getOutputStream()
            //输出
            out.write(b)
            out.flush()
            out.close()
        }else{
            resp.writer.print("file does not exist")
        }
    }
}