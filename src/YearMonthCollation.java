import java.util.ArrayList;
import java.util.HashMap;

public class YearMonthCollation {
    MonthReportsData reportBase = new MonthReportsData();
    YearReportData yearReportData = new YearReportData();
    ArrayList<String> monthsNames = new ArrayList<>();
    MonthlyReport monthlyReport = new MonthlyReport();

    void getCollationReport() {
        HashMap<Integer, ArrayList<MonthItem>> monthReportData = reportBase.getMonthReportData();
        HashMap<String, ArrayList<YearItem>> yearReport = yearReportData.getYearData();
        ArrayList<YearItem> yearProfitsList = yearReport.get("profits");
        ArrayList<YearItem> yearExpensesList = yearReport.get("expenses");
        for (int i = 1; i <= monthReportData.size(); i++) {
            ArrayList<MonthItem> dataForSumExpProf = monthReportData.get(i);
            if (yearProfitsList.get(i - 1).amount != monthlyReport.sumOfMonthProfits(dataForSumExpProf) ||
                    yearExpensesList.get(i - 1).amount != monthlyReport.sumOfMonthExpenses(dataForSumExpProf)) {
                System.out.println("Ошибка! Месяц " + getMonthNames(i) + " не сходится с годовым отчетом!");
                return;
            } else {
                System.out.println("Все в норме! Отчет за " + getMonthNames(i) + " сходится с годовым! Возьмите с полки пирожок :)");
            }

        }

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
