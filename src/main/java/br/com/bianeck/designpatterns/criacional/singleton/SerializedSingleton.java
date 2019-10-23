package br.com.bianeck.designpatterns.criacional.singleton;

import java.io.Serializable;

/**
 * Às vezes, em sistemas distribuídos, precisamos implementar a interface Serializable
 * na classe Singleton, para que possamos armazenar seu estado no
 * sistema de arquivos e recuperá-lo posteriormente.
 */
public class SerializedSingleton implements Serializable{

    private static final long serialVersionUID = -7604766932017737115L;

    private SerializedSingleton(){}

    /*
     * O problema com a classe singleton serializada é que sempre
     * que a desserializar, ela criará uma nova instância da classe.
     */
    private static class SingletonHelper{
        private static final SerializedSingleton instance = new SerializedSingleton();
    }

    public static SerializedSingleton getInstance(){
        return SingletonHelper.instance;
    }

    protected Object readResolve() {
        return getInstance();
    }

}
