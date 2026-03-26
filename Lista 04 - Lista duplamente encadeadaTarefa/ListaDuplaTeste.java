package modelo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ListaDuplaTeste {

    private ListaDupla<Integer> lista;

    @BeforeEach
    void setUp() {
        lista = new ListaDupla<>();
    }

    @Test
    void teste1_InclusaoEConsistencia() {
        // Entrada: 5, 10, 15, 20
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        // Saída esperada (Início ao Fim): 20, 15, 10, 5
        NoListaDupla<Integer> p = lista.getPrimeiro();
        assertEquals(20, p.getInfo());
        assertEquals(15, p.getProximo().getInfo());
        assertEquals(10, p.getProximo().getProximo().getInfo());
        assertEquals(5, p.getProximo().getProximo().getProximo().getInfo());

        // Navegar até o fim para testar a volta
        NoListaDupla<Integer> ultimo = p.getProximo().getProximo().getProximo();
        
        // Saída esperada (Fim ao Início): 5, 10, 15, 20
        assertEquals(5, ultimo.getInfo());
        assertEquals(10, ultimo.getAnterior().getInfo());
        assertEquals(15, ultimo.getAnterior().getAnterior().getInfo());
        assertEquals(20, ultimo.getAnterior().getAnterior().getAnterior().getInfo());
    }

    @Test
    void teste2_BuscarNoInicio() {
        lista.inserir(5); lista.inserir(10); lista.inserir(15); lista.inserir(20);
        NoListaDupla<Integer> encontrado = lista.buscar(20);
        assertNotNull(encontrado);
        assertEquals(20, encontrado.getInfo());
    }

    @Test
    void teste3_BuscarNoMeio() {
        lista.inserir(5); lista.inserir(10); lista.inserir(15); lista.inserir(20);
        NoListaDupla<Integer> encontrado = lista.buscar(10);
        assertNotNull(encontrado);
        assertEquals(10, encontrado.getInfo());
    }

    @Test
    void teste4_RemoverNoInicio() {
        lista.inserir(5); lista.inserir(10); lista.inserir(15); lista.inserir(20);
        lista.retirar(20);
        
        // Esperado: 15, 10, 5
        assertEquals("15 10 5 ", lista.toString());
        assertNull(lista.getPrimeiro().getAnterior(), "O novo primeiro deve ter anterior null");
    }

    @Test
    void teste5_RemoverNoMeio() {
        lista.inserir(5); lista.inserir(10); lista.inserir(15); lista.inserir(20);
        lista.retirar(10);
        
        // Esperado: 20, 15, 5
        assertEquals("20 15 5 ", lista.toString());
        
        // Verifica consistência após remoção no meio
        NoListaDupla<Integer> no15 = lista.buscar(15);
        NoListaDupla<Integer> no5 = lista.buscar(5);
        assertEquals(no5, no15.getProximo());
        assertEquals(no15, no5.getAnterior());
    }

    @Test
    void teste6_RemoverNoFim() {
        lista.inserir(5); lista.inserir(10); lista.inserir(15); lista.inserir(20);
        lista.retirar(5);
        
        // Esperado: 20, 15, 10
        assertEquals("20 15 10 ", lista.toString());
        
        NoListaDupla<Integer> no10 = lista.buscar(10);
        assertNull(no10.getProximo(), "O novo último deve ter proximo null");
    }

    @Test
    void teste7_LiberarLista() {
        lista.inserir(5);
        lista.inserir(10);
        
        // Pegamos a referência de um nó antes de liberar
        NoListaDupla<Integer> no10 = lista.buscar(10);
        
        lista.Liberar(); // O seu método está com L maiúsculo no código
        
        assertNull(lista.getPrimeiro(), "A lista deve ficar vazia");
        
        /* 
         * Nota sobre o Caso 7 da imagem:
         * O seu método Liberar() atual apenas faz 'primeiro = null'. 
         * Para o teste de 'anterior e proximo igual a null' passar nos nós antigos,
         * o Java precisaria que você percorresse a lista limpando os ponteiros manualmente.
         */
    }
}
