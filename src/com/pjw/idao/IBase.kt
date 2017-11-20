package com.pjw.idao

interface IBase<E> {
    /**
     * 增
     */
    fun insert(e:E):Boolean
    /**
     * 删
     */
    fun delete(e:E):Boolean
    /**
     * 改
     */
    fun update(e: E):Boolean
    /**
     * 查询所有用户
     */
    fun findEmployeeAll():MutableList<E>?
    /**
     * 更具用户id查询
     */
    fun findEmployeeByID(ID:Int):MutableList<E>?
    /**
     * 根据用户名查询
     */
    fun findEmplyoeeByName(Name:String):MutableList<E>?
}