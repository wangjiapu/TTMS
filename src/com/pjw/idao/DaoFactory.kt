package com.pjw.idao

import com.pjw.dao.EmployeeDao
import com.pjw.dao.UserDao
import com.pjw.model.Employee
import com.pjw.model.User
import kotlin.reflect.KClass

object DaoFactory {
    /**
     * 创建雇员操作类
     */
    fun createEmployeeDao():IBase<Employee>{
        return EmployeeDao()
    }

    fun <E : Any> creatXXDao(c:KClass<E>): IBase<E>? {
        var base:IBase<E> ?= null
        base= (Class.forName(c.simpleName).newInstance() as IBase<E>?)
        return base
    }
    /**
     * 创建用户操作类
     */
    fun createUserDao():IBase<User>{
        return UserDao()
    }
}

