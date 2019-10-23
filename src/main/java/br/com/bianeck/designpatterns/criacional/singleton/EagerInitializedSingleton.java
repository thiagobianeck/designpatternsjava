package br.com.bianeck.designpatterns.criacional.singleton;

/**
 * -- INICIALIZAÇÃO EAGER --
 * Na inicialização ansiosa, a instância da Classe Singleton é criada no momento do carregamento da classe;
 * esse é o método mais fácil de criar uma classe singleton, mas há uma desvantagem de que a instância é
 * criada mesmo que o aplicativo cliente possa não estar usando.
 */

public class EagerInitializedSingleton {

    private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();

    /*
     * Devemos evitar a instanciação até que o cliente chame o getInstancemétodo.
     * Além disso, esse método não fornece nenhuma opção para manipulação de exceções.
     */
    private EagerInitializedSingleton(){}

    public static EagerInitializedSingleton getInstance() {
        return instance;
    }
}
