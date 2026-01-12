import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws InterruptedException, IOException{
        //variables
        String user, exitChoice;
        int password, userChoice;
        double balance = 0;
        boolean exit = false, passwordCheck = true;

        Scanner scanner = new Scanner(System.in);
        //welcome message
        logo();
        System.out.print("Enter your name: ");
        user = scanner.nextLine();
        do{
            System.out.print("Enter your 4 numbers password (don't forget!): ");
            password = scanner.nextInt();
            //check if the password have the right length
            if (String.valueOf(password).length() > 4 || String.valueOf(password).length() < 4){
                System.out.println("Please, enter a password with only 4 numbers.");
            }
        //repeat if not
        }while(String.valueOf(password).length() != 4);
        
        //"process" the name and the password
        cleanScreen();
        System.out.println("Wait...");
        Thread.sleep(2000);
        cleanScreen();
        System.out.println("Validated!\n");
        System.out.printf("Welcome %s\n\n", user);
        Thread.sleep(1000);
        do{
            //menu
            cleanScreen();
            logo();
            System.out.println("=== Menu: ===");
            System.out.println("1 - Show Balance");
            System.out.println("2 - Deposit");
            System.out.println("3 - Withdraw\n");
            System.out.println("press 4 to exit");
            userChoice = scanner.nextInt();
            cleanScreen();
            //ask the password if it is not to exit
            if (userChoice < 4 && userChoice != 0){
                passwordCheck = passwordCheck(password, scanner);
                if (passwordCheck == false){
                    System.out.println("You were unable to verify your identity.\nPlease try again later.");
                    break;
                }
            }
            switch (userChoice) {
                case 1 ->{
                    cleanScreen();
                    showBalance(user, balance, scanner);
                }
                case 2 ->{
                    cleanScreen();                    
                    //deposit()
                    balance = deposit(balance, scanner);
                }
                case 3 ->{
                    cleanScreen();
                    //withdraw()
                    balance = withdraw(balance, scanner);    
                }
                case 4 ->{
                    //exit message
                    cleanScreen();
                    logo();
                    System.out.printf("Thank you for being our loyal customer, %s!\n", user);
                    System.out.println("May the notes always be in your favor.\n");
                    Thread.sleep(1000);
                    exit = true;
                }
                default ->{
                    System.out.println("Please enter a valid choice");
                    System.out.println("Press any key and then Enter to return to menu");
                    String returnMenu = scanner.next();
                }
            }
        }while(!exit);
        
        scanner.close();
    }
    static void cleanScreen() throws InterruptedException, IOException{
        //variables
        //get the OS
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")){
            //for Windows:
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
        else{
            //for Linux or macOS
            new ProcessBuilder("sh", "-c","clear").inheritIO().start().waitFor();
        }
    }
    static void logo(){
        System.out.println("==$== JAVANK ==$==");
        System.err.println();
    }
    static boolean passwordCheck(int password, Scanner scanner){
        int tries = 0;
        //ask for the password
        System.out.print("Please, enter your password: ");
        int passwordCheck = scanner.nextInt();

        while(passwordCheck != password){
            //you have 3 attempts to get the password correctly
            if (tries <= 3){
                tries++;
                System.out.println("Incorrect!");
                System.out.println("Please, try again");
                System.out.println("Password: ");
                passwordCheck = scanner.nextInt();
            }
            //if not, the program will close
            else{
                return false;
            }
        }
        //if you can manage it, you can proceed
        return true;       
    }
    static void showBalance(String name, double balance, Scanner scanner){
        logo();
        System.out.println(name);
        System.out.printf("Your bank balance: $%,.2f", balance);
        System.out.println();
        System.out.println("Press any key and then Enter to return to menu");
        String returnMenu = scanner.next();
    }
    static double deposit(double balance, Scanner scanner) throws InterruptedException, IOException{
        logo();

        System.out.println("Remember: You can only deposit amounts below 10,000");
        System.out.println();
        System.out.println("Enter the amount you wish to deposit (use , to include cents):");
        double deposit = scanner.nextDouble();
        cleanScreen();

        //the program "process" the deposit
        System.out.println("Wait, we are trying to deposit in your acount...");
        Thread.sleep(2000);
        cleanScreen();

        //check if the amount can be deposit
        if (Math.abs(deposit) < 10000){
            logo();
            System.out.println("Amount deposited into your account!");
            System.out.println("Press any key and then Enter to return to menu");
            String returnMenu = scanner.next();
            balance += deposit;
            return balance;
        }

        //if not, you return to menu
        else{
            logo();
            System.out.println("You are trying to deposit an amount greater than 10.000, please go to a bank teller.");
            System.out.println("Press any key and then Enter to return to menu");
            String returnMenu = scanner.next();
            return balance;
        }
    }
    static double withdraw(double balance, Scanner scanner) throws InterruptedException, IOException{
        logo();
        System.out.println("Enter the amount you want to withdraw (no cents): ");
        int withdraw = scanner.nextInt();
        cleanScreen();

        //"process" the request
        System.out.println("Wait...");
        Thread.sleep(2000);
        cleanScreen();

        //check if the withdraw is possible with the balance the user have
        if(withdraw > balance){
            logo();
            System.out.println("Your balance is insufficient to perform this withdrawal");
            System.out.println("Press any key and then Enter to return to menu");
            String returnMenu = scanner.next();
            return balance;
        }
        //if is possible, the value is subtracted from the balance
        balance -= withdraw;
        logo();
        System.out.println("Withdrawal completed!\nPlease remove the banknotes...");
        //time to the notes get "collected"        
        Thread.sleep(3000);
        cleanScreen();

        System.out.println("Press any key and then Enter to return to menu");
        String returnMenu = scanner.next();
        return balance;
    }
}
