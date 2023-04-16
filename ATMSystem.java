import java.util.Scanner;
public class ATMSystem {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
System.out.print("Enter your username: ");
String username = scanner.nextLine();
System.out.print("Enter your password: ");
String password = scanner.nextLine();
User user = new User(username, password);
ATM atm = new ATM();
if (atm.login(user)) {
System.out.println("Welcome " + user.getUsername());
boolean logout = false;
while (!logout) {
System.out.println("1. Check balance");
System.out.println("2. Withdraw");
System.out.println("3. Deposit");
System.out.println("4. Logout");
int choice = scanner.nextInt();
switch (choice) {
case 1:
System.out.println("Balance: " + atm.checkBalance());
break;
case 2:
System.out.print("Enter amount to withdraw: ");
int withdrawAmount = scanner.nextInt();
System.out.println("New balance: " + atm.withdraw(withdrawAmount));
break;
case 3:
System.out.print("Enter amount to deposit: ");
int depositAmount = scanner.nextInt();
System.out.println("New balance: " + atm.deposit(depositAmount));
break;
case 4:
logout = true;
System.out.println("Logout successful");
break;
default:
System.out.println("Invalid choice");
break;
}
}
} else {
System.out.println("Invalid username or password");
}
}
}
class ATM {
private int balance;
public ATM() {
balance = 10000;
}
public boolean login(User user) {
return user.getUsername().equals("admin") && user.getPassword().equals("1234");
}
public int checkBalance() {
return balance;
}
public int withdraw(int amount) {
if (balance >= amount) {
balance -= amount;
return balance;
} else {
System.out.println("Insufficient funds");
return balance;
}
}
public int deposit(int amount) {
balance += amount;
return balance;
}
}
class User {
private String username;
private String password;
public User(String username, String password) {
this.username = username;
this.password = password;
}
public String getUsername() {
return username;
}
public String getPassword() {
return password;
}
}