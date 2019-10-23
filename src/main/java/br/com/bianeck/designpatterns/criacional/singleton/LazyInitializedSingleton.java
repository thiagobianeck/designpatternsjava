package br.com.bianeck.designpatterns.criacional.singleton;

/**
 * O método de inicialização lenta para implementar o padrão Singleton
 * cria a instância no método de acesso global.
 */
public class LazyInitializedSingleton {
    private static LazyInitializedSingleton instance;

    private LazyInitializedSingleton(){}

    /*
     * Funciona bem no caso de um ambiente de thread único, mas quando se trata de sistemas
     * multithread, pode causar problemas se vários threads estiverem dentro da condição if
     * ao mesmo tempo. Isso destruirá o padrão singleton e os dois threads receberão
     * as diferentes instâncias da classe singleton.
     */
    public static LazyInitializedSingleton getInstance(){
        if(instance == null){
            instance = new LazyInitializedSingleton();
        }
        return instance;
    }
}
