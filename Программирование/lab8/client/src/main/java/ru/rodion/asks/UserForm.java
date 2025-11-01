package ru.rodion.asks;


import ru.rodion.commandLine.*;
import ru.rodion.exceptions.FIleFieldException;
import ru.rodion.network.User;
import ru.rodion.utility.ExecuteManager;
import ru.rodion.utility.OutputColors;

import java.util.Objects;

/**
 * Форма для создания юзера
 */
public class UserForm extends Form<User> {

    private final Printable console;
    private final UserInput scanner;

    public UserForm(Printable console) {
        this.console = (ConsoleOutput.isFileMode())
                ? new PrintConsole()
                : console;
        this.scanner = (ConsoleOutput.isFileMode())
                ? new ExecuteManager()
                : new ConsoleInput();
    }

    /**
     * Сконструировать новый элемент класса {@link ru.rodion.models.SpaceMarine}
     *
     * @return объект класса {@link ru.rodion.models.SpaceMarine}
     */
    @Override
    public User build() {
        return new User(
                askLogin(),
                askPassword()
        );
    }

    public boolean askIfLogin() {
        for (; ; ) {
            console.print("У вас уже есть аккаунт? [y/n]  ");
            String input = scanner.nextLine().trim().toLowerCase();
            switch (input) {
                case "y", "yes", "да", "д" -> {
                    return true;
                }
                case "n", "no", "нет", "н" -> {
                    return false;
                }
                default -> console.printError("Ответ не распознан");
            }
        }
    }

    private String askLogin() {
        String login;
        while (true) {
            console.println(OutputColors.toColor("Введите ваш логин", OutputColors.GREEN));
            login = scanner.nextLine().trim();
            if (login.isEmpty()) {
                console.printError("Логин не может быть пустым");
                if (ConsoleOutput.isFileMode()) throw new FIleFieldException();
            } else {
                return login;
            }
        }
    }

    private String askPassword() {
        String pass;
        while (true) {
            console.println(OutputColors.toColor("Введите пароль", OutputColors.GREEN));
            pass = (Objects.isNull(System.console()))
                    ? scanner.nextLine().trim()
                    : new String(System.console().readPassword());
            if (pass.isEmpty()) {
                console.printError("Пароль не может быть пустым");
                if (ConsoleOutput.isFileMode()) throw new FIleFieldException();
            } else {
                return pass;
            }
        }
    }
}
