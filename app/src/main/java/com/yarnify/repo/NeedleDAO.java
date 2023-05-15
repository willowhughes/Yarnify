package com.yarnify.repo;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.yarnify.model.Needle;

import java.util.List;

@Dao
public interface NeedleDAO {

    @Query("SELECT * FROM Needle WHERE id = :id")
    LiveData<Needle> getNeedle(long id);

    @Query("SELECT * FROM Needle")
    LiveData<List<Needle>> getNeedles();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long addNeedle(Needle needle);

    @Update
    void updateNeedle(Needle needle);

    @Delete
    void deleteNeedle(Needle needle);

    @Query("DELETE FROM Needle WHERE id = :id")
    void deleteNeedle(long id);
}
