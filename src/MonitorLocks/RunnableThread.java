package MonitorLocks;

public class RunnableThread implements Runnable{

    MonitorLockExample obj;

    RunnableThread(MonitorLockExample monitorLockExample){
        this.obj = monitorLockExample;
    }

    @Override
    public void run() {
        obj.task1();
    }
}
