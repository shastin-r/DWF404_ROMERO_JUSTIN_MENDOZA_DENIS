package com.latin_hoteles.services;

import com.latin_hoteles.entities.Usuario;
import com.latin_hoteles.repositories.UsuarioRepository;
import org.mindrot.jbcrypt.BCrypt;

import java.util.List;

public class UsuarioService {
    private UsuarioRepository usuarioRepository = new UsuarioRepository();

    // Método para registrar un nuevo usuario con contraseña hasheada
    public void registrarUsuario(Usuario usuario) {
        // Hashear la contraseña antes de almacenarla
        String hashedPassword = BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt());
        usuario.setPassword(hashedPassword);
        usuarioRepository.crearUsuario(usuario);
    }

    // Método para verificar la contraseña durante el inicio de sesión
    public boolean verificarContraseña(String passwordIngresada, String passwordHasheada) {
        return BCrypt.checkpw(passwordIngresada, passwordHasheada);
    }

    public Usuario obtenerUsuarioPorId(int id) {
        return usuarioRepository.obtenerUsuarioPorId(id);
    }

    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioRepository.obtenerTodosLosUsuarios();
    }

    public void actualizarUsuario(Usuario usuario) {
        usuarioRepository.actualizarUsuario(usuario);
    }

    public void eliminarUsuario(int id) {
        usuarioRepository.eliminarUsuario(id);
    }
}
