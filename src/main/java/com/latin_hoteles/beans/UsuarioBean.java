package com.latin_hoteles.beans;

import com.latin_hoteles.entities.Usuario;
import com.latin_hoteles.services.UsuarioService;

import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean
public class UsuarioBean {

    private String nombre;
    private String password;
    private String rol;

    private UsuarioService usuarioService = new UsuarioService();

    // Método para registrar un nuevo usuario
    public void registrarUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setPassword(password); // El hashing se realizará en el servicio
        usuario.setRol(rol);
        usuarioService.registrarUsuario(usuario);
    }

    // Método para obtener todos los usuarios
    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioService.obtenerTodosLosUsuarios();
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
