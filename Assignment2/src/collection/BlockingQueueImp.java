package collection;

import Chef.Burger;

public class BlockingQueueImp implements BlockingQueue {

    private ListADT list;

    public BlockingQueueImp() {
        list = new ArrayList();
    }

    @Override
    public void enqueue(Burger element) {
        if (element == null) throw new IllegalArgumentException("Cannot enqueue null");
        list.add(element);
    }

    @Override
    public Burger first() {
        if (list.isEmpty()) throw new IllegalStateException("Queue is empty");
        return (Burger) list.get(0);
    }

    @Override
    public Burger dequeue() {
        if (list.isEmpty()) throw new IllegalStateException("Queue is empty");
        return (Burger) list.remove(0);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean isFull() {
        return list.isFull();
    }

    @Override
    public int indexOf(Burger element) {
        return list.indexOf(element);
    }

    @Override
    public boolean contains(Burger element) {
        return list.contains(element);
    }
}
