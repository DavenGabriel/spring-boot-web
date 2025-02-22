package com.example.finalproject6.DesignPattern.TemplateMethodPattern;

import com.example.finalproject6.pojo.Item;

import java.util.List;

public abstract class AbstractCRUDService<T> {

    public abstract List<T> getAll();

    public abstract T findItemById(Integer Id);

    public abstract void addItem(T entity);

    public abstract void update(T entity);

    public abstract void delete(Integer id);
}
