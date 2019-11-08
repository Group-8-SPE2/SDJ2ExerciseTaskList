package collection;

import Chef.Burger;

public interface BlockingQueue {
    void enqueue(Burger element);

    Burger first();

    Burger dequeue();

    int size();

    boolean isEmpty();

    boolean isFull();

    int indexOf(Burger element);

    boolean contains(Burger element);
}
