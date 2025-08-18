//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        boolean a = true;
        boolean b = false;
        boolean c = true;
        boolean d = false;
        if (a || (b && c)) {
            if (!(b || d)) {
                System.out.println("Condition 1 Met");
            } else if (c && !d) {
                System.out.println("Condition 2 Met");
            } else {
                System.out.println("Condition 3 Met");
            }
            } else {
                if (a && b) {
                    System.out.println("Condition 4 Met");
                } else if (!c || d) {
                    System.out.println("Condition 5 Met");
                } else {
                    System.out.println("Condition 6 Met");
                }
        }
    }
}