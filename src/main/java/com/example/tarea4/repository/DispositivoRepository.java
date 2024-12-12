package com.example.tarea4.repository;

import com.example.tarea4.model.Dispositivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DispositivoRepository extends JpaRepository<Dispositivo, Long> {
    // No es necesario implementar este repositorio, ya que hereda de JpaRepository
}