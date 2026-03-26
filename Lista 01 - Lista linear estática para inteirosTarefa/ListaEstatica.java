//inserir pacote

public class ListaEstatica {

    private int[] info;
    private int tamanho;

    public ListaEstatica() {
        info = new int[10];
        tamanho = 0;
    }

    private void redimencionar() {

        int[] novo;
        int novoTamanho = info.length + 10;
        novo = new int[novoTamanho];

        for (int i = 0; i < info.length; i++) {
            novo[i] = info[i];
        }

        info = novo;
    }

    public void inserir(int valor) {

        if (tamanho == info.length) {
            redimencionar();
        }

        info[tamanho] = valor;
        tamanho = tamanho + 1;
    }

    public void exibir() {

        for (int i = 0; i < tamanho; i++) {
            System.out.println(info[i]);
        }

    }

    public int buscar(int valor) {
        int indice = -1;

        for (int i = 0; i < tamanho; i++) {
            if (valor == info[i]) {
                indice = i;
            }
        }

        return indice;
    }

    public void retirar(int valor) {
        int indiceRemover = buscar(valor);

        for (int i = indiceRemover; i < tamanho - 1; i++) {
            info[i] = info[i + 1];
        }

        tamanho--;
    }

    public void liberar() {
        info = new int[10];
        tamanho = 0;
    }

    public int obterElemento(int posicao) {
        if (posicao < 0 || posicao > tamanho) {
            throw new IndexOutOfBoundsException("Posição " + posicao + " não existe");
        }

        return info[posicao];
    }

    public boolean estaVazia() {
        //if (tamanho == 0) {
        //	return true;
        //}
        //return false;
        // o código acima pode ser resumido a linha que esta abaixo.

        return (tamanho == 0);
    }

    public int getTamanho() {
        return tamanho;
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < tamanho - 1; i++) {
            s += info[i];
            if (i < tamanho - 1) {
                s += ", ";
            }
        }

        return s;
    }

}
