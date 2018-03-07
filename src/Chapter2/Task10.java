package Chapter2;

import java.util.stream.Stream;

/**
 * Created by Arry on 2017/9/1.
 */
public class Task10 {
    class Item {
        private int count;
        private double sum;
        public Item() {
            count = 0;
            sum = 0;
        }
        public Item add(double num) {
            count++;
            sum += num;
            return this;
        }
        public Item add(Item num) {
            count += num.count;
            sum += num.sum;
            return this;
        }
        public double getAverage() {
            return sum / count;
        }
    }
    public void task10() {
        Stream<Double> doubleStream = Stream.of(1.2, 2.3, 3.4, 4.5, 5.6);
        System.out.println(mean(doubleStream));//3.4
    }

    private double mean(Stream<Double> stream) {
        return stream.reduce(new Item(), Item::add, Item::add).getAverage();
    }

    public static void main(String[] args) {
        new Task10().task10();
    }
}
