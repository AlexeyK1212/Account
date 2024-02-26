

import java.util.HashMap;
import java.util.Stack;

//для выполнения команд по отмене  действий над аккаунтом
abstract class Command {
    public abstract void undo();
}








// Класс аккаунта
public class Account {
    private String Name;
    private HashMap<Integer, Integer> currencyAccounts;
    private Stack<Command> history;






    public Account(String Name) {
        this.Name = Name;
        this.currencyAccounts = new HashMap<>();
        currencyAccounts.put(810,0);
        currencyAccounts.put(840,0);
        currencyAccounts.put(978,0);
        this.history = new Stack<>();
    }

    // Метод для отмены последней операции
    public void undo() throws undoException {
        if (!history.isEmpty()) {
            history.pop().undo();
        }
        else throw new undoException("Невозможно откатить");
    }

    // метод изменения строки
    public void updateName(String newValue) {
        final String oldValue = Name;
        Name = newValue;
        history.push(new Command() {
            @Override
            public void undo() {
                Name = oldValue;
            }
        });
    }

    // метода изменения HashMap
    public void updateCurrencyAccounts(Integer key, Integer value) {
        final Integer oldValue = currencyAccounts.get(key);
        currencyAccounts.put(key, value);
        history.push(new Command() {
            @Override
            public void undo() {
                if (oldValue == null) {
                    currencyAccounts.remove(key);
                } else {
                    currencyAccounts.put(key, oldValue);
                }
            }
        });
    }

    // Геттеры для полей (для проверки состояния)
    public String getName() {
        return Name;
    }

    public HashMap<Integer, Integer> getCurrencyAccounts() {
        return currencyAccounts;
    }


    // Метод для сохранения состояния

    public AccountMemento save() {

        return new AccountMemento(Name, currencyAccounts);

    }


    // Метод для восстановления состояния

    public void restore(AccountMemento memento) {

        this.Name = memento.getStringFieldState();

        this.currencyAccounts = new HashMap<>(memento.getHashMapFieldState());

    }


}

class undoException extends Exception {
    public undoException (String msg)
    {
        super(msg);
    }


}