package br.com.projeto.bean;

public class UsuarioAutentica {
	
	private static UsuarioBean usuarioLogado;

	// Nao pode ser instanciada
	private UsuarioAutentica() {
	}

	// E chamada apos efetuado login
	public static void setUsuarioLogado(UsuarioBean usuario) throws Exception {
		if (usuarioLogado != null) {
			throw new Exception("Somente um usuário pode estar logado");
		}
		usuarioLogado = usuario;
	}

	public static UsuarioBean getUsuarioLogado() throws Exception {
		if (usuarioLogado == null) {
			throw new Exception("Nenhum usuario foi logado ainda");
		}
		return usuarioLogado;
	}
}


