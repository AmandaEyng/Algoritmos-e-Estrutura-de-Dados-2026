//inserir pacote

public class ListaEstatica<T> {

    private T[] info;
    private int tamanho;

    @SuppressWarnings("unchecked")
    public ListaEstatica() {
        info = (T[]) new Object[10];
        tamanho = 0;
    }

    private void redimencionar() {

        @SuppressWarnings("unchecked")
        T[] novo = (T[]) new Object[info.length + 10];

        for (int i = 0; i < tamanho; i++) {
            novo[i] = info[i];
        }

        info = novo;
    }

    public void inserir(T valor) {

        if (tamanho == info.length) {
            redimencionar();
        }

        info[tamanho] = valor;
        tamanho = tamanho + 1;
    }

    public void exibir() {

        for (int i = 0; i < tamanho; i++) {
            System.out.println(info[i].toString() + "");
        }

    }

    public int buscar(T valor) {
        for (int i = 0; i < tamanho; i++) {
            if (valor.equals(info[i])) {
                return i;
            }
        }
        return -1;
    }

    public void retirar(T valor) {
        int indiceRemover = buscar(valor);

        if (indiceRemover != -1) {
            for (int i = indiceRemover; i < tamanho - 1; i++) {
                info[i] = info[i + 1];
            }
            tamanho--;
        }
    }

    @SuppressWarnings("unchecked")
    public void liberar() {
        info = (T[]) new Object[10];
        tamanho = 0;
    }

    public T obterElemento(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            throw new IndexOutOfBoundsException("Posição " + posicao + " não existe");
        }

        return info[posicao];
    }

    public boolean estaVazia() {
        // if (tamanho == 0) {
        // return true;
        // }
        // return false;
        // o código acima pode ser resumido a linha que esta abaixo.

        return (tamanho == 0);
    }

    public int getTamanho() {
        return tamanho;
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < tamanho; i++) {
            s += info[i];
            if (i < tamanho - 1) {
                s += ", ";
            }
        }

        return s;
    }

    public void inverter() {

        int inicio = 0;
        int fim = tamanho - 1;

        while (inicio < fim) {
            T temp = info[inicio];
            info[inicio] = info[fim];
            info[fim] = temp;

            inicio++;
            fim--;
        }
    }

}
