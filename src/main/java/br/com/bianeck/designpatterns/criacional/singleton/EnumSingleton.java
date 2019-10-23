package br.com.bianeck.designpatterns.criacional.singleton;

/**
 * Joshua Bloch sugere o uso do Enum para implementar o padrão de design Singleton,
 * pois o Java garante que qualquer valor do enum seja instanciado apenas uma vez em um programa Java.
 * Como os valores do Java Enum são acessíveis globalmente, o mesmo ocorre com o singleton.
 * A desvantagem é que o tipo de enum é um pouco inflexível;
 * por exemplo, ele não permite inicialização lazy.
 */
public enum EnumSingleton {

    INSTANCE;

    public static void doSomething(){
        //do something
    }
}
