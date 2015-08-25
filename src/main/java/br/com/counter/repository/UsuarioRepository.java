package br.com.counter.repository;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.counter.entity.Usuario;
import br.com.counter.vo.ConsultaUsuarioVO;

@Named
public class UsuarioRepository {

	@PersistenceContext
	private EntityManager manager;
	
	public void save(Usuario usuario) {
		this.manager.persist(usuario);
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> getUsuarios(ConsultaUsuarioVO usuarioFiltro) {
		StringBuilder sql = new StringBuilder("SELECT u FROM Usuario u WHERE 1=1 ");
		
		if (usuarioFiltro.getNome() != null && !usuarioFiltro.getNome().equals("")) {
			sql.append(" AND UPPER(u.nome) like :nome");
		}
		if (usuarioFiltro.getDataNascimento() != null) {
			sql.append(" AND u.dataNascimento = :dataNascimento");
		}
		
		Query query = manager.createQuery(sql.toString());
		
		if (usuarioFiltro.getNome() != null && !usuarioFiltro.getNome().equals("")) {
			query.setParameter("nome", "%" + usuarioFiltro.getNome().toUpperCase() + "%");
		}
		if (usuarioFiltro.getDataNascimento() != null) {
			query.setParameter("dataNascimento", usuarioFiltro.getDataNascimento());
		}
		
		return query.getResultList();
	}

	public void update(Usuario usuario) {
		this.manager.merge(usuario);
	}

	public void excluir(Usuario usuario) {
		Usuario usuarioExcluir = this.manager.find(Usuario.class, usuario.getCodigo());
		this.manager.remove(usuarioExcluir);
	}

}
