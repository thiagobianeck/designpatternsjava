package br.com.bianeck.designpatterns.criacional.singleton;

import java.lang.reflect.Constructor;

/**
 * O Reflection pode ser usado para destruir todas as abordagens de implementação singleton utilizadas
 * neste pacote
 */
public class ReflectionSingletonTest {

    /**
     * Ao executar a classe de teste acima, você notará que o hashCode de ambas as instâncias
     * não é o mesmo que destrói o padrão singleton. O Reflection é muito poderoso
     * e usado em muitas estruturas, como Spring e Hibernate
     */

    public static void main(String[] args) {
        EagerInitializedSingleton instanceOne = EagerInitializedSingleton.getInstance();
        EagerInitializedSingleton instanceTwo = null;
        try {
            Constructor[] constructors = EagerInitializedSingleton.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                //Below code will destroy the singleton pattern
                constructor.setAccessible(true);
                instanceTwo = (EagerInitializedSingleton) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(instanceOne.hashCode());
        System.out.println(instanceTwo.hashCode());
    }
}
