package modelo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ListaEstaticaTeste {

    private ListaEstatica<Integer> lista;

    @BeforeEach
    void setUp() {
        // Inicializa a lista como Integer para os testes
        lista = new ListaEstatica<>();
    }

    @Test
    void testeInverterPar_Caso10() {
        // Entrada: 5, 10, 15, 20
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.inverter();

        // Saída esperada: "20, 15, 10, 5"
        // Nota: O seu toString adiciona espaço após a vírgula ("s += ", ";")
        assertEquals("20, 15, 10, 5", lista.toString());
    }

    @Test
    void testeInverterImpar_Caso11() {
        // Entrada: 5, 10, 15, 20, 25
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.inserir(25);

        lista.inverter();

        // Saída esperada: "25, 20, 15, 10, 5"
        assertEquals("25, 20, 15, 10, 5", lista.toString());
    }
}
