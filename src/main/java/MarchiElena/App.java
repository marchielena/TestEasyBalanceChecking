package MarchiElena;

import java.util.Locale;

public class App {
    public static void main(String[] args) {
        String x = "1000.00\n" +
                "125 Market 125.45\n" +
                "126 Hardware 34.95\n" +
                "127 Video 7.45\n" +
                "128 Book 14.32\n" +
                "129 Gasoline 16.10";
        System.out.println(balance(x));
    }

    public static String balance(String book) {
        String t = book.replaceAll("([^\n. \\da-zA-Z])", "");
        String[] arr = t.split("[\n]+");
        double current = Double.parseDouble(arr[0]);
        double total = 0;
        int count = 0;
        StringBuilder result = new StringBuilder();
        result.append("Original Balance: " + arr[0]);
        for (int i = 1; i < arr.length; i++) {
            count++;
            String[] line = arr[i].split("[ ]+");
            current -= Double.parseDouble(line[2]);
            total += Double.parseDouble(line[2]);
            String u = String.format(Locale.US, "\r\n" + "%s %s %s Balance %.2f", line[0], line[1], line[2], current);
            result.append(u);
        }
        result.append(String.format(Locale.US,"\r\n" + "Total expense  %.2f" + "\r\n" + "Average expense  %.2f", total, total / count));
        return result.toString();
    }
}
