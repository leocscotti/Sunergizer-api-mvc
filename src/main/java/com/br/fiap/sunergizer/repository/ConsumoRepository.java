package com.br.fiap.sunergizer.repository;

import com.br.fiap.sunergizer.models.Consumo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumoRepository extends JpaRepository<Consumo, Long> {
}
