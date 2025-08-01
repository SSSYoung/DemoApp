package interview.chapter1;

class ThreadTest2 {
    private static class ThreadDemon extends Thread {
        @Override
        public void run() {
            try {
                while (!isInterrupted()) {
                    System.out.println(Thread.currentThread().getName() + "I am  extends Thread");
                }
                System.out.println(Thread.currentThread().getName() + "interrupt flag is " + isInterrupted());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("finally");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadDemon threadDemon = new ThreadDemon();
        //threadDemon.setDaemon(true);
        threadDemon.start();

        Thread.sleep(1000);
        threadDemon.interrupt();
    }
}
