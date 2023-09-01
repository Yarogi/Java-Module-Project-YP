import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        short participantsQuantity = 0;
        String breakDeсision = "Завершить";

        while (participantsQuantity <= 1) {

            System.out.println("На скольких человек необходимо разделить счет?");

            if (scanner.hasNextShort()) {
                participantsQuantity = scanner.nextShort();
            } else {
                scanner.next();
            }

            if (participantsQuantity <= 1) {
                System.out.println("Количество участников дожно быть число больше 1");
            }
        }

        Calculator calc = new Calculator(participantsQuantity);

        String userDeсision = "";

        while (!userDeсision.equalsIgnoreCase(breakDeсision)) {

            System.out.println("Введите название товара (руб,коп)");
            String product = scanner.next();
            float cost = 0f;
            while (cost <= 0) {
                System.out.println("Введите стоимость");
                if (scanner.hasNextFloat()) {
                    cost = scanner.nextFloat();
                } else {
                    scanner.next();
                }

                if (cost <= 0) {
                    System.out.println("Сmоимость товара должно быть число больше нуля!");
                }
            }
            calc.addProduct(product, cost);

            System.out.println("Добавить ещё один товар? (Если это всё, введите \"" + breakDeсision + "\")");
            userDeсision = scanner.next();

        }

        calc.calculate();

    }

}
