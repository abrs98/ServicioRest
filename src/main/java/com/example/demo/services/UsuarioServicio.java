package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.UsuarioModel;
import com.example.demo.repositories.UsuarioRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicio {
    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return (ArrayList<UsuarioModel>) usuarioRepositorio.findAll();
    }

    public  UsuarioModel guardarUsuario(UsuarioModel usuario){
        return usuarioRepositorio.save(usuario);
    }

    public Optional<UsuarioModel> obtenerPorId(long id){
        return usuarioRepositorio.findById(id);
    }

    public ArrayList<UsuarioModel> obtenerPorPrioridad(Integer prioridad){
        return usuarioRepositorio.findByPrioridad(prioridad);
    }

    public ArrayList<UsuarioModel> obtenerPorNombre(String nombre){
        return usuarioRepositorio.findByNombre(nombre);
    }

    public ArrayList<UsuarioModel> obtenerPorEmail(String email){
        return usuarioRepositorio.findByEmail(email);
    }

    public boolean eliminarUsuario(long id){
        try{
            usuarioRepositorio.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
