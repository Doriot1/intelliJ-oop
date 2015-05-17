package xnovakd1.fiit.model.problem;

import java.io.Serializable;
import java.util.Random;

/**
 * V tejto triede Problem implementujem interface Serializable, projekt
 * sice bude fungovat aj bez tejto implementacie, avsak robi to ukladanie a odosielanie objektov jednoduchsie.
 * Generujem v nej nahodny integer, aby som v podtriedach Problemu vedel generovat rozmanite ulohy.
 */

public abstract class Problem implements Serializable {

    private static final long serialVersionUID = 5848318966920649329L;            // konvencia
    protected int randomInt;

    /**
     * Aby zadane ulohy neboli len tie iste vypisy dookola,
     * tak v tejto metode generujem nahodne cislo, ktore v pod-problemoch
     * vyuzivam na vytvorenie unikatneho problemu.
     */

    public Problem() {
        Random random = new Random();
        randomInt = random.nextInt(100);
    }


}
