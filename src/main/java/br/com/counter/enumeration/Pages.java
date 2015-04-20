package br.com.counter.enumeration;

public enum Pages {

	CONSULTA_USUARIO("consultaUsuario.jsf"),
	CADASTRO_USUARIO("cadastroUsuario.jsf");
	
	private String url;
	
	private Pages(String url){
		this.url = url;
	}
	
	public String getValue() {
		return url;
	}
}
