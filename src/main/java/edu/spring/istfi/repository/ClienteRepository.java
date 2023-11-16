package edu.spring.istfi.repository;


import edu.spring.istfi.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Integer> {
    Cliente findByDni(int DNI);
}
