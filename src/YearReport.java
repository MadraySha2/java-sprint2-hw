import java.util.ArrayList;
import java.util.HashMap;

public class YearReport {
    HashMap<String, ArrayList<YearItem>> yearFilesData;
    String[] monthNames = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};

    void makeYearReport() {
        if (yearFilesData == null) {
            System.out.println("Сначала надо считать отчет! Это кнопка 2");
            return;
        }
        ArrayList<YearItem> yearProfitsList = yearFilesData.get("profits");
        ArrayList<YearItem> yearExpensesList = yearFilesData.get("expenses");
        int year = 2021;
        System.out.println("В " + year + " году:");
        accountProfitAndExpenses(yearProfitsList, yearExpensesList);
        averageExpenses(yearExpensesList);
        averageProfit(yearProfitsList);
    }


    void accountProfitAndExpenses(ArrayList<YearItem> profits, ArrayList<YearItem> expenses) {
        for (int i = 0; i < profits.size(); i++) {
            int pureProfit = profits.get(i).amount - expenses.get(i).amount;
            System.out.println("В месяце: " + monthNames[i] + " Чистая прибыль составила: " + pureProfit + " руб.");
        }

    }

    void averageExpenses(ArrayList<YearItem> expenses) {
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

    void readYearFiles() {
        yearFilesData = YearFilesReader.getYearData();
    }
}
