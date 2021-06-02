package io;

import commands.*;
import services.Invoker;
import services.PointsHandler;
import services.Receiver;

import javax.management.*;

public class ApplicationManager {
    private final ConsoleReader input;
    private final Invoker invoker;
    private final PointsHandler handler;
    private final Receiver receiver;

    {
        receiver = new Receiver();
        input = new ConsoleReader();
        handler = new PointsHandler();
        invoker = new Invoker();
    }

    public void initialisation() throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException {
        System.out.println("--------------------------------------------------------");
        System.out.println(mainMessage());
        System.out.println();

        Command shot = new ShotCommand(receiver);
        Command help = new HelpCommand(receiver);
        Command history = new HistoryCommand(receiver);
        Command exit = new ExitCommand(receiver);
        invoker.setCommandMap(shot.getName(), shot);
        invoker.setCommandMap(help.getName(), help);
        invoker.setCommandMap(history.getName(), history);
        invoker.setCommandMap(exit.getName(), exit);

        /*
            Настройка JMX сервера и регистрация в нем бина
         */


        String line = "";
        do {
            input.getDefaultConsoleSymbol();
            line = input.getScanner().nextLine().trim();
            if (line.trim().equals("")) {
                continue;
            }
            String[] lines;
//            try {
//                String spaces = line.substring(line.indexOf(' '), line.lastIndexOf(' '));
//                line = line.replaceFirst(spaces, "");
//            } catch (StringIndexOutOfBoundsException ignored) {
//            }
            lines = line.split(" ");
            try {
                String command = lines[0];
                if (lines.length == 4) {
                    try {
                        if (Double.parseDouble(lines[3])  % 1 != 0 || Double.parseDouble(lines[3]) <= 0) throw new ClassCastException();
                        invoker.execute(command, invoker.getCommandMap(), handler, lines[1], lines[2], lines[3]);
                    } catch (IllegalStateException e) {
                        System.out.println("Команда введена неправильно, попробуй еще раз.");
                    } catch (ClassCastException e){
                        System.out.println("Значение радиуса должно быть целым положительным числом!");
                    }
                } else if (lines.length == 1) {
                    try {
                        invoker.execute(command, invoker.getCommandMap(), handler);
                    } catch (IllegalStateException e) {
                        System.out.println("Команда введена неправильно, попробуй еще раз.");
                    }
                } else {
                    System.out.println("Неверный формат команды. Попробуй еще раз.");
                }

            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Вы ввели непрвильную команду, попробуйте снова");
            }
            System.out.println();

        } while (!line.equals("exit"));


    }

    public String mainMessage() {
        return "Добро пожаловать в консольное приложение 'Sniper'!" + System.lineSeparator() +
                "by Дзюбак Антон и Олеся Нечкасова " + System.lineSeparator() +
                System.lineSeparator() + "Пожалуйста, введи 'help' в консоль, чтобы ознакомиться с функционалом приложения" + System.lineSeparator();
    }
}
