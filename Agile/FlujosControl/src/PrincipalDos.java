public class PrincipalDos {
    public static void main(String[] args) {
        int mont = Integer.parseInt(args[0]);
        int year = Integer.parseInt(args[1]);
        boolean yearBool = false;
        if ((year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0))){
            yearBool = true;
        }


        switch (mont) {
            case 1:
                System.out.println("Enero tiene 31 dias");
                break;
            case 2:
                if (yearBool){
                    System.out.println("Febrero tiene 29 dias");
                }else{
                    System.out.println("Febrero tiene 28 años");
                }
                break;
            case 3:
                System.out.println("Marzo tiene 31 dias");
                break;
            case 4:
                System.out.println("Abril tiene 30 dias");
                break;
            case 5:
                System.out.println("Mayo tiene 31 dias");
                break;
            case 6:
                System.out.println("Junio tiene 30 dias");
                break;
            case 7:
                System.out.println("Julio tiene 31 dias");
                break;
            case 8:
                System.out.println("Agosto tiene 31 dias");
                break;
            case 9:
                System.out.println("Septiembre tiene 30 dias");
                break;
            case 10:
                System.out.println("Octubre tiene 31 dias");
                break;
            case 11:
                System.out.println("Noviembre tiene 30 dias");
                break;
            case 12:
                System.out.println("Diciembre tiene 31 dias");
                break;
            default:
                System.out.println("No se ingreso un mes correcto");
        }
    }
}
