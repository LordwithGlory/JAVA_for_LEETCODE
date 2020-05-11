import java.sql.Time;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Thread_pool_test {
    class  myRunable implements Runnable{
        String command="";
        public myRunable(String c){
            command=c;
        }
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+" start time: "+new Date());
            processcommad();
            System.out.println(Thread.currentThread().getName()+" end time:"+new Date());
        }

        private void processcommad(){
            try {
                Thread.sleep(500);
                if (Integer.parseInt(command)%3==0)
                    Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class ThreadDemo{
        private static final int CORE_POOL_SIZE=3;
        private static final int MAX_POOL_SIZE=6;
        private static final int QUEUE_SIZE=3;
        private static final long KEEP_ALIVE_TIME=1L;

        public void setonedemo(){
            ThreadPoolExecutor executor=new ThreadPoolExecutor(CORE_POOL_SIZE,MAX_POOL_SIZE,KEEP_ALIVE_TIME,
                    TimeUnit.SECONDS,new ArrayBlockingQueue<>(QUEUE_SIZE),new ThreadPoolExecutor.CallerRunsPolicy());
            for (int num=1;num<20;num++){
                Runnable worker=new myRunable(num+"");
                executor.execute(worker);
            }
            while (!executor.isShutdown())
                executor.shutdown();
            System.out.println("Finished!");
        }
    }

    public void showdemo(){
        ThreadDemo demo=new ThreadDemo();
        demo.setonedemo();
    }
    public static void main(String[] args){
        Thread_pool_test test=new Thread_pool_test();
        test.showdemo();
    }
}
