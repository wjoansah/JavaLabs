package generics;

public interface StackADT<E> {
    void push(E t);

    E pop();

    E top();

    int size();

    boolean isEmpty();
}
