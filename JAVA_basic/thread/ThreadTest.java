class ThreadTest {

    public static void main(String[] args) {
        ThreadEx1 threadEx1 = new ThreadEx1();

        // Runnable runnable = new ThreadEx2();
        // Thread threadEx2 = new Thread(runnable);
        Thread threadEx2 = new Thread(new ThreadEx2());
    
        threadEx1.start();
        threadEx2.start();            
    }

}

class ThreadEx1 extends Thread{
    public void run(){
        for(int i=0; i<5; i++){
            System.out.println(getName());
        }
    }
}

class ThreadEx2 implements Runnable{
    @Override
    public void run() {
        // TODO Auto-generated method stub
        for(int i=0; i<5; i++){
            System.out.println(Thread.currentThread().getName());
        }        
    }
}