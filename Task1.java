import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task1{

        public static void main(String[] args){
            List<String>tasks = new ArrayList<>();
            Scanner in = new Scanner(System.in);
            int choice = 0;

            while (choice!=5) {
                System.out.println("1 - добавить задачу");
                System.out.println("2 - удалить первую задачу");
                System.out.println("3 - удалить задачу по номеру");
                System.out.println("4 - показать все задачи");
                System.out.println("5 - выход");
                System.out.println("Выберите команду");
                choice = in.nextInt();
                in.nextLine();

                if (choice == 1) {
                    System.out.println("Введите текст задачи: ");
                    String task = in.nextLine();
                    tasks.add(task);
                }else if (choice == 2) {
                    if (tasks.size() == 0) {
                        System.out.println("Список пуст");
                    } else {
                        tasks.remove(0);
                    }
                }else if (choice == 3) {
                    System.out.println("Введите номер задачи");
                    int number = in.nextInt();
                    in.nextLine();
                    if (number < 1 || number > tasks.size()) {
                        System.out.println("Неверный номер");
                    } else {
                        tasks.remove(number - 1);
                    }
                }else if (choice == 4) {
                    if (tasks.size() == 0) {
                        System.out.println("Список пуст");
                    } else {
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i + 1) + "." + tasks.get(i));
                        }
                    }
                }else if (choice==5){
                    System.out.println("Выход");
                }else{
                    System.out.println("Неверная команда");
                }
            }

            in.close();
        }
}
