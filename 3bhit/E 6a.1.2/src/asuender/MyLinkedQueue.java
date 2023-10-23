package asuender;

/**
 * Eigene Implementation einer LinkedList.
 * @author Andreas Suender
 * @version 05-07-2022
 */
public class MyLinkedQueue<E> implements Iterable<E>, MyQueue<E> {
    private Cell<E> front;
    private Cell<E> rear;
    private int count;

    /**
     * Ermittelt, ob die aktuelle Liste leer ist oder nicht.
     * @return true, wenn sie leer ist, sonst false
     */
    public boolean isEmpty() {
        return this.count > 0;
    }

    /**
     * Gibt das erste Element in der Liste zurück.
     * @return das erste Element
     */
    public E peek() {
        return front.getValue();
    }

    /**
     * Gibt das letzte Element in der Liste zurück.
     * @return das letzte Element in der Liste
     */
    public E peekLast() {
        return rear.getValue();
    }

    /**
     * Fügt ein neues Element am Ende der Liste hinzu.
     * @param element das Element, welches hinzugefügt werden soll
     * @return die aktuelle Liste
     */
    public MyQueue<E> append(E element) {
        Cell<E> newCell = new Cell<>(element);

        if (this.rear != null) {
            this.rear.setNext(newCell);
        } else {
            if (this.front == null) {
                this.front = newCell;
            }
        }

        this.rear = newCell;

        ++count;
        return this;
    }

    /**
     * Löscht das Element am Anfang der Liste.
     * @return das gelöschte Element
     */
    public E delete() {
        if (this.front != null) {
            E elem = this.front.getValue();
            this.front = this.front.getNext();

            --count;
            return elem;
        }

        return null;
    }

    /**
     * Gibt die aktuelle Anzahl der Elemente in der Liste zurück.
     * @return aktuelle Anzahl der Elemente in der Liste
     */
    public int size() {
        return count;
    }

    /**
     * Gibt einen {@link MyIterator<E>} zurück.
     * @return Iterator
     */
    @Override
    public MyIterator<E> iterator() {
        return new MyIterator<>(this.front);
    }

    /**
     * Gibt eine String-Repräsentation der aktuellen Liste zurück.
     * @return
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
