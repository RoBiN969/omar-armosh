import java.util.ArrayList;

/**
 * SharedData is a shared resource class used by multiple threads.
 * It contains an array of integers, a target value, and synchronization variables 
 * to communicate between threads.
 */
public class SharedData {
    /**
     * The array of integers to be processed.
     */
    private ArrayList<Integer> array;

    /**
     * Tracks which elements in the array contribute to the solution.
     */
    private boolean[] winArray;

    /**
     * A flag indicating whether a solution has been found.
     */
    private boolean flag;

    /**
     * The target value to check for the subset sum.
     */
    private final int b;

    /**
     * Constructs a SharedData object with the given array and target value.
     *
     * @param array The array of integers to be shared among threads.
     * @param b     The target value for the subset sum computation.
     */
    public SharedData(ArrayList<Integer> array, int b) {
        this.array = array;
        this.b = b;
    }

    /**
     * Retrieves the winArray, which tracks elements contributing to the solution.
     *
     * @return A boolean array indicating the solution subset.
     */
    public boolean[] getWinArray() {
        return winArray;
    }

    /**
     * Updates the winArray to reflect the solution subset.
     *
     * @param winArray A boolean array indicating the solution subset.
     */
    public void setWinArray(boolean[] winArray) {
        this.winArray = winArray;
    }

    /**
     * Retrieves the array of integers.
     *
     * @return The array of integers being processed.
     */
    public ArrayList<Integer> getArray() {
        return array;
    }

    /**
     * Retrieves the target value for the subset sum computation.
     *
     * @return The target value.
     */
    public int getB() {
        return b;
    }

    /**
     * Retrieves the flag indicating whether a solution has been found.
     *
     * @return True if a solution has been found, false otherwise.
     */
    public boolean getFlag() {
        return flag;
    }

    /**
     * Updates the flag to indicate whether a solution has been found.
     *
     * @param flag True if a solution is found, false otherwise.
     */
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}