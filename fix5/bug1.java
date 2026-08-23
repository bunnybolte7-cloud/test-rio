import java.util.ArrayList;
import java.util.List;

public class BuggyCalculator {

    // Bug 1: Can you find the math mistake?
    public static double calculateAverage(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }
        
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        
        // Hint: Think about what happens when you divide an integer by an integer
        return sum / numbers.size();
    }

    // Bug 2: This method crashes under a specific condition
    public static void printReverseString(String text) {
        // Hint: What happens if 'text' is missing entirely?
        if (text.length() == 0) {
            System.out.println("String is empty");
            return;
        }

        String reversed = new StringBuilder(text).reverse().toString();
        System.out.println("Reversed: " + reversed);
    }

    // Bug 3: This loop causes a major crash
    public static void removeEvenNumbers(List<Integer> numbers) {
        // Hint: You cannot safely modify a list while looping through it this way
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) % 2 == 0) {
                numbers.remove(i); 
            }
        }
    }

    public static void main(String[] args) {
        // Test Bug 1: Expected 2.5, but what do you actually get?
        List<Integer> inventory = new ArrayList<>(List.of(1, 2, 3, 4));
        System.out.println("Average: " + calculateAverage(inventory));

        // Test Bug 3: This will skip numbers or throw an error
        removeEvenNumbers(inventory);
        System.out.println("Remaining odd numbers: " + inventory);

        // Test Bug 2: This line will crash the program immediately
        printReverseString(null); 
    }
}
