package com.pjw.model

object SqlStmt {

    val ALL_EMPLOYEE="SELECT * FROM employee"
    val ALL_USER="SELECT * FROM user"

    /**
     * 插入语句
     * 1.插入一个员工
     */
    val INSERT_EMPL="insert into employee(emp_no, emp_name, emp_tel_num, emp_addr, emp_email) values(?,?,?,?,?)"
    val INSERT_USER="insert into user(emp_no, emp_pass, type, head_path) values(?,?,?,?)"
    /**
     * 查询语句
     * 1.通过用户名称查询
     */
    val FIND_EMPL_BY_NAME="select * from employee where emp_name like ?"
    val FIND_EMPL_BY_ID="select * from employee where emp_id=?"
    val FIND_USER_BY_NAME="select * from user where emp_no = ?"

    /**
     * 修改语句
     * 1.修改用户信息
     */
    val UPDATE_EMPL="update employee set emp_no=?,emp_name=?,emp_tel_num=?,emp_addr=?,emp_email=? where emp_id=?"

    val UPDATE_USER="update user set emp_no=?,emp_pass=?,type=?,head_path=? where emp_no=?"
    /**
     * 删除语句
     * 1.删除一个员工
     * 2.删除一个用户
     */
    val DELETE_EMPL_BYID="delete from employee where emp_id=?"
    val DELETE_USER_NAME="delete from user where emp_no=?"
}