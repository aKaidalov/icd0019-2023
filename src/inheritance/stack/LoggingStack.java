package inheritance.stack;

import java.util.Stack;

public class LoggingStack extends Stack<Integer> {
    @Override
    public Integer push(Integer item) { // Just write method's name and Intellij makes all for you.
        System.out.println("Pushed: " + item);
        return super.push(item);
    }

    //    @Override
//    public Integer push(Integer item) {
//        addElement(item);
//        System.out.println("Pushed: " + item);
//
//        return item;
//    }

    @Override
    public synchronized Integer pop() {
        Integer popped = super.pop();
        System.out.println("Popped: " + popped);
        return popped;
    }

    //    @Override
//    public synchronized Integer pop() {
//        Integer obj;
//        int len = size();
//
//        obj = peek();
//        removeElementAt(len - 1);
//
//        System.out.println("Popped: " + obj);
//
//        return obj;
//    }

    public void pushAll(Integer... numbers) {   // "Integer..." here means 0 to multiple arguments of type Integer.
        System.out.println("Method 'pushAll' was used.");
        for (Integer number : numbers) {
            push(number);
        }
    }
}
