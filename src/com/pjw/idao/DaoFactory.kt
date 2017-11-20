package com.pjw.idao

import com.pjw.dao.EmployeeDao
import com.pjw.dao.UserDao
import com.pjw.model.Employee
import com.pjw.model.User

object DaoFactory {
    /**
     * 创建雇员操作类
     */
    fun createEmployeeDao():IBase<Employee>{
        return EmployeeDao()
    }

    fun <T : Any?> creatXXDao(c:Class<T:IBase<E>>):IBase<E> {

    }
    /**
     * 创建用户操作类
     */
    fun createUserDao():IBase<User>{
        return UserDao()
    }
}
