package src.doublylinkedlist.undoredofunctionality;

public class TextEditors {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor(10); // Limit history to 10 states

        // Adding states
        editor.addState("Hello");
        editor.addState("Hello, World");
        editor.addState("Hello, World!");
        editor.addState("Hello, Java!");

        // Display current state
        editor.displayCurrentState();

        // Perform undo operations
        editor.undo();
        editor.undo();

        // Perform redo operations
        editor.redo();

        // Add a new state (clears redo history)
        editor.addState("Hello, Undo/Redo!");

        // Display current state after redo is cleared
        editor.displayCurrentState();

        // Attempt more undo/redo operations
        editor.undo();
        editor.redo();
    }
}
