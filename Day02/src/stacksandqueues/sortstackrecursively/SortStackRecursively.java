package stacksandqueues.sortstackrecursively;
import java.util.Stack;

class SortStackRecursively {

    // Function to sort the stack recursively
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int top = stack.pop(); // Remove top element
            sortStack(stack); // Recursively sort remaining stack
            insertSorted(stack, top); // Insert element in correct position
        }
    }

    // Function to insert an element at the correct position in a sorted stack
    private static void insertSorted(Stack<Integer> stack, int value) {
        if (stack.isEmpty() || stack.peek() <= value) {
            stack.push(value);
        } else {
            int top = stack.pop(); // Remove top element
            insertSorted(stack, value); // Recursive call
            stack.push(top); // Push back the removed element
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);
        stack.push(5);

        System.out.println("Original Stack: " + stack);
        sortStack(stack);
        System.out.println("Sorted Stack: " + stack);
    }
}
