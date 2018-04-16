package br.com.wsilva.fpf.produtos.service.impl;

import br.com.wsilva.fpf.produtos.entity.CategoriaEntity;
import br.com.wsilva.fpf.produtos.repository.CategoriaRepository;
import br.com.wsilva.fpf.produtos.service.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.Optional;

@Service
public class CategoriaService implements ICategoriaService
{
    private CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public CategoriaEntity save(CategoriaEntity entity) {
        return categoriaRepository.save(entity);
    }

    @Override
    public Optional<CategoriaEntity> findById(BigInteger id) {
        return categoriaRepository.findById(id);
    }

    @Override
    public boolean existsById(BigInteger id) {
        return categoriaRepository.existsById(id);
    }

    @Override
    public Iterable<CategoriaEntity> findAll() {
        return categoriaRepository.findAll();
    }

    @Override
    public void deleteById(BigInteger id)
    {
        categoriaRepository.deleteById(id);
    }

    @Override
    public void delete(CategoriaEntity entity)
    {
        categoriaRepository.delete(entity);
    }

    @Override
    public void deleteAll()
    {
        categoriaRepository.deleteAll();
    }
}
