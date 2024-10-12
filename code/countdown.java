class countdown implements Runnable {
    private int timer = 30;

    public countdown (int timer) {
        this.timer = timer;
    }

    public void run() {
        for(int i = timer;timer >0;i--) {
            System.out.println(i);

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.print(e);
            }
        }
    }
}
