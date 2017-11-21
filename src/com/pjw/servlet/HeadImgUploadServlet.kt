package com.pjw.servlet

import com.pjw.model.User
import java.io.File
import javax.servlet.annotation.MultipartConfig
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.Part
import com.sun.deploy.trace.Trace.flush
import com.sun.xml.internal.ws.streaming.XMLStreamWriterUtil.getOutputStream
import javax.servlet.ServletOutputStream
import java.io.FileInputStream
import java.net.URLEncoder


/**
 * 用户头像上传类
 */
@WebServlet("/Uploadservlet")
@MultipartConfig(maxFileSize = 1024*1024*2)
class HeadImgUploadServlet:HttpServlet() {
    companion object {
        private val UPLOAD_ROOT="uploadFile"
        private val confing=HeadImgUploadServlet::class.java.getAnnotation(MultipartConfig::class.java)
    }
    override fun doPost(req: HttpServletRequest, resp: HttpServletResponse) {
        req.characterEncoding="utf-8"
        val part=req.getPart("head_imge")
        val fileName=getFileName(part)
        //保存图片
        val filePath = servletContext.getRealPath("/WEB-INF/uploadFile")
        val dir = File(filePath)
        if(!dir.exists())
            dir.mkdir()
        println("$filePath${File.separator}$fileName")
        part.write("$filePath${File.separator}$fileName")
       resp.writer.print("上传成功")
    }

    /**
     * 获取文件名
     */
    fun getFileName(part:Part):String{
        val header=part.getHeader("content-disposition")
        println(header)
        val params = header.split(";".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        val temp = params[2].split("=".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        // 获取文件名，兼容各种浏览器的写法，去掉文件名前路径和双引号
        var fileName = ""
        if (temp[1].lastIndexOf("\\") < 0)
            fileName = temp[1].substring(1, temp[1].length - 1)
        else
            fileName = temp[1].substring(temp[1].lastIndexOf("\\") + 1, temp[1].length - 1)
        return fileName
    }
}