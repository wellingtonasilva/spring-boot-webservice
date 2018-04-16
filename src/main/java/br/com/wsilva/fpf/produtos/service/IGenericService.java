package br.com.wsilva.fpf.produtos.service;

import java.math.BigInteger;
import java.util.Optional;

public interface IGenericService<T>
{
    T save(T entity);
    Optional<T> findById(BigInteger id);
    boolean existsById(BigInteger id);
    Iterable<T> findAll();
    void deleteById(BigInteger id);
    void delete(T entity);
    void deleteAll();
}
