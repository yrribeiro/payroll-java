package utils;

import java.util.Scanner;
import java.util.Stack;

import objects.State;

public class UndoRedo {
    Scanner scanf = new Scanner(System.in);
    State removed;

    public State displayMenu(Stack<State> states){
        System.out.printf("%n|~ Select what you want to do: %n 1  Undo%n 2  Redo%n> ");
        int userInput = scanf.nextInt();

        switch(userInput){
            case 1: // undo
                System.out.println("\n\n|~ RETURNED TO PREVIOUS MODIFICATION ~|\n");
                return undo(states);
            case 2: // redo
                System.out.println("\n\n|~ RETURNED TO POSTERIOR MODIFICATION ~|\n");
                return redo(states);
            default:
                break;
        }
        return null;
    }

    private void saveRemoved(State removed){
        this.removed = removed;
    }

    private State undo(Stack<State> states){
        if (states.size() == 1){
            return null;
        }
        saveRemoved(states.pop());
        return states.peek();
    }

    private State redo(Stack<State> states){
        return this.removed;
    }
}
