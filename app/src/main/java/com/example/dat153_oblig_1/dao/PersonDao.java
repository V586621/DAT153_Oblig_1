package com.example.dat153_oblig_1.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.dat153_oblig_1.classes.Person;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface PersonDao {
    @Query("SELECT * FROM person")
    List<Person> getPersons();

    @Insert
    void addPerson(Person person);

    @Delete
    void removePerson(Person person);
}