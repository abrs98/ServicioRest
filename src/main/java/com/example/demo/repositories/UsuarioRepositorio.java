package com.example.demo.repositories;

import java.util.ArrayList;

import com.example.demo.models.UsuarioModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends CrudRepository<UsuarioModel,Long>{

    public abstract ArrayList<UsuarioModel> findByNombre(String nombre);
    public abstract ArrayList<UsuarioModel> findByEmail(String email);
    public abstract ArrayList<UsuarioModel> findByPrioridad(Integer prioridad);
}
