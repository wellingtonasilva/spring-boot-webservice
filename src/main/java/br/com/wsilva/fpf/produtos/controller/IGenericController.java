package br.com.wsilva.fpf.produtos.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigInteger;
import java.util.List;

public interface IGenericController<T>
{
    T obterPorId(@PathVariable(value = "id") BigInteger id);
    //List<T> listar(@RequestParam(value = "param") String param);
    List<T> listar();
    T inserir(@RequestParam(value = "entity") T entity);
    boolean atualizar(@RequestParam(value = "entity") T entity);
    boolean excluir(@PathVariable(value = "id") BigInteger id);
}
