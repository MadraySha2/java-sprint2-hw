import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MonthlyReport monthlyReport = new MonthlyReport();
        MonthReportsData monthReportsData = new MonthReportsData();
        YearReportData yearReportData = new YearReportData();
        YearReport yearReport = new YearReport();
        YearMonthCollation yearMonthCollation = new YearMonthCollation();

        while (true) {
            printMenu();
            int command = scanner.nextInt();
            if (command == 1) {
                monthReportsData.getMonthReportData();
            } else if (command == 2) {
                yearReportData.getYearData();
            } else if (command == 3) {
                monthlyReport.makeReport();
            } else if (command == 4) {
                yearReport.makeYearReport();
            } else if (command == 5) {
                yearMonthCollation.getCollationReport();
            } else if (command == 1111) {
                System.out.println("Выход");
                break;
            } else {
                System.out.println("Введена некорректная команда, либо неправильный пин!");
            }

        }


    }

    static void printMenu() {
        System.out.println("Какую операцию Вы хотите провести? ");
        System.out.println("1. Считать месячный отчет");
        System.out.println("2. Считать годовой отчет");
        System.out.println("3. Отчет по месяцам");
        System.out.println("4. Отчет за год");
        System.out.println("5. Провести сверку");
        System.out.println("Введите пин-код, чтобь выйти.");

    }

}