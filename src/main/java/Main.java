import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

       short participantsQuantity = 0;

       while (participantsQuantity <= 1){

           System.out.println("На скольких человек необходимо разделить счет?");

           if (scanner.hasNextShort()) {
               participantsQuantity = scanner.nextShort();
           }else {
               scanner.next();
           };

           if(participantsQuantity <= 1){
                System.out.println("Количество участников дожно быть число больше 1");
           }
       }

        Calculator calc = new Calculator(participantsQuantity);

        String userDeсision = "";
        String breakDeсision = "Завершить";

        while (!userDeсision.equalsIgnoreCase(breakDeсision)) {

            System.out.println("Введите название товара");
            String product = scanner.next();
            float cost = 0f;
            while (cost <= 0) {
                System.out.println("Введите стоимость");
                if (scanner.hasNextFloat()){
                    cost = scanner.nextFloat();
                }else{scanner.next();}

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
class Calculator{

    short participantsQuantity;
    String products = "";
    float cost = 0;

    public Calculator(short participantsQuantity){
        this.participantsQuantity = participantsQuantity;
    }

    public void addProduct(String productName, float cost){

        this.cost = this.cost + cost;
        String productRepresentation = productName + " : " + CurrencyFormatter.getCostRepresentation(cost);

        products = products.isEmpty() ? productRepresentation : products + "\n" +  productRepresentation;
        System.out.println("Товар успешно добавлен");

    }

    public void calculate(){

        if (this.participantsQuantity < 1){
            System.out.println("Количество участников не может быть меньше 1");
            return;
        }

        if(products.isEmpty()){
            System.out.println("Товары отсутствуют!");
            return;
        }

        float result = this.cost / this.participantsQuantity;
        System.out.println("Количество участников: " + this.participantsQuantity + " \nДобавленные товары: \n" + this.products + "\n-> Итого с человека: " + CurrencyFormatter.getCostRepresentation(result));

    }

}
class CurrencyFormatter{
    public static String getCostRepresentation(float cost){

        String currencyName = "рублeй";

        int iCost = (int) cost % 10;

        if(iCost == 1)
            {currencyName = "рубль";}
        else if (iCost > 1 && iCost < 5)
            {currencyName = "рубля";}

        String result = String.format("%.2f %s", cost, currencyName);

        return result;
    }
}