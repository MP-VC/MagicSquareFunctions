public class Util {
    public static boolean magicSqrChecker(int[][] arg) {
        int sumMainDiagonal = 0;
        int sumAntiDiagonal = 0;
        int sumSavedH = 0;
        int sumSavedV = 0;
        boolean firstRun = true;
        boolean isMagic = true;
        //horizontal and vertical check
        for (int i = 0; i < arg.length && isMagic; i++) {
            int sumCurrentH = 0;
            int sumCurrentV = 0;
            for (int j = 0; j < arg.length; j++) {
                sumCurrentH += arg[i][j];
                sumCurrentV += arg[j][i];
            }
            if (firstRun) {
                sumSavedH = sumCurrentH;
                sumSavedV = sumCurrentV;
                firstRun = false;
            } else {
                if (sumSavedH != sumCurrentH) isMagic = false;
                if (sumSavedV != sumCurrentV) isMagic = false;
                sumSavedH = sumCurrentH;
                sumSavedV = sumCurrentV;
            }
        }

        //main-diagonal and anti-diagonal check
        for (int k = 0; k < arg.length && isMagic; k++) {
            sumMainDiagonal += arg[k][k];
            sumAntiDiagonal += arg[k][arg.length - 1 - k];
        }
        if (sumMainDiagonal != sumSavedH && sumAntiDiagonal != sumSavedH) isMagic = false;
        return isMagic;
    }

    public static int[][] magicSqrGenerator(int odd) {
        int[][] array = new int[odd][odd];
        if (odd % 2 != 0) {
            int xPos = array.length-1;
            int yPos = (array.length + 1) / 2-1;
            array[xPos][yPos] = 1;
            System.out.println(xPos + " " + yPos );
            for (int i = 0; i < array.length * array.length; i++) {
                if (array[xPos][yPos] != 0) {
                    xPos = (xPos + 1 + array.length) % array.length;
                    yPos = (yPos + 1 + array.length) % array.length;
                    System.out.println(xPos + " " + yPos +" "+i);
                }
                else {
                    yPos--;
                    System.out.println(xPos + " " + yPos +" "+i);
                }
                array[xPos][yPos] = i+1;
            }
        }
        return array;
    }
}