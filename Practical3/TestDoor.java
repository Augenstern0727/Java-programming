import java.util.Scanner;
class Door {
    protected boolean isOpen = false;
    public void openDoor() {
        if (isOpen) {
            System.out.println("Door opened");
            boolean isOpen = true;
        }
        else {
            System.out.println("Door already open!");
        }
    }
    public void closeDoor() {
        if (isOpen) {
            System.out.println("Door already closed!");
        }
        else {
            System.out.println("Door closed");
            boolean isOpen = false;
        }
    }
}

/*
public class TestDoor {
    public static void main(String[] args) {
        Door door = new Door();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1: Open door");
            System.out.println("2: Close door");
            System.out.println("3: Exit");
            System.out.print("Enter your choice: ");
            
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    door.openDoor();
                    break;
                case 2:
                    door.closeDoor();
                    break;
                case 3:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        } while (choice != 3);
    }
}
*/

class DoorWithLock extends Door {
    protected boolean isLocked = false;

    @Override
    public void openDoor() {
        if (!isOpen) {
            if (isLocked) {
                System.out.println("Door is locked and cannot be opened!");                } else {
                System.out.println("Door opened");
                isOpen = true;
            }
        } 
        else{
            System.out.println("Door already open!");
        }
    }   
    

    public void lockDoor() {
        if (isOpen) {
            System.out.println("Open door cannot be locked!");
        } 
        else if (isLocked) {
            System.out.println("Door already locked!");
        } 
        else {
            System.out.println("Door locked");
            boolean isLocked = true;
        }
    }

    public void unlockDoor() {
        if (isLocked) {
            System.out.println("Door unlocked");
            boolean isLocked = false;
        } 
        else {
            System.out.println("Door is not locked!");
        }
    }
}

/*
public class TestDoor {
    public static void main(String[] args) {
        DoorWithLock door = new DoorWithLock();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1: Open door");
            System.out.println("2: Close door");
            System.out.println("3: Lock door");
            System.out.println("4: Unlock door");
            System.out.println("5: Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    door.openDoor();
                    break;
                case 2:
                    door.closeDoor();
                    break;
                case 3:
                    door.lockDoor();
                    break;
                case 4:
                    door.unlockDoor();
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        } while (choice != 5);
    }
}
*/

class DoorWithCodeLock extends DoorWithLock {
    private int code = 0;

    @Override
    public void lockDoor() {
        if (isOpen) {
            System.out.println("Open door cannot be locked!");
        } 
        else if (isLocked) {
            System.out.println("Door already locked!");
        } 
        else {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a code to lock the door: ");
            code = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            System.out.println("Door locked");
            boolean isLocked = true;
        }
    }

    @Override
    public void unlockDoor() {
        if (isLocked) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the code to unlock the door: ");
            int userInput = scanner.nextInt();

            if (userInput == code) {
                System.out.println("Door unlocked");
                boolean isLocked = false;
            } 
            else {
                System.out.println("Invalid code!");
            }
        } 
        else {
            System.out.println("Door is not locked!");
        }
    }
}

public class TestDoor {
    public static void main(String[] args) {
        DoorWithCodeLock door = new DoorWithCodeLock();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1: Open door");
            System.out.println("2: Close door");
            System.out.println("3: Lock door");
            System.out.println("4: Unlock door");
            System.out.println("5: Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    door.openDoor();
                    break;
                case 2:
                    door.closeDoor();
                    break;
                case 3:
                    door.lockDoor();
                    break;
                case 4:
                    door.unlockDoor();
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        } 
        while (choice != 5);
    }
}