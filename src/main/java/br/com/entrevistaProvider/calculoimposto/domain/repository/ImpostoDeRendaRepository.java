package br.com.entrevistaProvider.calculoimposto.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.entrevistaProvider.calculoimposto.domain.model.ImpostoDeRenda;

@Repository
public interface ImpostoDeRendaRepository extends JpaRepository<ImpostoDeRenda, Long>{

}
