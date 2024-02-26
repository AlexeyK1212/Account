import java.util.HashMap;

public class AccountMemento {

    private final String stringFieldState;

    private final HashMap<Integer, Integer> hashMapFieldState;



    public AccountMemento(String stringField, HashMap<Integer, Integer> hashMapField) {

        this.stringFieldState = stringField;

        this.hashMapFieldState = new HashMap<>(hashMapField);

    }



    // Получаем состояние stringField

    public String getStringFieldState() {

        return stringFieldState;

    }



    // Получаем состояние hashMapField

    public HashMap<Integer, Integer> getHashMapFieldState() {

        return hashMapFieldState;

    }

}