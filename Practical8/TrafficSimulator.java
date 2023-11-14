import java.util.Random;

class ArrivalThread extends Thread {
    private final String direction;

    public ArrivalThread(String direction) {
        this.direction = direction;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            try {
                int sleepTime = random.nextInt(3500) + 500;
                Thread.sleep(sleepTime);

                System.out.println("Car arrived from " + direction);

                TrafficSimulator.incrementQueue(direction);
                
                new CrossingThread(direction).start();

            } 
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class WestArrivalThread extends ArrivalThread {
    public WestArrivalThread() {
        super("the west");
    }
}

class SouthArrivalThread extends ArrivalThread {
    public SouthArrivalThread() {
        super("the south");
    }
}

class CrossingThread extends Thread {
    private final String direction;

    public CrossingThread(String direction) {
        this.direction = direction;
    }

    @Override
    public void run() {
        TrafficSimulator.cross(direction);
    }
}

public class TrafficSimulator {
    private static int westQueue = 0;
    private static int southQueue = 0;

    public static synchronized void incrementQueue(String direction) {
        if (direction.equals("the west")) {
            westQueue++;
        } 
        else if (direction.equals("the south")) {
            southQueue++;
        }
        System.out.println("Number of cars in the west queue: " + westQueue);
        System.out.println("Number of cars in the south queue: " + southQueue);
    }

    public static synchronized void cross(String direction) {
        try {
            Thread.sleep(2000);
        } 
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (direction.equals("the west")) {
            westQueue--;
        } else if (direction.equals("the south")) {
            southQueue--;
        }
        System.out.println("Number of cars in the west queue: " + westQueue);
        System.out.println("Number of cars in the south queue: " + southQueue);
    }

    public static void main(String[] args) {
        WestArrivalThread westArrivalThread = new WestArrivalThread();
        SouthArrivalThread southArrivalThread = new SouthArrivalThread();

        westArrivalThread.start();
        southArrivalThread.start();
    }
}
