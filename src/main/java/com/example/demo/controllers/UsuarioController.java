package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.UsuarioModel;
import com.example.demo.services.UsuarioServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    UsuarioServicio usuarioServicio;

    @GetMapping

    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return usuarioServicio.obtenerUsuarios();
    }

    @PostMapping
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario){
        return this.usuarioServicio.guardarUsuario(usuario);
    }

    @GetMapping(path="/{id}")
    public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") long id){
        return this.usuarioServicio.obtenerPorId(id);
    }

    @GetMapping("/query")
    public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad){
        return this.usuarioServicio.obtenerPorPrioridad(prioridad);
    }

//    @GetMapping("/query")
//    public ArrayList<UsuarioModel> obtenerUsuarioPorNombre(@RequestParam("nombre") String nombre){
//        return this.usuarioServicio.obtenerPorNombre(nombre);
//    }

//    @GetMapping("/query")
//    public ArrayList<UsuarioModel> obtenerUsuarioPorEmail(@RequestParam("email") String email){
//        return this.usuarioServicio.obtenerPorNombre(email);
//    }

    @DeleteMapping(path="/{id}")
    public String eliminarPorId(@PathVariable("id") long id){
        boolean ok = this.usuarioServicio.eliminarUsuario(id);
        if(ok){
            return "Se elimino al usuario con id "+id;
        }else{
            return "No se pudo eliminar al usuario con id "+id;
        }
    }
}
