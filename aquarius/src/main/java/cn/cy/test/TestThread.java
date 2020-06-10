package cn.cy.test;

public class TestThread extends Thread{
	public TestThread(String name) {
		super.setName(name);
	}
	
	static int tick = 10;
	
	static Object key = "key";
	
	@Override
	public void run() {
		while(tick > 0) {
			synchronized (key) {
				if(tick > 0) {
					System.out.println(getName()+"卖出第"+tick+"张票");
					tick--;
				}else {
					System.out.println("票已卖完");
				}
			}
			try {
				sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		TestThread thread1 = new TestThread("线程1");
		TestThread thread2 = new TestThread("线程2");
		TestThread thread3 = new TestThread("线程3");
		
		thread1.start();
		thread2.join();
		thread2.start();
		thread3.join();
		thread3.start();
	}
	

}
