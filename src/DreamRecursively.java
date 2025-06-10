public class DreamRecursively {
    public static void main(String[] args) {
        if (new Sleeper().enter(new Dream()) != 0) {
            // The goal is to reach this line
            System.out.println("Am I still dreaming?");
        }
    }
}

class Dream {
    private final Thread constructThread = Thread.currentThread();

    public void dream(final Sleeper sleeper) {
        if (Thread.currentThread() == constructThread) {
            System.out.println("Constructor thread trying to dream");
            new Thread("nightmare") {
                public void run() {
                    sleeper.enter(Dream.this);
                }
            }.start();
            try {
                sleeper.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(Thread.currentThread().getName() +
                    " thread trying to dream");
            synchronized (sleeper) {
                sleeper.notify();
                try {
                    sleeper.wait(100);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
    }
}

class Sleeper {
    private int level;

    public synchronized int enter(Dream dream) {
        level++;
        try {
            dream.dream(this);
        } finally {
            level--;
        }
        return level;
    }
}

