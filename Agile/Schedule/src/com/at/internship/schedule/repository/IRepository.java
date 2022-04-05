package com.at.internship.schedule.repository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface IRepository <T, K>{
    List <T> findAll();
    List<T> findAll(Predicate<? super T> predicate);
    T save(T t) throws IOException;
    void delete(K id) throws IOException;
    Optional<? extends  T> findOne(K id);
}
