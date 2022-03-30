import java.util.ArrayList;
import java.util.List;

public class WildcarsDemo {
    public static void printObjectList(List<Object> list){
        list.forEach(e-> System.out.print(e + ", "));
        System.out.println();
    }
    public static void printObjectListDos(List<?> list){
        list.forEach(e-> System.out.print(e + ", "));
        System.out.println();
    }
    public static Number sum(List<Number> numberList){
        double acumulator = 0;
        for (Number number: numberList){
            acumulator += number.doubleValue();
        }
        return acumulator;
    }

    public static Number sumV2(List< ? extends Number> numberList){
        double acumulator = 0;
        for (Number number: numberList){
            acumulator += number.doubleValue();
        }
        return acumulator;
    }
    public static void main(String[] args) {
        List<Object> objectList = new ArrayList<>();
        objectList.add("Texto");
        objectList.add(1);
        objectList.add(1.0);
        objectList.add(false);
        printObjectList(objectList);


        List<String> stringList = new ArrayList<>();
        stringList.add("Text2");
        stringList.add("Text3");
        /*
        Wildcard <?>
         */

        /**
         * Given a List <E> and a List<E2> where E1 and E2 represent differente classes
         * we cannot assign List<E2> into a variable of type List<E1>
         *
         *Given a List<?> and two other lists List<E1> and List<E2>, both List<E2> and List<E1>
         *can be assigned into a variable of type List<?>
         *
         **/

        //List<Object> and Lis <String> area subtypes of List <?>
        printObjectListDos(stringList);
        printObjectListDos(objectList);


        /*
        <? extends>
         */
        List<Number> numberList = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();
        Number num1 = 1.0;
        Integer int1 = 1;
        // integerList.add(num1);}
        integerList.add(int1);
        //num1 is a Number
        numberList.add(num1);
        numberList.add(int1);
        integerList.add(3);

        Number sum1 = sum(numberList);
        System.out.println("Suma 1: " + sum1);

        //Number sum2= sum1(integerList);
        Number sum3 = sumV2(numberList);
        System.out.println("sum3 = " + sum3);
        Number sum4= sumV2(integerList);
        System.out.println("sum4 = " + sum4);
    }
}
