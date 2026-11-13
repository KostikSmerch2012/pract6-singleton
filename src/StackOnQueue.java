import java.util.LinkedList;
import java.util.Queue;

public class StackOnQueue {
    private Queue<Integer> mainQueue = new LinkedList<>();
    private Queue<Integer> helpQueue = new LinkedList<>();

    // push: новый элемент должен оказаться в начале mainQueue (вершина стека)
    public void push(int x) {
        helpQueue.add(x);
        while (!mainQueue.isEmpty()) {
            helpQueue.add(mainQueue.poll());
        }
        Queue<Integer> temp = mainQueue;
        mainQueue = helpQueue;
        helpQueue = temp;
    }

    public int pop() {
        return mainQueue.poll();
    }

    public int top() {
        return mainQueue.peek();
    }

    public boolean empty() {
        return mainQueue.isEmpty();
    }

    @Override
    public String toString() {
        return mainQueue.toString();
    }
}
