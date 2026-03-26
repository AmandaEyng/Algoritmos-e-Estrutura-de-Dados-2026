package modelo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ListaEncadeadaTeste {

    private ListaEncadeada<Integer> lista;

    @BeforeEach
    void setUp() {
        lista = new ListaEncadeada<>();
    }

    @Test
    void teste1_ListaVazia() {
        assertTrue(lista.estaVazia());
    }

    @Test
    void teste2_ListaNaoVazia() {
        lista.inserir(5);
        assertFalse(lista.estaVazia());
    }

    @Test
    void teste3_InclusaoSimples() {
        lista.inserir(5);
        NoLista<Integer> primeiro = lista.getPrimeiro();
        assertNotNull(primeiro);
        assertEquals(5, primeiro.getInfo());
        assertNull(primeiro.getProximo());
    }

    @Test
    void teste4_InclusaoMultipla() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        // A inserção é no início: deve ser 15 -> 10 -> 5
        assertEquals(15, lista.ObterNo(0).getInfo());
        assertEquals(10, lista.ObterNo(1).getInfo());
        assertEquals(5, lista.ObterNo(2).getInfo());
    }

    @Test
    void teste5_BuscaInicio() {
        lista.inserir(5); lista.inserir(10); lista.inserir(15); lista.inserir(20);
        NoLista<Integer> no = lista.buscar(20);
        assertNotNull(no);
        assertEquals(20, no.getInfo());
    }

    @Test
    void teste6_BuscaMeio() {
        lista.inserir(5); lista.inserir(10); lista.inserir(15); lista.inserir(20);
        NoLista<Integer> no = lista.buscar(15);
        assertNotNull(no);
        assertEquals(15, no.getInfo());
    }

    @Test
    void teste7_BuscaInexistente() {
        lista.inserir(5); lista.inserir(10); lista.inserir(15); lista.inserir(20);
        assertNull(lista.buscar(50));
    }

    @Test
    void teste8_RetirarPrimeiro() {
        lista.inserir(5); lista.inserir(10); lista.inserir(15); lista.inserir(20);
        lista.retirar(20);
        assertEquals(3, lista.obterComprimento());
        assertEquals(15, lista.getPrimeiro().getInfo());
    }

    @Test
    void teste9_RetirarMeio() {
        lista.inserir(5); lista.inserir(10); lista.inserir(15); lista.inserir(20);
        lista.retirar(15);
        assertEquals(3, lista.obterComprimento());
        // Deve sobrar: 20 -> 10 -> 5
        assertEquals(10, lista.ObterNo(1).getInfo());
    }

    @Test
    void teste10_ObterNoInicio() {
        lista.inserir(5); lista.inserir(10); lista.inserir(15); lista.inserir(20);
        assertEquals(20, lista.ObterNo(0).getInfo());
    }

    @Test
    void teste11_ObterNoFim() {
        lista.inserir(5); lista.inserir(10); lista.inserir(15); lista.inserir(20);
        assertEquals(5, lista.ObterNo(3).getInfo());
    }

    @Test
    void teste12_ObterNoInvalido() {
        lista.inserir(5); lista.inserir(10); lista.inserir(15); lista.inserir(20);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            lista.ObterNo(10);
        });
    }

    @Test
    void teste13_ComprimentoVazia() {
        assertEquals(0, lista.obterComprimento());
    }

    @Test
    void teste14_ComprimentoPopulada() {
        lista.inserir(5); lista.inserir(10); lista.inserir(15); lista.inserir(20);
        assertEquals(4, lista.obterComprimento());
    }
}
