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
    fun findDataAll():MutableList<E>?
    /**
     * 更具用户id查询
     */
    fun findDataByID(ID:Int):MutableList<E>?
    /**
     * 根据用户名查询
     */
    fun findDataByName(Name:String):MutableList<E>?
}