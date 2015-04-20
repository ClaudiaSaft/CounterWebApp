package br.com.counter.mbean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

import br.com.counter.entity.Usuario;
import br.com.counter.enumeration.Pages;
import br.com.counter.service.UsuarioService;

/**
 * @author CLAUDIA
 *
 */
@ManagedBean
@ViewScoped
public class ConsultaUsuarioMBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@EJB
	private UsuarioService usuarioService; 
	
	private Usuario usuarioFiltro;
	private Usuario usuario;
	private List<Usuario> usuarios;
	
	@PostConstruct
	public void init(){
		usuarioFiltro = new Usuario();
		usuario = new Usuario();
	}

	public void pesquisar(){
		usuarios = usuarioService.getUsuarios(usuarioFiltro);
	}
	
	public String novo(){
		return Pages.CADASTRO_USUARIO.getValue();
	}

	public String editar(){
		//Adiciona usuario na memoria flash, este objeto ira durar apenas uma requisicao
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flash.put("usuario", usuario);
		return Pages.CADASTRO_USUARIO.getValue();
	}
	
	public void excluir(){
		usuarioService.excluir(usuario);
		usuarios.remove(usuario);
	}
	
	//GETTERS AND SETTERS
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario getUsuarioFiltro() {
		return usuarioFiltro;
	}

	public void setUsuarioFiltro(Usuario usuarioFiltro) {
		this.usuarioFiltro = usuarioFiltro;
	}
	
}
