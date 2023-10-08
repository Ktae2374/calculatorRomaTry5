import java.util.Scanner;
public class Main {
    public static int result;
    public static String resultStr;
    public static int resultRoman = -1;
    public static int RomanValue = 0;
    public static String[] words = new String[3];
    public static int firstNumber;
    public static int secondNumber;

    public static void main(String[] args) throws ArithmeticException {
        String[] roman = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите пример: ");
        String primer = scan.nextLine();
        words = primer.split(" ");

        calc(primer);
        if (resultStr.equals("null1")){

        } else{
            int firstNumber = romanToInt(words[0]);
            int secondNumber = romanToInt(words[2]);


            if (firstNumber == -1 | secondNumber == -1) {
                throw new ArithmeticException("Ошибка, число не от 1 до 10 или число не целое!");
            } else {

                if (words.length != 3) {
                    throw new ArithmeticException("В примере должно быть два числа!");

                } else {
                    for (int i = 1; i <= 10; i++) {
                        if (words[0].equals(roman[i])) {
                            RomanValue += 1;
                        }
                        if (words[2].equals(roman[i])) {
                            RomanValue += 2;
                        }
                    }

                    if (RomanValue == 0) {
                        System.out.println("Ответ: " + resultStr);
                    } else if (RomanValue == 3) {
                        try {
                            int x = Integer.parseInt(resultStr);
                            System.out.println("Ответ: " + roman[x]);
                        } catch (ArrayIndexOutOfBoundsException e){
                            throw new ArithmeticException("В римской системе нет отрицательных числел!");
                        }
                    } else {
                        throw new ArithmeticException("Должно быть одна система счисления!");
                    }
                }
            }
        }
    }

    public static String calc(String input) {
        String[] words1 = input.split(" ");
        try {
            firstNumber = romanToInt(words1[0]);
        } catch (ArrayIndexOutOfBoundsException e){
            throw new ArithmeticException("строка не является математической операцией");
        }
        try{
            secondNumber = romanToInt(words1[2]);
        } catch (ArrayIndexOutOfBoundsException e){
            throw new ArithmeticException("строка не является математической операцией");
        }

        switch (words1[1]) {

            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "/":
                result = firstNumber / secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            default:
                throw new ArithmeticException("неправильный знак!");

        }
        resultStr = String.valueOf(result);

        return resultStr;
    }
    public static int romanToInt(String s) {
        if (s.equals("1") || s.equals("I")){
            resultRoman = 1;
        } else if (s.equals("2") || s.equals("II")) {
            resultRoman = 2;
        } else if (s.equals("3") || s.equals("III")) {
            resultRoman = 3;
        } else if (s.equals("4") || s.equals("IV")){
            resultRoman = 4;
        } else if (s.equals("5") || s.equals("V")) {
            resultRoman = 5;
        } else if (s.equals("6") || s.equals("VI")) {
            resultRoman = 6;
        } else if (s.equals("7") || s.equals("VII")) {
            resultRoman = 7;
        } else if (s.equals("8") || s.equals("VIII")) {
            resultRoman = 8;
        } else if (s.equals("9") || s.equals("IX")) {
            resultRoman = 9;
        } else if (s.equals("10") || s.equals("X")) {
            resultRoman = 10;
        } else {
            resultRoman = -1;
        }

        return resultRoman;
    }
}