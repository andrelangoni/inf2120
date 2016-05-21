public class ExampleAssert {
    public static void main(String[] args) {
        int a = Integer.MAX_VALUE;
        int b = 1;
        int sum = sum(a,b);
        pritnln("Sum = " + String.valueOf(sum));
    } // main()

    // Calculates the sum of a (int) + b (int) and returns the result (int).
    private static int sum(int a, int b) {
        assert (Integer.MAX_VALUE - a >= b) : "Value of " + a + " + " + b + " is too large to add.";
        final int result = a + b;
        assert (result - a == b) : "Sum of " + a + " + " + b + " returned wrong sum " + result;
        return result;
    } // sum()

    private static void pritnln(String s) {
        System.out.println(s);
    } // println()
} // ExampleAssert