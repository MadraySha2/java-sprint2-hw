import java.util.ArrayList;
import java.util.HashMap;

public class YearReport {
ArrayList<String> monthsNames = new ArrayList<>();
    void makeYearReport() {
        YearReportData yearReportData = new YearReportData();
        HashMap<String, ArrayList<YearItem>> yearReport = yearReportData.getYearData();
        ArrayList<YearItem> yearProfitsList = yearReport.get("profits");
        ArrayList<YearItem> yearExpensesList = yearReport.get("expenses");
        int year = 2021;
            if (yearReport == null) {
                System.out.println("Сначала надо считать отчет! Это кнопка 2");
                return;
            }
        System.out.println("В " + year + " году:");
        accountProfitAndExpenses (yearProfitsList, yearExpensesList);
        averageExpenses(yearExpensesList);
        averageProfit(yearProfitsList);
    }


    void accountProfitAndExpenses (ArrayList<YearItem> profits, ArrayList<YearItem> expenses) {
        for (int i = 0; i < profits.size(); i++) {
            int pureProfit = profits.get(i).amount - expenses.get(i).amount;
            System.out.println("В месяце: " + getMonthNames(i) + " Чистая прибыль составила: " + pureProfit + " руб.");
            }

        }
        void averageExpenses (ArrayList<YearItem> expenses) {
        float averageExpense = 0;
            for (YearItem expens : expenses) {
                averageExpense += expens.amount;
            }
         averageExpense = averageExpense / expenses.size();
        System.out.println("Средний расход за год: " + averageExpense + " руб.");
        }

        void averageProfit(ArrayList<YearItem> profits) {
            float averageProfit = 0;
            for (YearItem profit : profits) {
                averageProfit += profit.amount;
            }
            averageProfit = averageProfit / profits.size();
            System.out.println("Средний доход за год: " + averageProfit + " руб.");
        }

    String getMonthNames (int numberOfMonth) {
        monthsNames.add("Январь");
        monthsNames.add("Февраль");
        monthsNames.add("Март");
        monthsNames.add("Апрель");
        monthsNames.add("Май");
        monthsNames.add("Июнь");
        monthsNames.add("Июль");
        monthsNames.add("Август");
        monthsNames.add("Сентябрь");
        monthsNames.add("Октябрь");
        monthsNames.add("Ноябрь");
        monthsNames.add("Декабрь");
        return monthsNames.get(numberOfMonth);
    }

}
