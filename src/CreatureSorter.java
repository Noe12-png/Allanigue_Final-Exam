import java.util.Stack;

public class CreatureSorter {
    // Static inner class to represent a creature
    static class Creature {
        String name;
        int powerLevel;

        Creature(String name, int powerLevel) {
            this.name = name;
            this.powerLevel = powerLevel;
        }
    }

    public static void main(String[] args) {
        // Fixed input data: array of creatures
        Creature[] creatures = {
            new Creature("Dragon", 95),
            new Creature("Griffin", 88),
            new Creature("Unicorn", 78),
            new Creature("Phoenix", 92),
            new Creature("Centaur", 85)
        };

        // Bubble Sort: Descending Order
        System.out.println("*** Bubble Sort: Descending Order by Power Level ***");
        Creature[] bubbleSorted = creatures.clone();
        bubbleSortDescending(bubbleSorted);
        displayCreatures(bubbleSorted);

        // Selection Sort: Ascending Order
        System.out.println("\n*** Selection Sort: Ascending Order by Power Level ***");
        Creature[] selectionSorted = creatures.clone();
        selectionSortAscending(selectionSorted);
        displayCreatures(selectionSorted);

        // Stack Implementation: Popping Creatures
        System.out.println("\n*** Stack Implementation: Popping Creatures ***");
        Stack<Creature> creatureStack = new Stack<>();
        // Push creatures sorted in descending order into the stack
        for (Creature c : bubbleSorted) {
            creatureStack.push(c);
        }

        // Pop creatures from the stack and display details
        while (!creatureStack.isEmpty()) {
            Creature poppedCreature = creatureStack.pop();
            System.out.println("Popped: " + poppedCreature.name + " - " + poppedCreature.powerLevel);
        }
    }

    // Bubble Sort in Descending Order
    private static void bubbleSortDescending(Creature[] creatures) {
        int n = creatures.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (creatures[j].powerLevel < creatures[j + 1].powerLevel) {
                    // Swap creatures[j] and creatures[j + 1]
                    Creature temp = creatures[j];
                    creatures[j] = creatures[j + 1];
                    creatures[j + 1] = temp;
                }
            }
        }
    }

    // Selection Sort in Ascending Order
    private static void selectionSortAscending(Creature[] creatures) {
        int n = creatures.length;
        for (int i = 0; i < n - 1; i++) {
            // Find the index of the minimum element
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (creatures[j].powerLevel < creatures[minIndex].powerLevel) {
                    minIndex = j;
                }
            }
            // Swap creatures[i] and creatures[minIndex]
            Creature temp = creatures[minIndex];
            creatures[minIndex] = creatures[i];
            creatures[i] = temp;
        }
    }

    // Utility method to display the creatures' details
    private static void displayCreatures(Creature[] creatures) {
        for (Creature c : creatures) {
            System.out.println(c.name + " - " + c.powerLevel);
        }
    }
}
