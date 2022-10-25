import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyReport {
    MonthReportsData reportBase = new MonthReportsData();
    ArrayList<String> monthsNames = new ArrayList<>();

    void makeReport() {
        HashMap<Integer, ArrayList<MonthItem>> monthReportData = reportBase.getMonthReportData();
        MonthReportsData reportBase = new MonthReportsData();
        for (int i = 1; i <= monthReportData.size(); i++) {
            ArrayList<MonthItem> dataForReports = monthReportData.get(i);
            if (reportBase.monthData == null) {
                System.out.println("Сначала надо считать отчет! Это кнопка 1");
                return;
            } else {
                {
                    System.out.println("В месяце: " + getMonthNames(i));
                    mostProfitItem(dataForReports);
                    maxExpensiveItem(dataForReports);
                }
            }
        }
    }

    void mostProfitItem(ArrayList<MonthItem> dataForReports) {
        int profit = 0;
        int mostProfitItem;
        String mostProfitItemName = "";
        if (dataForReports == null) {
            System.out.println("Сначала надо считать отчет! Это кнопка 1");
            return;
        }
        for (int i = 1; i < dataForReports.size(); i++) {
            if (!dataForReports.get(i).isExpense) {
                mostProfitItem = dataForReports.get(i).quantity * dataForReports.get(i).sumOfOne;
                if (mostProfitItem > profit) {
                    profit = mostProfitItem;
                    mostProfitItemName = dataForReports.get(i).itemName;
                }

            }
        }
        System.out.println("Самый прибыльный товар: " + mostProfitItemName + "." + " Выручка составила: " + profit + "руб.");

    }

    void maxExpensiveItem(ArrayList<MonthItem> dataForReports) {
        int expense = 0;
        int maxExpense;
        String maxExpensiveItemName = "";
        for (MonthItem dataForReport : dataForReports) {
            if (dataForReport.isExpense) {
                maxExpense = dataForReport.quantity * dataForReport.sumOfOne;
                if (maxExpense > expense) {
                    expense = maxExpense;
                    maxExpensiveItemName = dataForReport.itemName;
                }

            }
        }
        System.out.println("Самая большая трата: " + maxExpensiveItemName + " " + expense + "руб.");
    }

    int sumOfMonthExpenses(ArrayList<MonthItem> dataForSums) {
        int sumExpense = 0;
        for (MonthItem dataForSum : dataForSums) {
            if (dataForSum.isExpense) {
                sumExpense += (dataForSum.quantity * dataForSum.sumOfOne);
            }
        }
        return sumExpense;
    }

    int sumOfMonthProfits(ArrayList<MonthItem> dataForSums) {
        int sumProfit = 0;
        for (MonthItem dataForSum : dataForSums) {
            if (!dataForSum.isExpense) {
                sumProfit += (dataForSum.quantity * dataForSum.sumOfOne);
            }
        }
        return sumProfit;
    }

    String getMonthNames(int numberOfMonth) {
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
        return monthsNames.get(numberOfMonth - 1);
    }


}


