package generics;

import java.util.ArrayList;
import java.util.Arrays;

public class StackImpl<E> implements StackADT<E> {
    private final ArrayList<E> stack;
    private int size;

    public StackImpl() {
        this.stack = new ArrayList<>();
    }

    @Override
    public void push(E t) {
        stack.add(t);
        size += 1;
    }

    @Override
    public E pop() {
        size -= 1;
        return stack.removeLast();
    }

    @Override
    public E top() {
        return stack.get(size - 1);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(stack.toArray());
    }

    public static void main(String[] args) {
        var myStack = new StackImpl<>();

        myStack.push(1);
        System.out.println(myStack);
    }
}
