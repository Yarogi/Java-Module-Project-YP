public class Calculator {

    short participantsQuantity;
    String products = "";
    float cost = 0;

    public Calculator(short participantsQuantity) {
        this.participantsQuantity = participantsQuantity;
    }

    public void addProduct(String productName, float cost) {

        this.cost = this.cost + cost;
        String productRepresentation = productName + " : " + CurrencyFormatter.getCostRepresentation(cost);

        products = products.isEmpty() ? productRepresentation : products + "\n" + productRepresentation;
        System.out.println("Товар успешно добавлен");

    }

    public void calculate() {

        if (this.participantsQuantity < 1) {
            System.out.println("Количество участников не может быть меньше 1");
            return;
        }

        if (products.isEmpty()) {
            System.out.println("Товары отсутствуют!");
            return;
        }

        float result = this.cost / this.participantsQuantity;
        System.out.println(
                //Поправил, сделал правда через формат.
                String.format("Количество участников: %d \nДобавленные товары: \n%s \n-> Итого с человека: %s",
                        this.participantsQuantity,
                        this.products,
                        CurrencyFormatter.getCostRepresentation(result)));

    }

}
