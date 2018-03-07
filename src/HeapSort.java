public class HeapSort {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++){

            try {
                throw new Exception("test");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
