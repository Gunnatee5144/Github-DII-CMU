import java.util.Scanner;

public class Problem04 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] num = {1, 5, 9, 11, 12, 13, 14, 15, 19, 22};

        System.out.print("Input your number : ");
        int input_num = input.nextInt();
        if (input_num > num[9]) {
        } else {
            for (int x = 0; x < num.length; x++) {
                if (input_num <= num[x]) {
                    for (int j = num.length - 1; j > x; j--) {
                        num[j] = num[j - 1];
                    }

                    num[x] = input_num;
                    break;
                }
            }


            for (int y = 0; y < num.length; y++) {
                if (input_num > num[y] && input_num < num[y+1]) {
                    num[y] = input_num;
                }
            }
        }


        for (int z = 0; z < num.length; z++) {
            System.out.print(num[z] + " ");
        }
    }
}
