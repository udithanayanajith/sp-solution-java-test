public class ProblemOne {

//Sum using a for loop
    public static int sumWithForLoop(int[] numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }

//Sum using a while loop
    public static int sumWithWhileLoop(int[] numbers) {
        int sum = 0;
        int i = 0;
        while (i < numbers.length) {
            sum += numbers[i];
            i++;
        }
        return sum;
    }


    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println("Sum using for loop: " + sumWithForLoop(numbers));
        System.out.println("Sum using while loop: " + sumWithWhileLoop(numbers));
    }
}