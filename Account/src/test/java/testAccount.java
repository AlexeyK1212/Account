public class testAccount {

    public static void main(String[] args) throws undoException {

        Account ac = new Account("Начальное имя");

        ac.updateCurrencyAccounts(810,100);
        ac.updateName("Василий Иванов");
        ac.updateCurrencyAccounts(810,300);
        System.out.println("Первый откат, должно стать 100 рублей");
        ac.undo();
        System.out.println(ac.getCurrencyAccounts());
        System.out.println("Второй откат, должно вернуться начальное имя");
        ac.undo();
        System.out.println(ac.getName());
        ac.undo();
        System.out.println("Третий откат");
        System.out.println(ac.getCurrencyAccounts());

        //Тест сохранения через Memento
        System.out.println("Тест сохранения через Memento");
        ac.updateName("Василий Иванов");
        ac.updateCurrencyAccounts(810,300);

        // сохраняем
        AccountMemento memento = ac.save();

        // исзменяем
        ac.updateName("Василий Петров");
        ac.updateCurrencyAccounts(810,400);

        //делаем restore
        ac.restore(memento);
        System.out.println(ac.getName());
        System.out.println(ac.getCurrencyAccounts());

    }

}
