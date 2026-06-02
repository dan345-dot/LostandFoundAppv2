package com.example.lostandfoundappv2;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ItemDao {

    @Insert
    void insert(Items item);

    @Update
    void update(Items item);

    @Delete
    void delete(Items item);

    @Query("SELECT * FROM items ORDER BY timestamp DESC")
    List<Items> getAllItems();

    @Query("SELECT * FROM items WHERE category LIKE '%' || :category || '%'")
    List<Items> searchForCategory(String category);
}