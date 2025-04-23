package com.uecr.msusuario.service;

import com.uecr.msusuario.entity.Usuario;

import java.util.List;

public interface UsuarioService {
    List<Usuario> findAll();
    Usuario findById(int id);
    Usuario save(Usuario usuario);
    Usuario update(int id,Usuario usuario);
    void delete(int id);
}
