package modelo;

public class ListaDupla<T> {

    private NoListaDupla<T> primeiro;

    public NoListaDupla<T> getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(NoListaDupla<T> primeiro) {
        this.primeiro = primeiro;
    }

    public ListaDupla() {

    }

    public void inserir(T valor) {

        NoListaDupla<T> novo = new NoListaDupla<>();
        novo.setInfo(valor);
        novo.setProximo(primeiro);
        novo.setAnterior(null);
        if (primeiro != null) {
            primeiro.setAnterior(novo);
        }
        this.primeiro = novo;
    }

    public NoListaDupla<T> buscar(T valor) {
        NoListaDupla<T> p = primeiro;
        while (p != null) {
            if (p.getInfo().equals(valor)) {
                return p;
            }
            p = p.getProximo();
        }
        return null;

    }

    public void retirar(T valor) {

        NoListaDupla<T> p = buscar(valor);

        if (p != null) {

            if (primeiro == p) {
                primeiro = p.getProximo();
            } else {
                p.getAnterior().setProximo(p.getProximo());
            }

            if (p.getProximo() != null) {
                p.getProximo().setAnterior(p.getAnterior());
            }

        }

    }

    public void exibirOrdemInvensa() {
        NoListaDupla<T> p = primeiro;

        if (p == null) {
            return;
        }

        while (p.getProximo() != null) {
            p = p.getProximo();
        }

        while (p != null) {
            System.out.println(p.getInfo());
            p = p.getAnterior();
        }
    }

    public void Liberar() {
        primeiro = null;
    }

    @Override
    public String toString() {
        String s = "";

        NoListaDupla<T> p = primeiro;

        while (p != null) {
            s += p.getInfo() + " ";
            p = p.getProximo();
        }

        return s;

    }
}
