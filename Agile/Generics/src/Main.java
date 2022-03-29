import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List numberList = new ArrayList<>();
    public static void main(String[] args) {
        //List<>
        agrearNumero(10);
        //agrearNumero("12");
        agrearNumero(30);
        for (Object o : numberList){
            System.out.println(o);
        }
    }

    public static <U extends  Number> void agrearNumero(U u){
        numberList.add(u);
    }
}
