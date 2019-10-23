package br.com.bianeck.designpatterns.criacional.singleton;

/**
 * Antes do Java 5, o modelo de memória java apresentava muitos problemas e as outras abordagens
 * costumavam falhar em certos cenários em que muitos encadeamentos tentam obter a instância da
 * classe Singleton simultaneamente. Então Bill Pugh criou uma abordagem diferente para criar
 * a classe Singleton usando uma classe auxiliar estática interna
 */
public class BillPughSingleton {

    private BillPughSingleton(){}

    /*
     * Observe a classe estática interna privada que contém a instância da classe singleton.
     * Quando a classe singleton é carregada, a SingletonHelperclasse não é carregada na memória
     * e somente quando alguém chama o método getInstance , essa classe é carregada
     * e cria a instância da classe Singleton.
     * Essa é a abordagem mais usada para a classe Singleton, pois não requer sincronização.
     */
    private static class SingletonHelper{
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance(){
        return SingletonHelper.INSTANCE;
    }
}
