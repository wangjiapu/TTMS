package com.pjw.dao

import com.pjw.idao.IBase
import com.pjw.model.Employee
import com.pjw.model.SqlStmt
import com.pjw.utils.ConnectionManager
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet

class EmployeeDao: IBase<Employee> {

    override fun insert(e: Employee): Boolean {
        var result=false
        val con=ConnectionManager.getInstance().connection
        val pstmt=con.prepareStatement(SqlStmt.INSERT_EMPL)
        pstmt.setString(1,e.emp_no)
        pstmt.setString(2,e.emp_name)
        pstmt.setString(3,e.emp_tel_num)
        pstmt.setString(4,e.emp_addr)
        pstmt.setString(5,e.emp_email)
        pstmt.executeUpdate()
        result=true
        ConnectionManager.close(null,pstmt,con)
        return result
    }

    override fun delete(e: Employee): Boolean {
        val con=ConnectionManager.getInstance().connection
        val pstmt=con.prepareStatement(SqlStmt.DELETE_EMPL_BYID)
        pstmt.setInt(1,e.emp_id)
        pstmt.executeUpdate()
        ConnectionManager.close(null,pstmt,con)
        return true
    }

    override fun update(e: Employee): Boolean {
        val con=ConnectionManager.getInstance().connection
        val pstmt=con.prepareStatement(SqlStmt.UPDATE_EMPL)
        pstmt.setString(1,e.emp_no)
        pstmt.setString(2,e.emp_name)
        pstmt.setString(3,e.emp_tel_num)
        pstmt.setString(4,e.emp_addr)
        pstmt.setString(5,e.emp_email)
        pstmt.setInt(6,e.emp_id)
        pstmt.executeUpdate()
        ConnectionManager.close(null,pstmt,con)
        return true
    }

    override fun findEmployeeAll(): MutableList<Employee>? {
        val list= ArrayList<Employee>()
        val con = ConnectionManager.getInstance().connection
        val pstmt=con.prepareStatement(SqlStmt.ALL_EMPLOYEE)
        val rs=pstmt.executeQuery()
        var empl :Employee
        while (rs.next()){
            empl= Employee(rs.getInt("emp_id"),
                    rs.getString("emp_no"),
                    rs.getString("emp_name"),
                    rs.getString("emp_tel_num"),
                    rs.getString("emp_addr"),
                    rs.getString("emp_email"))
            list.add(empl)
        }
        ConnectionManager.close(rs,pstmt,con)
        return list
    }
    /**
     * 根据用户id获取用户信息
     * @return Employee列表
     */
    override fun findEmployeeByID(ID: Int): MutableList<Employee>? {
        val list=ArrayList<Employee>()
        val con =ConnectionManager.getInstance().connection
        val pstmt=con.prepareStatement(SqlStmt.FIND_EMPL_BY_ID)
        pstmt.setString(1,ID.toString())
        val rs=pstmt.executeQuery()
        if (rs.next()){
            list.add(Employee(rs.getInt("emp_id"),
                    rs.getString("emp_no"),
                    rs.getString("emp_name"),
                    rs.getString("emp_tel_num"),
                    rs.getString("emp_addr"),
                    rs.getString("emp_email")))
        }
        ConnectionManager.close(rs,pstmt,con)
        return list
    }
    /**
     * 根据用户名获取用户信息
     * @return Employee列表
     */
    override fun findEmplyoeeByName(Name: String): MutableList<Employee>? {
        val list=ArrayList<Employee>()
        var con:Connection ?=null
        var pstmt:PreparedStatement ?= null
        var rs: ResultSet ?= null
        try {
            con =ConnectionManager.getInstance().connection
            pstmt=con.prepareStatement(SqlStmt.FIND_EMPL_BY_NAME)
            // pstmt.setString(1,"%${Name}%")
            pstmt.setString(1,Name)
            rs=pstmt.executeQuery()
            while (rs.next()){
                list.add(Employee(rs.getInt("emp_id"),
                        rs.getString("emp_no"),
                        rs.getString("emp_name"),
                        rs.getString("emp_tel_num"),
                        rs.getString("emp_addr"),
                        rs.getString("emp_email")))
                //println(list[0].emp_name+list[0].emp_tel_num)
            }
        }catch (e:Exception){
            println(e.message)
        }finally {
            ConnectionManager.close(rs,pstmt,con)
        }
        return list
    }
}