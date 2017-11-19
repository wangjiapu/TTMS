package com.pjw.idao

import com.pjw.model.Employee

interface IEmployee {
    /**
     * 增
     */
    fun insert(employoee:Employee):Boolean
    /**
     * 删
     */
    fun delete(employeeID:Int):Boolean
    /**
     * 改
     */
    fun update(employoee: Employee):Boolean
    /**
     * 查询所有用户
     */
    fun findEmployeeAll():MutableList<Employee>?
    /**
     * 更具用户id查询
     */
    fun findEmployeeByID(ID:Int):MutableList<Employee>?
    /**
     * 根据用户名查询
     */
    fun findEmplyoeeByName(Name:String):MutableList<Employee>?

}