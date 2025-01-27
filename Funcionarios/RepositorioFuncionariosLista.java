public class RepositorioFuncionariosLista implements RepositorioFuncionarios {
	private Funcionario funcionario;
	private RepositorioFuncionariosLista prox;

	RepositorioFuncionariosLista() {
		this.funcionario = null;
		this.prox = null;
	}

	public void inserirFuncionario(Funcionario funcionario) {
		if (this.funcionario == null) {
			this.funcionario = funcionario;
			this.prox = new RepositorioFuncionariosLista();
		} else {
			this.prox.inserirFuncionario(funcionario);
		}
	}

	public void removerFuncionario(Funcionario removido) {
		if (this.funcionario == removido) {
			this.funcionario = this.prox.funcionario;
			this.prox = this.prox.prox;
		} else {
			this.prox.removerFuncionario(removido);
		}
	}
	
	public void atualizarFuncionario(Funcionario antigo, Funcionario novo) {
		if (this.funcionario == antigo) {
			this.funcionario = novo;
			this.prox = this.prox.prox;
		} else {
			this.prox.removerFuncionario(antigo);
		}
	}

	public boolean existeFuncionario(Funcionario procurado) {
		if (this.funcionario == null) {
			return false;
		} else if (this.funcionario == procurado) {
			return true;
		} else {
			return this.prox.existeFuncionario(procurado);
		}
	}
	
	
	
	public String listarFuncionarios(String parcial) {
		String res = "";
		if (this.funcionario == null) {
			return parcial;
		} else {
			parcial += this.funcionario.getDados() + "\n";
			res = this.prox.listarFuncionarios(parcial);
		}

		if (parcial != "")
			return res;
		else {
//ERRO
			return res;
		}

	}
}