package br.com.counter.mbean;

import java.io.Serializable;

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
public class CadastroUsuarioMBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@EJB
	private UsuarioService usuarioService; 
	
	private Usuario usuario;
	
	@PostConstruct
	public void init(){
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		Object object = flash.get("usuario");
		
		if (object != null) {
			usuario = (Usuario) object;
		}else {
			usuario = new Usuario();
		}
	}

	public void atualizar(){
		usuarioService.atualizar(usuario);
		limpar();
	}
	
	public void limpar(){
		usuario = new Usuario();
	}
	
	public String voltar(){
		return Pages.CONSULTA_USUARIO.getValue();
	}

	//GETTERS AND SETTERS
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
