package com.pjw.idao

import com.pjw.dao.EmployeeDao

object DaoFactory {
    fun createEmployeeDao():IEmployee{
        return EmployeeDao()
    }
}