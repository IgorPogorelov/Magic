import java.util.Random;

public class MagicBox<T> {
    private int numbers;
    T[] items;

    public MagicBox (int numbers) {
        this.numbers = numbers;
        this.items = (T[]) new Object[numbers];
    }

    public boolean add(T item) {
        boolean x = false;
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                items[i] = item;
                x = true;
                break;
            }
        }
        return x;
    } 
    
    public T pick() throws RuntimeException{
        boolean y = false;
        int count = 0;
        for (T item : items) {
            if (item == null) {
                y = true;
                break;
            }
            count++;
        }
            if (y) {
                throw new RuntimeException("Коробка ещё не полна, осталось заполнить " + (numbers - count) + " ячеек");
            } else {
                Random random = new Random();
                int randomInt = random.nextInt(numbers);
                return items[randomInt];
            }
    }
}
