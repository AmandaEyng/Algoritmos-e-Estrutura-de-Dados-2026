package modelo;

public class ListaEncadeada<T> {

	private NoLista<T> primeiro;

	public NoLista<T> getPrimeiro() {
		return primeiro;
	}

	public void inserir(T valor) {

		NoLista<T> novo = new NoLista<>();
		novo.setInfo(valor);
		novo.setProximo(primeiro);
		this.primeiro = novo;
	}

	public boolean estaVazia() {
		return this.primeiro == null;
	}

	public NoLista<T> buscar(T valor) {
		NoLista<T> p = primeiro;
		while (p != null) {
			if (p.getInfo().equals(valor)) {
				return p;
			}
			p = p.getProximo();
		}
		return null;
	}

	public void retirar(T valor) {

		NoLista<T> anterior = null;
		NoLista<T> p = primeiro;
		while (p != null && !p.getInfo().equals(valor)) {
			anterior = p;
			p = p.getProximo();
		}
		if (p != null) {
			if (p == primeiro) {
				this.primeiro = p.getProximo();
			} else {
				anterior.setProximo(p.getProximo());
			}

		}
	}

	public int obterComprimento() {

		int comprimento = 0;
		NoLista<T> p = primeiro;
		while (p != null) {
			p = p.getProximo();
			comprimento++;
		}
		return comprimento;
	}

	public NoLista<T> ObterNo(int idx) throws IndexOutOfBoundsException {

		if (idx < 0 || idx > obterComprimento() - 1) {
			throw new IndexOutOfBoundsException();
		}
		int contador = 0;
		NoLista<T> p = primeiro;
		while (p != null) {
			if (contador == idx) {
				return p;
			}
			p = p.getProximo();
			contador++;
		}
		return null;
	}

	public String toString() {
		String texto = "";
		NoLista<T> p = primeiro;
		while (p != null) {
			if (texto.isBlank()) {
				texto += p.getInfo();
			}
			texto += p.getInfo() + ", ";
			p = p.getProximo();
		}
		return texto;
	}
	
	  /** 
	   * Sugestão da IA do Google:
	   * 
	   * Seu código atual repete o primeiro elemento por causa do if (texto.isBlank()). 
	   * Use esta versão para evitar erros:
	   * 
	   * public String toString() {
	   *     String texto = "";
	   *     NoLista<T> p = primeiro;
	   *     while (p != null) {
	   *         texto += p.getInfo();
	   *         if (p.getProximo() != null) {
	   *             texto += ", ";
	   *         }
	   *         p = p.getProximo();
	   *     }
	   *     return texto;
	   * }
	   */

}
