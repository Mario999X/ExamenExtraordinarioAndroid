package com.example.examenandroidextraordinario.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.examenandroidextraordinario.model.DataEntity;

import java.util.List;

@Dao
public interface DataDao {

    @Insert
    long insert(DataEntity d);

    @Query("SELECT * FROM tabla_datos")
    List<DataEntity> getAll();

    @Query("SELECT * FROM tabla_datos where dia = :mDia")
    List<DataEntity> selectByDay(String mDia);
}
