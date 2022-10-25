import java.util.Random;

public class MagicBox<T> {
    private int numbers;
    private T[] items;

    public T[] getItems() {
        return items;
    }

    public void setItems(T[] items) {
        this.items = items;
    }

    public MagicBox(int numbers) {
        this.numbers = numbers;
        this.items = (T[]) new Object[numbers];
    }

    public boolean add(T item) {
        boolean itemNullOrNot = false;
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                items[i] = item;
                itemNullOrNot = true;
                break;
            }
        }
        return itemNullOrNot;
    }

    public T pick() throws RuntimeException {
        boolean itemNullOrNot = false;
        int count = 0;
        for (T item : items) {
            if (item == null) {
                itemNullOrNot = true;
                break;
            }
            count++;
        }
        if (itemNullOrNot) {
            throw new RuntimeException("Коробка ещё не полна, осталось заполнить " + (numbers - count) + " ячеек");
        } else {
            Random random = new Random();
            int randomInt = random.nextInt(numbers);
            return items[randomInt];
        }
    }
}
