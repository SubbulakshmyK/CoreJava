package demos;

public class ThreadDemo  extends Thread{
	
	@Override
	public void run() {
		System.out.println("I am a Doemon Thread or not ? "+Thread.currentThread().isDaemon() );
		for(int i=0; i<10;i++) {
			System.out.println("Insinde Chid Thread My name is "+Thread.currentThread().getName());
		}
		run(10);
		System.out.println("=======CHILD THREAD END===== " );
	}
	
	public void run(int k) {
		System.out.println("=======CHILD THREAD OVERRIDDEN RUN===== " );
	}

}


class RunnableDemo  implements Runnable{
	
	public void run() {
		for(int i=0; i<10;i++) {
			System.out.println("Insinde Chid Thread My name is "+Thread.currentThread().getName());
		}
		System.out.println("=======CHILD Runnable THREAD END===== " );
	}

}
