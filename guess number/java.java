public class java {import java.util.*;

    public class Main{
        public static void main(String[] args) {
            ATMop obj = new ATMop();
        }
    }
    class Data{
        int balance;
        ArrayList<Integer> arrayList = new ArrayList<>();
    }
    class ATMop {
        HashMap<Integer , Data >  map  = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        ATMop(){
            System.out.println("Welcome to our ATM");
            opNew();
        }
        public void opEx() {
            System.out.println("Enter valid pin");

            int pin = sc.nextInt();

            if (map.containsKey(pin)) {
                Data obj = map.get(pin);
                menu(obj);
            }
            else {
                System.out.println("No A/C Exist");
                another();
            }
        }
        public void opNew(){
            System.out.println("Please Create an Account first ");
            System.out.println("set pin code");
            System.out.println("set pin greater than 2  and less than 5");

            int setpin = sc.nextInt();

            Data obj = new Data();
            if(Integer.toString(setpin).length() < 5 && 2<Integer.toString(setpin).length() ){
                obj.balance = 0;
                map.put(setpin , obj);
                menu(obj);
            }
            else{
                System.out.println("Invalid pin system terminate");
                opNew();
            }
        }


        public void menu(Data obj){
            System.out.println("*********************");
            System.out.println("Enter your choice");
            System.out.println("1 . Check Balance");
            System.out.println("2 . Withdraw Money");
            System.out.println("3 . Deposit Money");
            System.out.println("4 . Money Transfer");
            System.out.println("5 . Transaction History");
            System.out.println("6 . Exit");
            int x = sc.nextInt();
            System.out.println("*********************");
            if(x == 1){
                check_balance(obj);
            }
            else if(x==2){
                withdraw(obj);
            }
            else if(x==3){
                deposite(obj);
            } else if (x==4) {
                transfer(obj);
            } else if(x == 6){
                System.out.println("thank you for using our ATM");
                another();
            }else if(x == 5){
                System.out.println("Transaction History is :");
                transactHis(obj);
            }
            else{
                System.out.println("enter valid option");
                menu(obj);
            }
        }
        public void another(){
            System.out.println("1. Access another A/C");
            System.out.println("2. Create New A/C");
            System.out.println("3.Exit");
            System.out.println("Enter choice:");
            int ch = sc.nextInt();
            if (ch==1){
                opEx();
            }else if(ch == 3){
                System.out.println("exit");
            } else if (ch==2) {
                opNew();

            }
        }

        public void check_balance(Data obj){
            System.out.println("your current balance " + obj.balance);
            menu(obj);
        }

        public void deposite(Data obj){
            System.out.println("enter the amount ");
            int d = sc.nextInt();
            obj.balance += d;
            obj.arrayList.add(d);
            System.out.println("amount deposited successfully ");
            menu(obj);
        }

        public void withdraw(Data obj){
            System.out.println("enter the amount ");
            int d = sc.nextInt();
            if(d > obj.balance) {
                System.out.println("insufficient balance");
                menu(obj);
            }
            obj.balance -= d;
            obj.arrayList.add(-d);
            System.out.println("amount withdraw successfully ");
            // System.out.println("******************************************************************************");
            menu(obj);
        }
        public void  transfer(Data obj){
            System.out.println("1. Existing A/C:");
            System.out.println("2. Exit");
            System.out.println("Enter your Choice:");
            int ch = sc.nextInt();

            if (ch==1){
                System.out.println("Enter Pin Here:");
                int rePin = sc.nextInt();
                if (map.containsKey(rePin))
                {   Data obj2 = map.get(rePin);
                    System.out.println("Enter your amount:");
                    int tAmount = sc.nextInt();

                    if (obj.balance>=tAmount){
                        obj2.balance += tAmount;
                        obj.balance = obj.balance - tAmount;
                        obj2.arrayList.add(tAmount);
                        obj.arrayList.add(-tAmount);


                        menu(obj);
                    }
                    else {
                        System.out.println("Insufficient Balance");
                        menu(obj);
                    }
                }
                else {
                    System.out.println("Wrong Pin");
                    transfer(obj);
                }
            } else if (ch==2) {
                menu(obj);

            }
            else {
                System.out.println("Wrong Choice");
                transfer(obj);
            }

        }
        public void transactHis(Data obj){
            for (int num : obj.arrayList) {
                System.out.println(num);
            }
            menu(obj);

        }

    }
}import java.util.Random;
        import javax.swing.JOptionPane;


public class Main {
    public static void main(String[] args) {

        Random random = new Random();
        int maxAttempts = 5;
        int attempts = 0;
        int score = 50;
        boolean hasWon = false;


        JOptionPane.showMessageDialog(null, "Welcome to the Number Guessing Game!\n" + "-> In this game you have to guess a number between 1 to 100. \n-> You will have maximum 5 attempts to guess the number. \n-> The player's score is initially set to 50, and for each incorrect guess, 10 points are deducted.", "Number Guessing Game", JOptionPane.INFORMATION_MESSAGE);


        int randomNumber = random.nextInt(100) + 1;
        System.out.println(randomNumber);

        while (!hasWon && attempts < maxAttempts) {
            String input = JOptionPane.showInputDialog(null, "Enter your guess :", "Number Guessing Game", JOptionPane.QUESTION_MESSAGE);
            if (input != null) {
                int guess = Integer.parseInt(input);
                attempts++;

                if (guess < randomNumber) {
                    JOptionPane.showMessageDialog(null, "Too low! Enter higher number ! \nyou have "+(5-attempts)+" attempts left.", "Number Guessing Game", JOptionPane.WARNING_MESSAGE);
                } else if (guess > randomNumber) {
                    JOptionPane.showMessageDialog(null, "Too high! Enter lower number ! \nyou have "+(5-attempts)+" attempts left.", "Number Guessing Game", JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog( null, "Congratulations! You guessed the number in " + attempts + " attempts.\nYour score is: " + score+ "/50", "Number Guessing Game", JOptionPane.INFORMATION_MESSAGE);
                    hasWon = true;
                }
                score -= 10;
            } else {
                System.out.println("No input provided.");
                break;
            }
        }

        if (!hasWon) {
            JOptionPane.showMessageDialog(null, "Oops! You've reached the maximum " + maxAttempts + " attempts " + ".\nThe number was : " + randomNumber +"\nBetter luck next time!\nYour score is : 0", "Number Guessing Game", JOptionPane.WARNING_MESSAGE);
        }

    }
}