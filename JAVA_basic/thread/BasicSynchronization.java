public class BasicSynchronization {
    private String mMessage;

    public static void main(String[] agrs) {
        BasicSynchronization temp1 = new BasicSynchronization();
        BasicSynchronization temp2 = new BasicSynchronization();

        System.out.println("Test start!");
        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                temp1.callMe("Thread1");
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                temp2.callMe("Thread2");
            }
        }).start();
        System.out.println("Test end!");
    }

    public void callMe(String whoCallMe) {
        mMessage = whoCallMe;
        try {
            long sleep = (long) (Math.random() * 100);
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (!mMessage.equals(whoCallMe)) {
            System.out.println(whoCallMe + " | " + mMessage);
        }
    }
}
