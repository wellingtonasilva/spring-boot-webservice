package br.com.wsilva.fpf.produtos.service.impl;

import br.com.wsilva.fpf.produtos.entity.ProdutoEntity;
import br.com.wsilva.fpf.produtos.repository.ProdutoRepository;
import br.com.wsilva.fpf.produtos.service.IProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.Optional;

@Service
public class ProdutoService implements IProdutoService
{
    private ProdutoRepository repository;

    @Autowired
    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProdutoEntity save(ProdutoEntity entity) {
        return repository.save(entity);
    }

    @Override
    public Optional<ProdutoEntity> findById(BigInteger id) {
        return repository.findById(id);
    }

    @Override
    public boolean existsById(BigInteger id) {
        return repository.existsById(id);
    }

    @Override
    public Iterable<ProdutoEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(BigInteger id)
    {
        repository.deleteById(id);
    }

    @Override
    public void delete(ProdutoEntity entity)
    {
        repository.delete(entity);
    }

    @Override
    public void deleteAll()
    {
        repository.deleteAll();
    }
}
