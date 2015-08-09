package br.com.counter.service;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.com.counter.entity.Usuario;
import br.com.counter.repository.UsuarioRepository;

@Stateless
@LocalBean
public class UsuarioService {

	@Inject
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> getUsuarios(Usuario usuario) {
		return this.usuarioRepository.getUsuarios(usuario);
	}

	public void atualizar(Usuario usuario) {
//		usuario.setDataCadastro(new Date());
		if (usuario.getCodigo() == null) {
			this.usuarioRepository.save(usuario);
			FacesContext.getCurrentInstance().addMessage("", new FacesMessage(null, "Usu�rio salvo com sucesso!"));
		}else {
			this.usuarioRepository.update(usuario);
			FacesContext.getCurrentInstance().addMessage("", new FacesMessage(null, "Usu�rio atualizado com sucesso!"));
		}
	}

	public void excluir(Usuario usuario) {
		this.usuarioRepository.excluir(usuario);
		FacesContext.getCurrentInstance().addMessage("", new FacesMessage(null, "Usu�rio exclu�do com sucesso!"));
	}
}
