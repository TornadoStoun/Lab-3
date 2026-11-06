package tri.src;
import java.util.*;

public class Task3 {
    public static List<String> getTopNWords(String text, int n) {
        if (text == null || text.isEmpty() || n <= 0) {
            return new ArrayList<>();
        }

        String cleanedText = text.toLowerCase().replaceAll("[^a-zа-яё\\s]", " ");

        String[] words = cleanedText.trim().split("\\s+");

        Map<String, Integer> wordCounts = new HashMap<>();
        for (String word : words) {
            if (!word.isEmpty()) {
                wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
            }
        }

        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(wordCounts.entrySet());
        sortedEntries.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        List<String> result = new ArrayList<>();
        int limit = Math.min(n, sortedEntries.size());

        for (int i = 0; i < limit; i++) {
            result.add(sortedEntries.get(i).getKey());
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder textBuilder = new StringBuilder();

        String stopSymbol = "#";

        System.out.println("Введите текст (для завершения ввода поставьте символ '" + stopSymbol + "' и нажмите Enter):");

        while (true) {
            String line = scanner.nextLine();
            int stopIndex = line.indexOf(stopSymbol);

            if (stopIndex != -1) {
                textBuilder.append(line, 0, stopIndex);
                break;
            }

            textBuilder.append(line).append(" ");
        }

        System.out.print("Сколько самых частых слов вывести (N)? ");
        int n = scanner.nextInt();

        String fullText = textBuilder.toString();
        List<String> topWords = getTopNWords(fullText, n);

        System.out.println("Топ-" + n + " самых частых слов: " + topWords);
        scanner.close();
    }
}

