package com.kbank.dafund.core.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DafundDatabaseDao {

    @Insert
    suspend fun insertEmployee(secret: Employee)

    @Query("SELECT * FROM employee_table")
    fun getAllEmployees(): LiveData<List<Employee>>

    @Query("Delete FROM employee_table")
    suspend fun clearEmployees()
}
