package modelo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ListaEstaticaTeste {

	private ListaEstatica lista;

	@BeforeEach
	void setUp() {
		// Inicializa uma nova lista antes de cada teste
		lista = new ListaEstatica();
	}

	@Test
	void testeInserirTamanho() {
		lista.inserir(5);
		lista.inserir(10);
		lista.inserir(15);
		assertEquals(3, lista.getTamanho(), "O tamanho deve ser 3 após inserir 3 elementos");
	}

	@Test
	void testeToString() {
		lista.inserir(5);
		lista.inserir(10);
		lista.inserir(15);
		// Nota: O toString precisa daquele ajuste que comentei na resposta anterior
		assertEquals("5, 10, 15", lista.toString());
	}

	@Test
	void testeBuscarElementoExistente() {
		lista.inserir(5);
		lista.inserir(10);
		assertEquals(1, lista.buscar(10), "Deve retornar o índice 1 para o valor 10");
	}

	@Test
	void testeBuscarElementoInexistente() {
		lista.inserir(5);
		assertEquals(-1, lista.buscar(100), "Deve retornar -1 para valores não encontrados");
	}

	@Test
	void testeRetirar() {
		lista.inserir(5);
		lista.inserir(10);
		lista.inserir(15);
		lista.retirar(10);
		assertEquals(2, lista.getTamanho());
		assertEquals("5, 15", lista.toString());
	}

	@Test
	void testeRedimensionamento() {
		// Insere 15 elementos (o padrão inicial é 10)
		for (int i = 0; i < 15; i++) {
			lista.inserir(i);
		}
		assertEquals(15, lista.getTamanho(), "A lista deve redimensionar automaticamente");
	}

	@Test
	void testeObterElemento() {
		lista.inserir(50);
		assertEquals(50, lista.obterElemento(0));
	}

	@Test
	void testeObterElementoInvalido() {
		// Testa se o código lança a exceção corretamente
		assertThrows(IndexOutOfBoundsException.class, () -> {
			lista.obterElemento(10);
		});
	}

	@Test
	void testeLiberar() {
		lista.inserir(10);
		lista.liberar();
		assertTrue(lista.estaVazia(), "A lista deve estar vazia após o liberar()");
		assertEquals(0, lista.getTamanho());
	}
}
