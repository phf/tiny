import java.util.Scanner;

/**
 * Simple example for using a TinyNode-based list. Reads lines from standard
 * input, removes empty lines, writes lines (in forward and reverse order) to
 * standard output.
 */
public class TinyExample {
    private static class Line extends TinyNode {
        String data;

        @Override
        public Line next() {
            return (Line) super.next();
        }

        @Override
        public Line prev() {
            return (Line) super.prev();
        }
    }

    public static void main(String[] args) {
        // Create an empty list.
        Line list = new Line();

        // Read input until end of file.
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            Line line = new Line();
            line.data = in.nextLine();
            line.insert(list.prev(), list); // append at end
        }

        // Remove empty lines.
        Line current;
        current = list.next();
        while (current != list) {
            Line next = current.next();
            if (current.data.length() == 0) {
                current.remove();
            }
            current = next;
        }

        // Print out the lines in forward and reverse order.
        current = list.next();
        while (current != list) {
            System.out.println(current.data);
            current = current.next();
        }
        current = list.prev();
        while (current != list) {
            System.out.println(current.data);
            current = current.prev();
        }
    }
}
