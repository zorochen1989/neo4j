package com.aky.neo4j.service.impl;

import com.aky.neo4j.model.QueryPageable;
import com.aky.neo4j.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Optional;

/**
 * Service的基类实现层，供其他service实现层去继承
 *
 * @param <T>  实体
 * @param <ID> 实体的主键id
 * @param <R>  实体的Repository
 * @author chenhailin
 */
public class BaseServiceImpl<T, ID extends Serializable, R extends Neo4jRepository<T, ID>> implements BaseService<T, ID, R> {

    @Autowired
    private R repository;

    @Override
    public R getRepository() {
        return repository;
    }

    @Override
    public <S extends T> S save(S var1) {
        return repository.save(var1);
    }

    @Override
    public <S extends T> S save(S var1, int var2) {
        return repository.save(var1, var2);
    }

    @Override
    public <S extends T> Iterable<S> save(Iterable<S> var1, int var2) {
        return repository.save(var1, var2);
    }

    @Override
    public void deleteById(ID var1) {
        repository.deleteById(var1);
    }

    @Override
    public void delete(T var1) {
        repository.delete(var1);
    }

    @Override
    public void deleteAll(Iterable<? extends T> var1) {
        repository.deleteAll(var1);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public boolean existsById(ID var1) {
        return repository.existsById(var1);
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public Optional<T> findById(ID var1) {
        return repository.findById(var1);
    }

    @Override
    public Optional<T> findById(ID var1, int var2) {
        return repository.findById(var1, var2);
    }

    @Override
    public Iterable<T> findAll() {
        return repository.findAll();
    }

    @Override
    public Iterable<T> findAll(int var1) {
        return repository.findAll(var1);
    }

    @Override
    public Iterable<T> findAll(Sort var1) {
        return repository.findAll(var1);
    }

    @Override
    public Iterable<T> findAll(Sort var1, int var2) {
        return repository.findAll(var1, var2);
    }

    @Override
    public Iterable<T> findAllById(Iterable<ID> var1) {
        return repository.findAllById(var1);
    }

    @Override
    public Iterable<T> findAllById(Iterable<ID> var1, int var2) {
        return repository.findAllById(var1, var2);
    }

    @Override
    public Iterable<T> findAllById(Iterable<ID> var1, Sort var2) {
        return repository.findAllById(var1, var2);
    }

    @Override
    public Iterable<T> findAllById(Iterable<ID> var1, Sort var2, int var3) {
        return repository.findAllById(var1, var2, var3);
    }

    @Override
    public Page<T> findAll(Pageable var1) {
        return repository.findAll(var1);
    }

    @Override
    public Page<T> findAll(Pageable var1, int var2) {
        return repository.findAll(var1, var2);
    }

    @Override
    public Pageable createPageable(QueryPageable queryPageable, T t) {
        Sort.Direction direction = queryPageable.getDirection() == null || queryPageable.getDirection() == "" ? Sort.Direction.ASC : Sort.Direction.DESC;
        Field[] fields = t.getClass().getDeclaredFields();

        String[] properties = queryPageable.getProperties() == null ? new String[]{fields[0].getName()} : queryPageable.getProperties();
        int size = queryPageable.getSize() == 0 ? 15 : queryPageable.getSize();

        return PageRequest.of(queryPageable.getPage(), size, new Sort(direction, properties));

    }


}
