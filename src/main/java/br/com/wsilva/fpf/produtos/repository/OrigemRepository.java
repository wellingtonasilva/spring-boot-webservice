package br.com.wsilva.fpf.produtos.repository;

import br.com.wsilva.fpf.produtos.entity.OrigemEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.math.BigInteger;

@Repository
public interface OrigemRepository extends CrudRepository<OrigemEntity, BigInteger> {
}
