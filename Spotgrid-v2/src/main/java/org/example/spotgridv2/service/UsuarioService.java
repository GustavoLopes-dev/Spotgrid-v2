package org.example.spotgridv2.service;

import org.example.spotgridv2.model.Usuario;
import org.example.spotgridv2.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario buscarPorUsuario(String usuarioId) {
        return usuarioRepository.findById(Long.valueOf(usuarioId)).orElse(null);
    }

    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deletar(String usuarioId) {
        usuarioRepository.deleteById(Long.valueOf(usuarioId));
    }
}
