    package org.example.spotgridv2.repository;


    import org.example.spotgridv2.model.Usuario;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.data.repository.CrudRepository;
    import org.springframework.stereotype.Repository;

    import java.util.Optional;

    @SuppressWarnings("unused")
    @Repository
    public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
        Optional<Usuario> findByUsuario(String usuario);
    }