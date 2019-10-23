package br.com.bianeck.designpatterns.criacional.singleton;

/**
 * -- INICIALIZAÇÃO ESTÁTICA DO BLOCO --
 * A implementação da inicialização do bloco estático é semelhante à inicialização eager,
 * exceto que a instância da classe é criada no bloco estático que fornece a opção para tratamento de exceções .
 */

public class StaticBlockSingleton {

    private static StaticBlockSingleton instance;

    private StaticBlockSingleton(){}

    /*
     * Inicialização ágil e inicialização de bloco estático criam a instância antes mesmo
     * de ser usada e essa não é a melhor prática a ser usada.
     */
    static {
        try {
            instance = new StaticBlockSingleton();
        } catch (Exception e) {
            throw new RuntimeException("Houve um erro ao criar a instância singleton");
        }
    }

    public static StaticBlockSingleton getInstance() {
        return instance;
    }
}
