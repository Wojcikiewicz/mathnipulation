package document.project.java.math.algebra;

/**
 * A class made to manipulate matrices. The class allow to
 * wrap, transpose and exchange rows and columns.
 *
 * Every manipulation function work with generics. It means that its
 * parameters have to be Classes or Interfaces. To use it with primitive
 * data types you must use the wrap functions.
 *
 * @author Hilson Alexandre Wojcikiewicz Junior
 * @version 0.2.0
 */
public class Matrix {

    //wrap functions

    /**
     * Wrap a primitive data type matrix to a Wrapper Class matrix.
     * @param matrix the primitive data type matrix to be wrapped.
     * @return an wrapped matrix.
     */
    public static Short[][]     wrap (short[][] matrix){
        Short[][] wrapped = new Short[matrix.length][];
        for (int i = 0; i < matrix.length; i++){
            wrapped[i] = new Short[matrix[i].length];
            for (int j = 0; j < matrix[i].length; j ++){
                wrapped[i][j] = matrix[i][j];
            }
        }
        return wrapped;
    }

    public static Integer[][]   wrap (int[][] matrix){
        Integer[][] wrapped = new Integer[matrix.length][];
        for (int i = 0; i < matrix.length; i++){
            wrapped[i] = new Integer[matrix[i].length];
            for (int j = 0; j < matrix[i].length; j ++){
                wrapped[i][j] = matrix[i][j];
            }
        }
        return wrapped;
    }

    public static Long[][]      wrap (long[][] matrix){
        Long[][] wrapped = new Long[matrix.length][];
        for (int i = 0; i < matrix.length; i++){
            wrapped[i] = new Long[matrix[i].length];
            for (int j = 0; j < matrix[i].length; j ++){
                wrapped[i][j] = matrix[i][j];
            }
        }
        return wrapped;
    }

    public static Float[][]     wrap (float[][] matrix){
        Float[][] wrapped = new Float[matrix.length][];
        for (int i = 0; i < matrix.length; i++){
            wrapped[i] = new Float[matrix[i].length];
            for (int j = 0; j < matrix[i].length; j ++){
                wrapped[i][j] = matrix[i][j];
            }
        }
        return wrapped;
    }

    public static Double[][]    wrap (double[][] matrix){
        Double[][] wrapped = new Double[matrix.length][];
        for (int i = 0; i < matrix.length; i++){
            wrapped[i] = new Double[matrix[i].length];
            for (int j = 0; j < matrix[i].length; j ++){
                wrapped[i][j] = matrix[i][j];
            }
        }
        return wrapped;
    }

    public static Character[][] wrap (char[][] matrix){
        Character[][] wrapped = new Character[matrix.length][];
        for (int i = 0; i < matrix.length; i++){
            wrapped[i] = new Character[matrix[i].length];
            for (int j = 0; j < matrix[i].length; j ++){
                wrapped[i][j] = matrix[i][j];
            }
        }
        return wrapped;
    }

    public static Boolean[][]   wrap (boolean[][] matrix){
        Boolean[][] wrapped = new Boolean[matrix.length][];
        for (int i = 0; i < matrix.length; i++){
            wrapped[i] = new Boolean[matrix[i].length];
            for (int j = 0; j < matrix[i].length; j ++){
                wrapped[i][j] = matrix[i][j];
            }
        }
        return wrapped;
    }

    public static Byte[][]      wrap(byte[][] matrix){
        Byte[][] wrapped = new Byte[matrix.length][];
        for (int i = 0; i < matrix.length; i++){
            wrapped[i] = new Byte[matrix[i].length];
            for (int j = 0; j < matrix[i].length; j ++){
                wrapped[i][j] = matrix[i][j];
            }
        }
        return wrapped;
    }

    // manipulation functions

    /**
     * Transpose a matrix
     * @param matrix the matrix to be transposed
     * @return a transposed matrix
     */
    public static Object[][] transpose (Object[][] matrix){
        new Matrix().validateRegularMatrix(matrix);
        int cols = matrix.length;
        int rows = matrix[0].length;
        Object[][] transposed = new Object[rows][cols];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                transposed[i][j] = matrix[j][i];
            }
        }
        return transposed;
    }

    public static <E> E[][] copyMatrix(E[][] matrix){
        E[][] copy = matrix.clone();
        for (int i = 0; i < matrix.length; i++){
            copy[i] = matrix[i].clone();
        }
        return copy;
    }

    public static <E> E[][] exchangeRow (E[][] matrix, int line1, int line2){
        new Matrix().validateRegularMatrix(matrix);
        E[][] exchanged = copyMatrix(matrix);
        exchanged[line1] = matrix[line2].clone();
        exchanged[line2] = matrix[line1].clone();
        return exchanged;
    }

    public static <E> E[][] exchangeColumn (E[][] matrix, int col1, int col2){
        E[][] exchanged = copyMatrix(matrix);
        for (int i = 0; i < matrix.length; i++) {
            exchanged[i][col1] = matrix[i][col2];
            exchanged[i][col2] = matrix[i][col1];
        }
        return exchanged;
    }

    //private functions

    private <E> void validateRegularMatrix (E[][] matrix){
        int length = matrix[0].length;
        for (int i = 1; i < matrix.length; i++){
            if (matrix[i].length != length){
                throw new IllegalArgumentException("__THE ROWS HAVEN'T REGULAR LENGTHS!__");
            }
        }
    }

    private <E> void validateSquareMatrix (E[][] matrix) {
        validateRegularMatrix(matrix);
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (rows != cols) {
            throw new IllegalArgumentException("__THE NUMBER OF ROWS AND COLUMNS AREN'T EQUAL!__");
        }
    }

}
