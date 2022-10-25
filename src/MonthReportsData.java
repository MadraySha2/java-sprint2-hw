import java.util.ArrayList;
import java.util.HashMap;

class MonthReportsData {
    HashMap<Integer, ArrayList<MonthItem>> monthData = new HashMap<>();
    HashMap<Integer, ArrayList<MonthItem>> getMonthReportData() {
        for (int i = 1; i <= 12; i++) {
            ArrayList<MonthItem> itemsList = new ArrayList<>();
            ReadFileConnectionOrNull fileReader = new ReadFileConnectionOrNull();
            String path = "resources/m.20210" + i + ".csv";
            String fileContents = fileReader.readFileConnectionOrNull(path);
            if (fileContents == null) {
                System.out.println("Обработанно и сохраненно: " + (monthData.size()) + " отчетов");
                return monthData;
            } else {
                String[] lines = fileContents.split(System.lineSeparator());

                for (int j = 1; j < lines.length; j++) {
                    String line = lines[j];
                    String[] items = line.split(",");
                    String itemName = items[0];
                    Boolean isExpense = Boolean.parseBoolean(items[1]);
                    Integer quantity = Integer.parseInt(items[2]);
                    Integer sumOfOne = Integer.parseInt(items[3]);
                    MonthItem item = new MonthItem(itemName, isExpense, quantity, sumOfOne);
                    itemsList.add(item);
                }
                monthData.put(i, itemsList);

            }
        }
        System.out.println("Обработанно и сохраненно: " + (monthData.size()) + " отчетов");
        return monthData;
    }
}






