package com.yarnify.repo;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.yarnify.model.Pattern;

import java.util.List;

@Dao
public interface PatternDAO {

    @Query("SELECT * FROM Pattern WHERE id = :id")
    LiveData<Pattern> getPattern(long id);


    @Query("SELECT * FROM Pattern")
    LiveData<List<Pattern>> getPatterns();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long addPattern(Pattern pattern);

    @Update
    void updatePattern(Pattern pattern);

    @Delete
    void deletePattern(Pattern pattern);

    @Query("DELETE FROM Pattern WHERE id = :id")
    void deletePattern(long id);
}
