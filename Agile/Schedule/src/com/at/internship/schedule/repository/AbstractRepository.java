package com.at.internship.schedule.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractRepository <T, K>{
    private List<T> table;

    protected AbstractRepository(){
        table = new ArrayList<>();
    }

    public List<T> findAll(){
        return table.stream().map(this::clonesRow).collect(Collectors.toList());
    }

    protected abstract T clonesRow(T source);
}
