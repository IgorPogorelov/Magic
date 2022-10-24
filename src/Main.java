import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Привет! На сколько ячеек создать коробку?");
        int sizeBox = scanner.nextInt();

        MagicBox<Integer> box = new MagicBox<>(sizeBox);

        while (true) {
            System.out.println("Выбери действие: 1. Положить число в коробку 2. Выбрать случайное число");
            int action = scanner.nextInt();
            if (action == 1) {
                System.out.println("Какое число ложим в коробку?");
                int numberForBox = scanner.nextInt();
                if (box.add(numberForBox)) {
                    continue;
                }
                System.out.println("Коробка полная");
            } else if (action == 2) {
                System.out.println(box.pick());
                break;
            }
        }
    }
}
