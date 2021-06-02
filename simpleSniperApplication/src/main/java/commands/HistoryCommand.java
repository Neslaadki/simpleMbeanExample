package commands;

import services.Invoker;
import services.PointsHandler;
import services.Receiver;

import java.util.TreeMap;

public class HistoryCommand extends Command{

    private final Receiver receiver;

    public HistoryCommand(Receiver receiver) {
        this.receiver = receiver;
        setName("history");
        setDescription("вывести список предыдущих выстрелов");
    }

    @Override
    public void execute(TreeMap<String, Command> treeMap, PointsHandler handler, Invoker commandManager) {
        receiver.history(handler);
    }
}