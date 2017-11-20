package com.pjw.dao

import com.pjw.idao.IBase
import com.pjw.model.User

class UserDao:IBase<User> {
    override fun insert(e: User): Boolean {
    }

    override fun delete(ID: Int): Boolean {
    }

    override fun update(e: User): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findEmployeeAll(): MutableList<User>? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findEmployeeByID(ID: Int): MutableList<User>? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findEmplyoeeByName(Name: String): MutableList<User>? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}