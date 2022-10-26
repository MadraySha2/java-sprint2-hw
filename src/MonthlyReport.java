import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyReport {
    HashMap<Integer, ArrayList<MonthItem>> monthsFilesData;
    String[] monthNames = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};

    void makeReport() {
        if (monthsFilesData == null) {
            System.out.println("Сначала надо считать отчет! Это кнопка 1");
            return;
        }
        for (int i = 1; i <= monthsFilesData.size(); i++) {
            ArrayList<MonthItem> dataForReports = monthsFilesData.get(i);
            System.out.println("В месяце: " + monthNames[i - 1]);
            mostProfitExpensiveItem(dataForReports);
            // maxExpensiveItem(dataForReports);
        }
    }

    void mostProfitExpensiveItem(ArrayList<MonthItem> dataForReports) {
        int profit = 0;
        int expense = 0;
        int mostProfitItem;
        int maxExpense;
        String itemName = "";
        for (MonthItem dataForReport : dataForReports) {
            if (!dataForReport.isExpense) {
                mostProfitItem = dataForReport.quantity * dataForReport.sumOfOne;
                if (mostProfitItem > profit) {
                    profit = mostProfitItem;
                    itemName = dataForReport.itemName;
                }
            } else {
                maxExpense = dataForReport.quantity * dataForReport.sumOfOne;
                if (maxExpense > expense) {
                    expense = maxExpense;
                    itemName = dataForReport.itemName;
                }
            }
        }
        System.out.println("Самый прибыльный товар: " + itemName + "." + " Выручка составила: " + profit + "руб.");
        System.out.println("Самая большая трата: " + itemName + " " + expense + "руб.");
    }

    // Здесь так и не придумал, как это в один объединить :(
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
    void readMonthsFiles() {monthsFilesData = MonthsFilesReader.getMonthReportData();
    }


}


