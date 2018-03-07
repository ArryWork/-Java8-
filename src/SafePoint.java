import java.awt.*;

/**
 * Created by Arry on 2017/9/7.
 */
public class SafePoint {
    private int x;
    private int y;

    private SafePoint(int[] x) {
        this(x[0],x[1]);
    }

    public SafePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public SafePoint(SafePoint safePoint) {
        this(safePoint.get());
    }

    public int[] get(){
        return new int[]{x,y};
    }
    public synchronized void set(int x,int y){
        this.x=x;
        this.y=y;
    }
}
