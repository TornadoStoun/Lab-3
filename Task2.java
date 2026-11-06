import java.util.*;

public class Task2 {
    public static List<List<String>> groupAnagrams(List<String> words) {
        Map<String, List<String>> groups = new LinkedHashMap<>();

        for (String word : words) {
            char[] letters = word.toCharArray();
            for (int i = 0; i < letters.length - 1; i++) {
                for (int j = 0; j < letters.length - 1 - i; j++) {
                    if (letters[j] > letters[j + 1]) {
                        char temp = letters[j];
                        letters[j] = letters[j + 1];
                        letters[j + 1] = temp;
                    }
                }
            }
            String key = new String(letters);

            if (!groups.containsKey(key)) {
                groups.put(key, new ArrayList<>());
            }
            groups.get(key).add(word);
        }

        List<List<String>> result = new ArrayList<>();
        for (List<String> group : groups.values()) {
            result.add(group);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> input = new ArrayList<>();

        String stopCommand = "0";

        System.out.println("Вводите слова по одному (введите " + stopCommand + ", чтобы завершить):");

        while (true) {
            String word = scanner.next();

            if (word.equals(stopCommand)) {
                break;
            }

            input.add(word);
        }

        List<List<String>> result = groupAnagrams(input);
        System.out.println("Результат группировки: " + result);

        scanner.close();
    }
}