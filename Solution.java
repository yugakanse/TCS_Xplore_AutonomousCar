// "static void main" must be defined in a public class.
import java.util.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
      Scanner sc = new Scanner(in);
        AutonomousCar[] rg = new AutonomousCar[4];

        for (int i = 0; i < 4; i++) {
            AutonomousCar x = new AutonomousCar();
            x.cardId = sc.nextInt();
            sc.nextLine();
            x.brand = sc.nextLine();
            x.noOfTestsConducted = sc.nextInt();
            sc.nextLine();
            x.noOfTestsPassed = sc.nextInt();
            sc.nextLine();
            x.environment = sc.nextLine();
//            x.grade=sc.nextLine();
            rg[i] = x;
        }
        String env = sc.nextLine();
        String brandAtr = sc.nextLine();
        int y = findTestPassedByEnv(rg, env);
        if (y == 0) {
            out.println("No cars available");
        } else {
            out.println(y);
        }

        AutonomousCar t = updateCarGrade(rg, brandAtr);
        if (t == null) {
            System.out.println("No cars available");
        } else {
            System.out.println(t.brand + ": :" + t.grade);
        }
    }

    public static int findTestPassedByEnv(AutonomousCar[] rg, String env) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            if ((rg[i].environment).equalsIgnoreCase(env)) {
                count = rg[i].noOfTestsPassed + count;
            }
        }
        return count;
    }

    public static AutonomousCar updateCarGrade(AutonomousCar[] rg, String brandAtr) {
        AutonomousCar updatedCar = null;
        double rating = 0;
        for (int i = 0; i < 4; i++) {
            if ((rg[i].brand).equals(brandAtr)) {
                rating = ((rg[i].noOfTestsPassed * 100) / rg[i].noOfTestsConducted);
                if ((rating >= 80)) {
                    rg[i].grade = "A1";
                } else {
                    rg[i].grade = "B2";
                }
                updatedCar = rg[i];
            }
        }
        return updatedCar;
    }
}
class AutonomousCar{
    public int cardId;
    public String brand;
    public int noOfTestsConducted;
    public int noOfTestsPassed;
    public String environment;
    public String grade;
    AutonomousCar(){
        this.cardId=0;
        this.brand="";
        this.noOfTestsConducted=0;
        this.noOfTestsPassed=0;
        this.environment="";
        this.grade="";
    }
}
