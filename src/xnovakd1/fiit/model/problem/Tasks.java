package xnovakd1.fiit.model.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * V tejto triede Tasks mam uplatneny polymorfizmus, extendujem ArrayList Problemov.
 * Do observableArrayListu pridavam nove ulohy pomocou metody getInstance(), a getAll() metoda
 * sa stara o to, aby ked sa specificky pracovnik prihlasi do programu, tak videl iba typ problem,
 * na ktory je on sam odbornik.
 */

public class Tasks extends ArrayList<Problem> {  // polymorfizmus

    private static final long serialVersionUID = 3464299569935557882L;

    private static Tasks instance;


    public static Tasks getInstance() {
        if (instance == null)
            instance = new Tasks();
        return instance;
    }

    /**
     *
     * @param problem
     * @return
     */

    public List<Problem> getAll(Class<?> problem) {
        List<Problem> list = new ArrayList<>();
        for (Problem p : this)
            if (problem.isInstance(p))
                list.add(p);
		return list;
    }
}
