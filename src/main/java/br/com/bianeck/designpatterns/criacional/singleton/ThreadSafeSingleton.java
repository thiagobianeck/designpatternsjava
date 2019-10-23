package br.com.bianeck.designpatterns.criacional.singleton;

/**
 * A maneira mais fácil de criar uma classe singleton segura para threads é sincronizar
 * o método de acesso global , para que apenas um thread possa executar esse método por vez.
 */
public class ThreadSafeSingleton {

    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton(){}

    /*
     * funciona bem e fornece segurança de encadeamento, mas reduz o desempenho
     * devido ao custo associado ao método sincronizado, embora seja necessário
     * apenas para os primeiros encadeamentos que podem criar instâncias separadas
     * (Leia: Sincronização Java ).
     * Para evitar essa sobrecarga extra toda vez, é usado o princípio de bloqueio verificado .
     * Nessa abordagem, o bloco sincronizado é usado dentro da condição if com uma verificação adicional
     * para garantir que apenas uma instância de uma classe singleton seja criada.
     */
    public static synchronized ThreadSafeSingleton getInstance(){
        if(instance == null){
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }

    /*
     *  implementação de bloqueio verificada duas vezes.
     */
    public static ThreadSafeSingleton getInstanceUsingDoubleLocking(){
        if(instance == null){
            synchronized (ThreadSafeSingleton.class) {
                if(instance == null){
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }
}
