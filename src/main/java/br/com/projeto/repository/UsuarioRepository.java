package br.com.projeto.repository;

import br.com.projeto.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByLogin(String login);
}
