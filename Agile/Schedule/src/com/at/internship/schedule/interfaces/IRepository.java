package com.at.internship.schedule.interfaces;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface IRepository <T>{
    List <T> findAll();
    T save(T t) throws IOException;
    void delete(Integer id) throws IOException;
    Optional< ? extends T> findOne(Integer id);
}
