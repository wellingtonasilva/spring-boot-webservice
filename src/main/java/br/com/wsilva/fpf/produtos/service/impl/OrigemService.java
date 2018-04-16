package br.com.wsilva.fpf.produtos.service.impl;

import br.com.wsilva.fpf.produtos.entity.OrigemEntity;
import br.com.wsilva.fpf.produtos.service.IOrigemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.Optional;

@Service
public class OrigemService implements IOrigemService
{
    private OrigemService repository;

    @Autowired
    public OrigemService(OrigemService repository) {
        this.repository = repository;
    }

    @Override
    public OrigemEntity save(OrigemEntity entity) {
        return repository.save(entity);
    }

    @Override
    public Optional<OrigemEntity> findById(BigInteger id) {
        return repository.findById(id);
    }

    @Override
    public boolean existsById(BigInteger id) {
        return repository.existsById(id);
    }

    @Override
    public Iterable<OrigemEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(BigInteger id)
    {
        repository.deleteById(id);
    }

    @Override
    public void delete(OrigemEntity entity)
    {
        repository.delete(entity);
    }

    @Override
    public void deleteAll()
    {
        repository.deleteAll();
    }
}
