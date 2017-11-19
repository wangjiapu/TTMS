package com.pjw.dao

import com.pjw.idao.IEmployee
import com.pjw.model.Employee

class EmployeeDao:IEmployee {
    override fun insert(employoee: Employee): Boolean {
        return false
    }

    override fun delete(employeeID: Int): Boolean {
        return false
    }

    override fun update(employoee: Employee): Boolean {
        return false
    }

    override fun findEmployeeAll(): MutableList<Employee>? {
        return null
    }

    override fun findEmployeeByID(ID: Int): MutableList<Employee>? {
        return null
    }

    override fun findEmplyoeeByName(Name: String): MutableList<Employee>? {
        return null
    }
}