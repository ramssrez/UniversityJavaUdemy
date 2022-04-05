package com.at.internship.schedule.interfaces;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface IRepository <T, V>{
    List <T> findAll();
    T save(T t) throws IOException;
    void delete(V v) throws IOException;
    Optional< ? extends T> findOne(V v);
}
