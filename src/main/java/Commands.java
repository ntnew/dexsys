import java.util.Arrays;
import java.util.Collections;

public class Commands  {
    public static void showHelp(){
        System.out.println("init - инициализация списков набором значений array");
        System.out.println("print - печать всех списков");
        System.out.println("print 'type' - печать конкретного списка, где type принимает значения 3, 7 или 21");
        System.out.println("anyMore - выводит на экран были ли значения не вошедшие ни в один список, возможные значения true, false");
        System.out.println("merge - слить все списки в один вывести на экран и очистить все списки");
        System.out.println("clear type - чистка списка , где type принимает значения 3, 7, 21");
        System.out.println("help - вывод справки по командам");
        System.out.println("exit - выход");
    }

    public static void initArray(String array){
        String[] subStr;

        String delimeter = " ";
        subStr = array.split(delimeter);
        Arrays.stream(subStr).forEach(s -> {
            int a = Integer.parseInt(s);
            if(a%3==0) CommandHandler.by3.add(a);
            if(a%7==0) CommandHandler.by7.add(a);
            if(a%21==0) CommandHandler.by21.add(a);
            if(a%3!=0 && a%7!=0 && a%21!=0) CommandHandler.anyMoreNumbers = true;
        });
        Collections.sort(CommandHandler.by3);
        Collections.sort(CommandHandler.by7);
        Collections.sort(CommandHandler.by21);
    }
    public static void merge(){
        CommandHandler.full.addAll(CommandHandler.by3);
        CommandHandler.by3.clear();
        CommandHandler.full.removeAll(CommandHandler.by7);
        CommandHandler.full.addAll(CommandHandler.by7);
        CommandHandler.by7.clear();
        CommandHandler.full.removeAll(CommandHandler.by21);
        CommandHandler.full.addAll(CommandHandler.by21);
        CommandHandler.by21.clear();
        CommandHandler.anyMoreNumbers = false;
        if (CommandHandler.full.isEmpty()) System.out.println("Нечего соеднять, списки пусты.");
        else System.out.println("Все списки в одном" + CommandHandler.full + "\nПроизведено слияние массивов!");

    }
    public static void clearAllArrays(){
        CommandHandler.by3.clear();
        CommandHandler.by7.clear();
        CommandHandler.by21.clear();
    }
}
