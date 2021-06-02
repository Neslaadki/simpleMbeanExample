package commands;

import services.Invoker;
import services.PointsHandler;
import services.Receiver;

import java.util.TreeMap;

public class ExitCommand extends Command{

    private final Receiver receiver;

    public ExitCommand(Receiver receiver) {
        this.receiver = receiver;
        setName("exit");
        setDescription("завершить работу приложения");
    }

    @Override
    public void execute(TreeMap<String, Command> treeMap, PointsHandler handler, Invoker commandManager) {
        receiver.exit();
    }
}
