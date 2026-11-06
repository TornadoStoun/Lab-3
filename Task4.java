package tri.src;
import java.util.ArrayList;
import java.util.List;


public class Task4 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(List.of(4, 2, 4, 8, 2, 15, 7, 4, 8, 1));

        System.out.println("1. Исходный список: " + numbers);

        List<Integer> uniqueNumbers = new ArrayList<>();
        for (Integer num : numbers) {
            if (!uniqueNumbers.contains(num)) {
                uniqueNumbers.add(num);
            }
        }

        System.out.println("3. Список уникальных элементов: " + uniqueNumbers);

        System.out.println("4. Количество повторений:");
        for (Integer unique : uniqueNumbers) {
            int count = 0;
            for (Integer num : numbers) {
                if (num.equals(unique)) {
                    count++;
                }
            }
            System.out.println(unique + " - " + count + " раза");
        }

        int max = numbers.get(0);
        int min = numbers.get(0);

        for (int i = 1; i < numbers.size(); i++) {
            int current = numbers.get(i);
            if (current > max) {
                max = current;
            }
            if (current < min) {
                min = current;
            }
        }
        System.out.println("5. Максимальный элемент: " + max + ", Минимальный элемент: " + min);

        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        double average = (double) sum / numbers.size();
        System.out.println("6. Сумма элементов: " + sum + ", Среднее арифметическое: " + average);
    }
}
