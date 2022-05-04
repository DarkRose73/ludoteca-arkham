package com.ludoteca.arkham.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ludoteca.arkham.modelo.Expansion;

@Repository
public interface ExpansionRepositorio extends JpaRepository<Expansion, Integer>{

}
