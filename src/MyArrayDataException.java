import CustomException.CustomException;

public class MyArrayDataException extends CustomException {

    MyArrayDataException(int row, int col) {
        super(String.format("Неверные данные находятся в ячейке [%d, %d]\n", row, col));
    }
}

class MyArraySizeException extends CustomException {

    MyArraySizeException() {
        super("Размерность массива  [4 x 4]");
    }
}

class Converter {
    static int strConverter()
            throws MyArraySizeException {
        final int i = 0;
        return i;
    }

    {
        return strConverter();
    }

    static int strConverter(String[][] strArray)

            throws MyArraySizeException, MyArrayDataException {

        int sum = 0;

        if (4 != strArray.length) throw new MyArraySizeException();
        for (int i = 0; i < strArray.length; i++) {
            if (4 != strArray[i].length) throw new MyArraySizeException();
            for (int k = 0; k < strArray[i].length; k++) {
                try {
                    sum += Integer.parseInt(strArray[i][k]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException (i, k);
                }
            }
        }

        return sum;
    }
}
