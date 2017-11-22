package com.pjw.dao

import com.pjw.idao.IBase
import com.pjw.model.SqlStmt
import com.pjw.model.User
import com.pjw.utils.ConnectionManager
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet

class UserDao:IBase<User> {
    override fun insert(e: User): Boolean {
        var result=false
        val con= ConnectionManager.getInstance().connection
        val pstmt=con.prepareStatement(SqlStmt.INSERT_USER)
        pstmt.setString(1,e.name)
        pstmt.setString(2,e.pwd)
        pstmt.setInt(3,e.type)
        pstmt.setString(4,e.head_path)
        pstmt.executeUpdate()
        result=true
        ConnectionManager.close(null,pstmt,con)
        return result
    }

    override fun delete(e: User): Boolean {
        val con=ConnectionManager.getInstance().connection
        val pstmt=con.prepareStatement(SqlStmt.DELETE_USER_NAME)
        pstmt.setString(1,e.name)
        pstmt.executeUpdate()
        ConnectionManager.close(null,pstmt,con)
        return true
    }

    override fun update(e: User): Boolean {
        val con=ConnectionManager.getInstance().connection
        val pstmt=con.prepareStatement(SqlStmt.UPDATE_USER)
        pstmt.setString(1,e.name)
        pstmt.setString(2,e.pwd)
        pstmt.setInt(3,e.type)
        pstmt.setString(4,e.head_path)
        pstmt.setString(5,e.name)
        pstmt.executeUpdate()
        ConnectionManager.close(null,pstmt,con)
        return true
    }

    override fun findDataAll(): MutableList<User>? {
        val list= ArrayList<User>()
        val con = ConnectionManager.getInstance().connection
        val pstmt=con.prepareStatement(SqlStmt.ALL_USER)
        val rs=pstmt.executeQuery()
        var user :User
        while (rs.next()){
            user= User(rs.getString("emp_no"),
                    rs.getString("emp_pass"),
                    rs.getInt("type"),
                    rs.getString("head_path"))
            list.add(user)
        }
        ConnectionManager.close(rs,pstmt,con)
        return list
    }

    override fun findDataByID(ID: Int): MutableList<User>? {
        return null
    }

    override fun findDataByName(Name: String): MutableList<User>{
        val list=ArrayList<User>()
        var con: Connection?=null
        var pstmt: PreparedStatement?= null
        var rs: ResultSet?= null
        try {
            con =ConnectionManager.getInstance().connection
            pstmt=con.prepareStatement(SqlStmt.FIND_USER_BY_NAME)
            pstmt.setString(1,Name)
            rs=pstmt.executeQuery()
            var i=0

            while (rs.next()){
                list.add(User(rs.getString("emp_no"),
                        rs.getString("emp_pass"),
                        rs.getInt("type"),
                        rs.getString("head_path")))
            }
        }catch (e:Exception){
            println(e.message)
        }finally {
            ConnectionManager.close(rs,pstmt,con)
        }
        return list
    }
}