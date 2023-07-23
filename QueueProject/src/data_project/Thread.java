/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data_project;
import static data_project.Data_project.count;

public class Thread implements Runnable {
    private boolean exit;
    java.lang.Thread Th;
   Thread()
    {
        Th = new java.lang.Thread(this);
        exit = false;
        Th.start(); 
    }
    public void run() {
        Queue Q = new Queue(25);
        while (true){
            ExpDistribution xpt = new ExpDistribution();
            try {
                if(!Q.isFull()){
                double time = xpt.getExpDistribution();
                System.out.println();
                System.out.println(" waiting time for the new task: "+ time);
                System.out.println();
                Task task = new Task();
                count++;

               Q.enQueue(task); 
              Q.printQueue();

                java.lang.Thread.sleep((long)(time*1000));
                }
                java.lang.Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void stop(){
        exit = true;
    }
}
