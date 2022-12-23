import java.util.Scanner;

public class CalculateDeposit {

    public static void main(String[] args) {
        new CalculateDeposit().doCalculation();
    }

    double calculateComplexPercent(double amount, double yearRate, int period ) {
        double result = amount * Math.pow((1 + yearRate / 12), 12 * period);
        return round(result, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int period) {
        double result = amount + amount * yearRate * period;
        return round(result, 2);
    }

    double round(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void doCalculation( ) {
        int typeOfDeposit ;
        int periodOfDeposit;
        double depositResult = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:") ;
        int amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:") ;
        periodOfDeposit = scanner.nextInt( );

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        typeOfDeposit = scanner.nextInt();

        if (typeOfDeposit == 1) {
            depositResult = calculateSimplePercent(amount, 0.06, periodOfDeposit);
        }
        else if (typeOfDeposit == 2) {
            depositResult = calculateComplexPercent(amount, 0.06, periodOfDeposit);
        }

        System.out.println("Результат вклада: " + amount
                + " за " + periodOfDeposit + " лет превратятся в " + depositResult);
    }
}