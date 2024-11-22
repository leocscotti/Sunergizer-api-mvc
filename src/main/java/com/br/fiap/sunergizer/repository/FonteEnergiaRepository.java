package com.br.fiap.sunergizer.repository;

import com.br.fiap.sunergizer.models.FonteEnergia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FonteEnergiaRepository extends JpaRepository<FonteEnergia, Long> {
}
