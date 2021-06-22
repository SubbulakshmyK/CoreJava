package demos;


public class Threadmain {
	
	public static void main(String args[]) {
		
		//MutiThread Example
		  ThreadDemo td = new ThreadDemo(); td.setName("ChildTread");
		  //td.setPriority(1); td.setDaemon(true);
		  
		  
		  for(int i=0;i<2;i++) {
			  System.out.println("I am inside main thread, my name is "+Thread.currentThread().getName()); 
		  } 
		  td.start();
		  
		  Thread rd= new Thread(new RunnableDemo());
		  rd.start();

		
		
	}
}
