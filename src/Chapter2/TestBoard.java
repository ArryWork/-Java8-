package Chapter2;

/**
 * Created by Arry on 2017/10/16.
 */
public class TestBoard implements CellularAutomata.Board{
    private Integer x;
    private Integer y;

    @Override
    public int getMaxX() {
        return 0;
    }

    @Override
    public int getMaxY() {
        return 0;
    }

    @Override
    public int getValue(int x, int y) {
        return 0;
    }

    @Override
    public int setNewValue(int x, int y, int value) {
        return 0;
    }

    @Override
    public void commitNewValues() {
        System.out.println("commit");
    }

    @Override
    public boolean hasConverged() {
        return true;
    }

    @Override
    public void waitForConvergence() {

    }

    @Override
    public CellularAutomata.Board getSubBoard(int numPartitions, int index) {
        return null;
    }
}
