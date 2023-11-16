package edu.spring.istfi.repository;

import edu.spring.istfi.model.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticuloRepository extends JpaRepository<Articulo, Long> {
    Articulo findByCodigo(long codigo);
}

