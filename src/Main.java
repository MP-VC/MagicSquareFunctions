import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[][] array = new int[][]{
                {4, 9, 2},
                {3, 5, 7},
                {8, 1, 6}};
        System.out.println(Util.magicSqrChecker(array));
        System.out.println(Arrays.deepToString(Util.magicSqrGenerator(5)));
    }
}