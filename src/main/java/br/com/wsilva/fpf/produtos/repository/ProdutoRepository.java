package br.com.wsilva.fpf.produtos.repository;

import br.com.wsilva.fpf.produtos.entity.ProdutoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.math.BigInteger;

@Repository
public interface ProdutoRepository extends CrudRepository<ProdutoEntity, BigInteger> {
}
