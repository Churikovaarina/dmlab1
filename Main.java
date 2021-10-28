import java.util.Arrays;
import java.util.Scanner;

public class lab1dm {
    public static void main(String[] args) {
        int[] U = {1, 2, 3, 4, 5, 6, 7, 8};
        final int[] a = input();
        final int[] b = input();


        final String a_binaryStr = decimalToBinaryConverter(U, a);
        final String b_binaryStr = decimalToBinaryConverter(U, b);


        final int[] a_binaryArr = stringToIntArr(a_binaryStr);
        final int[] b_binaryArr = stringToIntArr(b_binaryStr);

        final String and = and(a_binaryArr, b_binaryArr);
        final String not1 = not(a_binaryArr);
        final String not2 = not(b_binaryArr);
        final String or = or(a_binaryArr, b_binaryArr);
        final String xor = xor(a_binaryArr, b_binaryArr);

        final int[] and_binarySet = stringToIntArr(and);
        final int[] or_binarySet = stringToIntArr(or);
        final int[] xor_binarySet = stringToIntArr(xor);
        final int[] not1_binarySet = stringToIntArr(not1);
        final int[] not2_binarySet = stringToIntArr(not2);

        final String andSet = Arrays.toString((binaryToDecimalConverter(U, and_binarySet).toCharArray()));
        final String orSet = Arrays.toString((binaryToDecimalConverter(U, or_binarySet).toCharArray()));
        final String xorSet = Arrays.toString((binaryToDecimalConverter(U, xor_binarySet).toCharArray()));
        final String not1Set = Arrays.toString((binaryToDecimalConverter(U, not1_binarySet).toCharArray()));
        final String not2Set = Arrays.toString((binaryToDecimalConverter(U, not2_binarySet).toCharArray()));


        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        checkEquality(a, b);
        System.out.println("Множина А у вигляді бітового рядка: " + a_binaryStr);
        System.out.println("Множина B у вигляді бітового рядка: " + b_binaryStr);
        System.out.println("Перетин(AND): " + and);
        System.out.println("Перетин(AND) у стандартному вигляді: " + andSet);
        System.out.println("Об'єднання(OR): " + or);
        System.out.println("Об'єднання(OR) у стандартному вигляді: " + orSet);
        System.out.println("Симетрична різниця(XOR): " + xor);
        System.out.println("Симетрична різниця(XOR) у стандартному вигляді: " + xorSet);
        System.out.println("Різниця A-B (NOT): " + not1);
        System.out.println("Різниця A-B (NOT) у стандартному вигляді: " + not1Set);
        System.out.println("Різниця B-A (NOT): " + not2);
        System.out.println("Різниця B-A (NOT) у стандартному вигляді: " + not2Set);


    }

    public static int[] input() {
        Scanner input = new Scanner(System.in);

        System.out.println("введіть кількість елементів масиву:");

        int num = input.nextInt();
        int arr[] = new int[num];
        System.out.println("введіть елементи масиву:");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = input.nextInt();

        }
        return arr;
    }

    public static void checkEquality(int[] a, int[] b) {
        int k = 0;
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (b[i] == a[j]) {
                    k++;
                }
            }

        }
        if ((a.length == b.length) & (k == a.length)) {
            System.out.println("A та B рівні множини");
        } else if (k == a.length & (a.length != b.length)) {
            System.out.println("A є підмножиною B");
        } else {
            System.out.println("А не є підмножиною B, множини не є рівними");
        }
    }

    public static String decimalToBinaryConverter(int[] universalSet, int[] set) {
        Arrays.sort(universalSet);
        Arrays.sort(set);

        StringBuilder result = new StringBuilder();
        int j = 0;

        for (int i : universalSet) {
            if (j < set.length && i == set[j]) {
                result.append("1");
                j++;
            } else {
                result.append("0");
            }
        }

        return result.toString();
    }

    public static String binaryToDecimalConverter(int[] universalSet, int[] binarySet) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < binarySet.length; i++) {
            if (binarySet[i] == 1) {
                builder.append(universalSet[i]);
            }

        }

        return builder.toString();
    }

    public static int[] stringToIntArr(String str) {
        int[] numArr = Arrays.stream(str.split("")).mapToInt(Integer::parseInt).toArray();
        return numArr;
    }

    public static String not(int[] arr_binary) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < arr_binary.length; i++) {
            if (arr_binary[i] == 1) {
                builder.append(0);
            } else {
                builder.append(1);
            }
        }
        return builder.toString();
    }

    public static String or(int[] arr_binary1, int[] arr_binary2) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < arr_binary1.length; i++) {
            if (arr_binary1[i] == arr_binary2[i]) {
                if (arr_binary1[i] == 1) builder.append(1);
                else builder.append(0);
            } else {
                builder.append(1);
            }
        }
        return builder.toString();
    }

    public static String xor(int[] arr_binary1, int[] arr_binary2) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < arr_binary1.length; i++) {
            if (arr_binary1[i] == arr_binary2[i]) {
                builder.append(0);
            } else {
                builder.append(1);
            }
        }
        return builder.toString();
    }

    public static String and(int[] arr_binary1, int[] arr_binary2) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < arr_binary1.length; i++) {
            if (arr_binary1[i] == arr_binary2[i]) {
                if (arr_binary1[i] == 0) {
                    builder.append(0);
                } else builder.append(1);
            } else {
                builder.append(0);
            }
        }
        return builder.toString();
    }


}
