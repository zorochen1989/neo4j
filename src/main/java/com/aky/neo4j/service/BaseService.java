package com.aky.neo4j.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.io.Serializable;
import java.util.Optional;

/**
 * Service的基类，供其他service去继承
 *
 * @param <T>  实体
 * @param <ID> 实体的主键id
 * @param <R>  实体的Repository
 * @author chenhailin
 */
public interface BaseService<T, ID extends Serializable, R extends Neo4jRepository<T, ID>> {

    R getRepository();

    <S extends T> S save(S var1);

    <S extends T> S save(S var1, int var2);

    <S extends T> Iterable<S> save(Iterable<S> var1, int var2);

    void deleteById(ID var1);

    void delete(T var1);

    void deleteAll(Iterable<? extends T> var1);

    void deleteAll();

    boolean existsById(ID var1);

    long count();

    Optional<T> findById(ID var1);

    Optional<T> findById(ID var1, int var2);

    Iterable<T> findAll();

    Iterable<T> findAll(int var1);

    Iterable<T> findAll(Sort var1);

    Iterable<T> findAll(Sort var1, int var2);

    Iterable<T> findAllById(Iterable<ID> var1);

    Iterable<T> findAllById(Iterable<ID> var1, int var2);

    Iterable<T> findAllById(Iterable<ID> var1, Sort var2);

    Iterable<T> findAllById(Iterable<ID> var1, Sort var2, int var3);

    Page<T> findAll(Pageable var1);

    Page<T> findAll(Pageable var1, int var2);

}

