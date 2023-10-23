package asuender;

/**
 * Speichert eine Instanz beliebigen Typs sowie die Nachfolgerinstanz.
 * @author Andreas Suender
 * @version 05-07-2022
 */
public class Cell<E> {
    private E value;
    private Cell<E> next;

    /**
     * Erstellt ein neues Cell-Objekt und speichert die gegebene Instanz.
     * @param element gegebene Instanz
     */
    public Cell(E element) {
        this.value = element;
    }

    /**
     * Gibt die gespeicherte Instanz zurück.
     * @return gespeicherte Instanz
     */
    public E getValue() {
        return value;
    }

    /**
     * Speichert die gegebene Instanz.
     * @param value gegebene Instanz
     */
    public void setValue(E value) {
        this.value = value;
    }

    /**
     * Gibt die Nachfolgerinstanz zurück.
     * @return
     */
    public Cell<E> getNext() {
        return next;
    }

    /**
     * Setzt die Nachfolgerinstanz.
     * @param next Nachfolgerinstanz
     */
    public void setNext(Cell<E> next) {
        this.next = next;
    }
}
