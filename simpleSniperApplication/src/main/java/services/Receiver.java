package services;

import commands.Command;
import io.ConsoleReader;
import resources.Point;

import java.util.Map;
import java.util.TreeMap;

public class Receiver {

    ConsoleReader input;


    public Receiver() {
        input = new ConsoleReader();
    }

    public void help(TreeMap<String, Command> commandTreeMap) {
        System.out.println(System.lineSeparator() + "СПРАВКА ПО КОМАНДАМ:" + System.lineSeparator());
        for (Map.Entry<String, Command> entry : commandTreeMap.entrySet()) {
            System.out.println((entry.getKey() + " -" + entry.getValue().getArgs() + " " + entry.getValue().getDescription()));
        }
        System.out.println((System.lineSeparator() + "*: команда 'shot' имеет 3 аргумента X Y R " + System.lineSeparator() +
                "*: пример: shot 3 2 5"));
    }

    public void add(PointsHandler handler, Point point) {
        handler.add(point);
    }

    public void history(PointsHandler handler) {
        handler.show();
    }

    public void exit() {
        System.out.println("          ／＞　 フ \n" +
                "　　　　　| 　о　 _| \n" +
                "　 　　　／`ミ _x 彡    | Пока - пока:3 |\n" +
                "　　 　 /　　　 　 | \n" +
                "　　　 /　 ヽ　　 ﾉ \n" +
                "　／￣|　　 |　|　| \n" +
                "　| (￣ヽ＿_ヽ_)_) \n" +
                "　＼二つ");
        System.exit(0);
    }

}
