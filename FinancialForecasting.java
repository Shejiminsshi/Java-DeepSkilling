import java.util.HashMap;
import java.util.Map;
public class FinancialForecasting {
    public static double predictFutureValue(double currentValue, double growthRate, int years) {
        if (years == 0) return currentValue;
        return (1 + growthRate) * predictFutureValue(currentValue, growthRate, years - 1);
    }

    public static double predictFutureValueMemo(double currentValue, double growthRate, int years, Map<Integer, Double> memo) {
        if (years == 0) return currentValue;
        if (memo.containsKey(years)) return memo.get(years);
        double result = (1 + growthRate) * predictFutureValueMemo(currentValue, growthRate, years - 1, memo);
        memo.put(years, result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println("\n=== Exercise 7: Financial Forecasting ===");

        double currentValue = 10000;
        double growthRate = 0.05;
        int years = 5;
        double result1 = predictFutureValue(currentValue, growthRate, years);
        System.out.printf("Future Value (Recursive): %.2f\n", result1);

        Map<Integer, Double> memo = new HashMap<>();
        double result2 = predictFutureValueMemo(currentValue, growthRate, years, memo);
        System.out.printf("Future Value (Memoized): %.2f\n", result2);
    }
}
