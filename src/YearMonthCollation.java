import java.util.ArrayList;
import java.util.HashMap;

public class YearMonthCollation {
    MonthlyReport monthlyReport = new MonthlyReport();
    String[] monthNames = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};

    void getCollationReport(HashMap<Integer, ArrayList<MonthItem>> monthsFilesData, HashMap<String, ArrayList<YearItem>> yearFilesData) {
        if (yearFilesData == null) {
            System.out.println("Сначала надо считать отчеты! Это кнопка 1 для месячного отчета и кнопка 2 для годового");
            return;
        } else if (monthsFilesData == null) {
            System.out.println("Сначала надо считать отчеты! Это кнопка 1 для месячного отчета и кнопка 2 для годового111111");
            return;
        }
        ArrayList<YearItem> yearProfitsList = yearFilesData.get("profits");
        ArrayList<YearItem> yearExpensesList = yearFilesData.get("expenses");
        for (int i = 1; i <= monthsFilesData.size(); i++) {
            ArrayList<MonthItem> dataForSums = monthsFilesData.get(i);
            if (yearProfitsList.get(i - 1).amount != monthlyReport.sumOfMonthProfits(dataForSums) ||
                    yearExpensesList.get(i - 1).amount != monthlyReport.sumOfMonthExpenses(dataForSums)) {
                System.out.println("Ошибка! Месяц " + monthNames[i - 1] + " не сходится с годовым отчетом!");
                return;
            } else {
                System.out.println("Все в норме! Отчет за " + monthNames[i - 1] + " сходится с годовым! Возьмите с полки пирожок :)");
            }
        }
    }
}

