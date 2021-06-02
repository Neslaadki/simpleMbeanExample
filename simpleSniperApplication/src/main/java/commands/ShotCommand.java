package commands;

import resources.Point;
import services.Invoker;
import services.PointsHandler;
import services.Receiver;

import java.util.TreeMap;

public class ShotCommand extends Command {

    private final Receiver receiver;

    public ShotCommand(Receiver receiver) {
        this.receiver = receiver;
        setName("shot");
        setDescription("выстрелить в область радиуса R по заданным X,Y");
    }

    @Override
    public void execute(TreeMap<String, Command> hashMap, PointsHandler handler,
                        Invoker commandManager, String... args) {
        receiver.add(handler, new Point(Double.parseDouble(args[0]),
                Double.parseDouble(args[1]), Double.parseDouble(args[2])));
    }


}
