/**
 * Created by Arry on 2017/8/31.
 */
public enum  Enume {
    UNLOCK(20,"锁定"),
    LOCK(30,"开启");

    Enume(int key,String value) {

    }

    private  String value;
    private int key;
    @Override
    public String toString() {
        return super.toString();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}
