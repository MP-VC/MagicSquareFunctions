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

    public static int[][] magicSqrGenerator(int size) {
        int[][] array = new int[size][size];
        if (size % 2 != 0) {
            int yPos = size-1;
            int xPos = (size + 1) / 2-1;
            array[yPos][xPos] = 1;
            for (int i = 1; i < size * size; i++) {
                if (array[(yPos + 1 + size) % size][(xPos + 1 + size) % size] == 0) {
                    yPos = (yPos + 1 + size) % size;
                    xPos = (xPos + 1 + size) % size;
                }
                else {
                    yPos = (yPos - 1 + size) % size;
                }
                array[yPos][xPos] = i+1;
            }
        }
        return array;
    }
}