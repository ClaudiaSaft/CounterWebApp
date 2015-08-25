package br.com.counter.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.com.counter.entity.Usuario;
import br.com.counter.repository.UsuarioRepository;
import br.com.counter.vo.ConsultaUsuarioVO;

@Stateless
@LocalBean
public class UsuarioService {

	@Inject
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> getUsuarios(ConsultaUsuarioVO usuarioFiltro) {
		return this.usuarioRepository.getUsuarios(usuarioFiltro);
	}

	public void atualizar(Usuario usuario) {
		if (usuario.getCodigo() == null) {
			this.usuarioRepository.save(usuario);
			FacesContext.getCurrentInstance().addMessage("", new FacesMessage(null, "Usuario salvo com sucesso!"));
		}else {
			this.usuarioRepository.update(usuario);
			FacesContext.getCurrentInstance().addMessage("", new FacesMessage(null, "Usuario atualizado com sucesso!"));
		}
	}

	public void excluir(Usuario usuario) {
		this.usuarioRepository.excluir(usuario);
		FacesContext.getCurrentInstance().addMessage("", new FacesMessage(null, "Usuario excluido com sucesso!"));
	}
}
