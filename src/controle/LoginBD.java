package controle;

import modelo.Usuario;

public class LoginBD {

	// public boolean efetuarLogin(String usuario, String senha)
	public Usuario efetuarLogin(Usuario usuario) {
		Usuario user = new Usuario();
		user.setId(1);
		user.setEmail("admin");
		user.setSenha("admin");
		user.setTipoUsuario('s');
		return user;
	}

}
