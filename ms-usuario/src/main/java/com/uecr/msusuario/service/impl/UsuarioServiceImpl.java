package com.uecr.msusuario.service.impl;

import com.uecr.msusuario.entity.Usuario;
import com.uecr.msusuario.repository.UsuarioRepository;
import com.uecr.msusuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario findById(int id) {
        return usuarioRepository.findById(id).get();
    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario update(int id, Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void delete(int id) {
        usuarioRepository.deleteById(id);
    }
}
