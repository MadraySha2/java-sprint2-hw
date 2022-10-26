import java.util.ArrayList;
import java.util.HashMap;

public class YearFilesReader {
    static HashMap<String, ArrayList<YearItem>> getYearData() {
        HashMap<String, ArrayList<YearItem>> yearData = new HashMap<>();
        ArrayList<YearItem> yearProfitList = new ArrayList<>();
        ArrayList<YearItem> yearExpenseList = new ArrayList<>();
        ReadFileConnectionOrNull fileReader = new ReadFileConnectionOrNull();
        String path = "resources/y.2021.csv";
        String yearFileContents = fileReader.readFile(path);
        String[] lines = yearFileContents.split(System.lineSeparator());
        for (int j = 1; j < lines.length; j++) {
            String line = lines[j];
            String[] items = line.split(",");
            Integer month = Integer.parseInt(items[0]);
            Integer amount = Integer.parseInt(items[1]);
            Boolean isExpense = Boolean.parseBoolean(items[2]);
            YearItem yearItem = new YearItem(month, amount, isExpense);
            if (isExpense) {
                yearExpenseList.add(yearItem);
                yearData.put("expenses", yearExpenseList);
            } else {
                yearProfitList.add(yearItem);
                yearData.put("profits", yearProfitList);
            }
        }
        System.out.println("Годовой отчет считан!");
        return yearData;
    }

}
