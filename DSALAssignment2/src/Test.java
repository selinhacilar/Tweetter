import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        String a[] = {"Baltimore", "Rome", "Seattle", "Toronto"};

        String newArray[] = new String[a.length - 1];

        for (int i = 1; i<a.length; i++) {

            newArray[i - 1] = a[i];

        }
        System.out.println(Arrays.toString(newArray));

    }
}
