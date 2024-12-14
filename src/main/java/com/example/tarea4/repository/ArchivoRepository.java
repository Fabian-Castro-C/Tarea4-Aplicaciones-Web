package com.example.tarea4.repository;

import com.example.tarea4.model.Archivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArchivoRepository extends JpaRepository<Archivo, Long> {
    List<Archivo> findByDispositivoId(Long dispositivoId);
}