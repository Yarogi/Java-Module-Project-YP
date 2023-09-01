public class CurrencyFormatter {
    public static String getCostRepresentation(float cost) {

        String currencyName = "рублeй";

        int iCost = (int) cost % 100;

        if (iCost < 5 || iCost > 20) {

            iCost = iCost % 10;
            if (iCost == 1) {
                currencyName = "рубль";
            } else if (iCost > 1 && iCost < 5) {
                currencyName = "рубля";
            }

        }

        String result = String.format("%.2f %s", cost, currencyName);

        return result;
    }
}