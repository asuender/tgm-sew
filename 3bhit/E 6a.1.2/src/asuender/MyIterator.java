package asuender;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Andreas Suender
 * @version 05-07-2022
 */
public class MyIterator<E> implements Iterator<E> {
    private Cell<E> pointer;

    /**
     * Erstellt einen neuen Iterator mit der zu startenden Cell.
     * @param start zu startende Cell
     */
    public MyIterator(Cell<E> start) {
        this.pointer = start;
    }

    /**
     * Ermittelt, ob die aktuelle Cell null ist oder nicht.
     * @return true, wenn die aktuelle Cell nicht null ist, sonst false
     */
    @Override
    public boolean hasNext() {
        return this.pointer != null;
    }

    /**
     * Springt zur aktuellen Nachfolgercell und gibt die aktuelle Instanz zurück.
     * @return aktuelle Instanz
     */
    @Override
    public E next() {
        if (this.pointer == null) {
            throw new NoSuchElementException();
        }

        E value = this.pointer.getValue();
        this.pointer = this.pointer.getNext();

        return value;
    }

    /**
     * Not supported.
     */
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
