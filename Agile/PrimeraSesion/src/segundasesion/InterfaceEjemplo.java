package segundasesion;

public class InterfaceEjemplo {
    public static void main(String[] args) {
        FunctionalImplement implement = new FunctionalImplement();
        Runner runner = new Runner();
        runner.makeItRun(implement);
    }

}

class FunctionalImplement implements MyRunnable{
    @Override
    public void run() {
        System.out.println("Running.....");
    }
//    @Override
//    public void run() {
//        System.out.println("Running.....");
//    }

}
class Runner{
    void makeItRun(MyRunnable runnable){
        runnable.run();
    }
}

interface MyRunnable{
    void run();
}
