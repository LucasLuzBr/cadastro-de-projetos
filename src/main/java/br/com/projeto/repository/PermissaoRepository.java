package br.com.projeto.repository;

import br.com.projeto.model.Permissao;
import br.com.projeto.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PermissaoRepository extends JpaRepository<Permissao, Long> {

    List<Permissao> findByUsuariosIn(Usuario... usuario);
}
