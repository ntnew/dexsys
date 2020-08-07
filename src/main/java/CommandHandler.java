
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CommandHandler {
    public static ArrayList<Integer> by3 = new ArrayList<>();
    public static ArrayList<Integer> by7 = new ArrayList<>();
    public static ArrayList<Integer> by21 = new ArrayList<>();
    public static ArrayList<Integer> full = new ArrayList<>();
    public static boolean anyMoreNumbers = false;


    public static void commandHandler(String command) throws IOException {
        command = command.toLowerCase();
        switch (command) {
            case "exit":
                System.out.println("спасибо за пользование");
                System.exit(0);
            case "init":
                boolean flag = true;
                while (flag) {
                    Commands.clearAllArrays();
                    flag = false;
                    System.out.println("Введите набор чисел:");
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                    String array = bufferedReader.readLine();
                    try {
                        Commands.initArray(array);
                    } catch (NumberFormatException e) {
                        System.out.println("Введён неверный формат массива. Должно быть, например, так: 3 5 7 23423 -894");
                        flag = true;
                        System.out.println("Попробуйте ещё раз!");
                    }
                }
                System.out.println("Массивы сформированы");
                break;
            case "help":
                Commands.showHelp();
                break;
            case "merge":
                Commands.merge();
                System.out.println("Произведено слияние массивов!");
                break;
            case "print":
                if (by3.isEmpty()) System.out.println("Список деления на 3 пуст");
                else System.out.println("Числа, которые можно поделить на 3 без остатка" + by3);
                if (by7.isEmpty()) System.out.println("Список деления на 7 пуст");
                else System.out.println("Числа, которые можно поделить на 7 без остатка" + by7);
                if (by21.isEmpty()) System.out.println("Список деления на 21 пуст");
                else System.out.println("Числа, которые можно поделить на 21 без остатка" + by21);
                break;
            case "print 3":
                if (by3.isEmpty()) System.out.println("Список деления на 3 пуст");
                else System.out.println("Числа, которые можно поделить на 3 без остатка" + by3);
                break;
            case "print 7":
                if (by7.isEmpty()) System.out.println("Список деления на 7 пуст");
                else System.out.println("Числа, котоiniрые можно поделить на 7 без остатка" + by7);
                break;
            case "print 21":
                if (by21.isEmpty()) System.out.println("Список деления на 21 пуст");
                else System.out.println("Числа, которые можно поделить на 21 без остатка" + by21);
                break;
            case "anymore":
                if (anyMoreNumbers) System.out.println("Были числа не вошедшие в список");
                else System.out.println("Чисел, не вошедших ни в один список, не было");
                break;
            case "clear 3":
                by3.clear();
                System.out.println("Список чисел, делящихся на 3, очищен.");
                break;
            case "clear 7":
                by7.clear();
                System.out.println("Список чисел, делящихся на 7, очищен.");
                break;
            case "clear 21":
                by21.clear();
                System.out.println("Список чисел, делящихся на 21, очищен.");
                break;
            default:
                System.out.println("Неизвестная команда");
                break;
        }
    }
}
