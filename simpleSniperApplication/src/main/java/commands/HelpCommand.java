package commands;

import services.Invoker;
import services.PointsHandler;
import services.Receiver;

import java.util.TreeMap;

public class HelpCommand extends Command {

    private final Receiver receiver;

    public HelpCommand(Receiver receiver) {
        this.receiver = receiver;
        setName("help");
        setDescription("вывести справку по доступным командам");
    }

    @Override
    public void execute(TreeMap<String, Command> treeMap, PointsHandler handler, Invoker commandManager) {
        receiver.help(treeMap);
    }
}
