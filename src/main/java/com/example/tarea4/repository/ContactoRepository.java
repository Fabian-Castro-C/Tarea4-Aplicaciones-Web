package com.example.tarea4.repository;

import com.example.tarea4.model.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContactoRepository extends JpaRepository<Contacto, Integer> {

    // Encontrar un contacto por su email
    Optional<Contacto> findByEmail(String email);

    // Buscar contactos por nombre (parcial o completo)
    List<Contacto> findByNombreContainingIgnoreCase(String nombre);

    // Buscar contactos por teléfono exacto
    Optional<Contacto> findByTelefono(String telefono);
}