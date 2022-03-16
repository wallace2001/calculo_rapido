import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class exercicio {

    // The class of numbers
    public static class NumberCalc {
        private int S = 0;
        private int A = 0;
        private int B = 0;

        public void setS(int valueS) {
            this.S = valueS;
        }

        public void setA(int valueA) {
            this.A = valueA;
        }

        public void setB(int valueB) {
            this.B = valueB;
        }

        public int getS() {
            return this.S;
        }

        public int getA() {
            return this.A;
        }

        public int getB() {
            return this.B;
        }
    }

    // This function is populating the number class
    public static Boolean numbersSelected(NumberCalc numberCalc) {
        Scanner key = new Scanner(System.in);

        // Setting a constant for labels
        String[] label = new String[3];
        label[0] = "Digite o primeiro número (Entre 1 á 36): ";
        label[1] = "Digite o segundo número (Entre 1 á 10.000): ";
        label[2] = "Digite o terceiro número (Entre 1 á 10.000): ";

        String errorMessage = "Número menor ou maior ao requirido!";

        // Checking which ones are not filled and when all are filled, return as true status
        if (numberCalc.getS() == 0) {
            // Question
            System.out.println(label[0]);
            int value = key.nextInt();
            if (value < 1 | value > 36) {
                System.out.println(errorMessage);
                return false;
            }
            numberCalc.setS(value);
            return false;
        } else if (numberCalc.getA() == 0) {
            System.out.println(label[1]);
            int value = key.nextInt();
            if (value < 1 | value > 10000) {
                System.out.println(errorMessage);
                return false;
            }
            numberCalc.setA(value);
            return false;
        } else if (numberCalc.getB() == 0) {
            System.out.println(label[2]);
            int value = key.nextInt();
            if (value < 1 | value > 10000) {
                System.out.println(errorMessage);
                return false;
            }

            if (value <= numberCalc.getA()) {
                System.out.println("Número menor do que o anterior!");
                return false;
            }
            numberCalc.setB(value);
            return false;
        }

        if (numberCalc.getB() != 0 & numberCalc.getA() != 0 & numberCalc.getS() != 0) {
            return true;
        }

        return false;
    }

    // This function calculates the exercise
    public static Number resultCalc(NumberCalc numberCalc){
        List<Number> numbersBetween = new ArrayList<Number>();
        int result = 0;

        for (int x = 0; x <= (numberCalc.getB() - numberCalc.getA()); x++) {
            numbersBetween.add(numberCalc.getA() + x);
        }

        for (int x = 0; x < numbersBetween.size(); x++) {
            String number = String.valueOf(numbersBetween.get(x));
            String[] digits = number.split("(?<=.)");

            int numberA = 0;

            for (int i = 0; i < digits.length; i++) {
                numberA = Integer.parseInt(digits[i]) + numberA;
            }

            if (numberA == numberCalc.getS()) {
                result += 1;
            }
        }

        return result;
    }

    // Main function (Initializer)
    public static void main(String[] args) {

        // Class to be instantiated
        NumberCalc numberCalc = new NumberCalc();

        // Status to check if all numbers have been filled
        boolean statusNumbersSelected = false;

        // When all numbers are selected, exit looping
        while (statusNumbersSelected != true) {
            boolean status = numbersSelected(numberCalc);

            if (status == true) {
                statusNumbersSelected = status;
            }
        }

        // Calling the function to get the result of the exercise
        Number resultCalc = resultCalc(numberCalc);

        // Result
        System.out.println("Resultado: " + resultCalc);
    }
}
