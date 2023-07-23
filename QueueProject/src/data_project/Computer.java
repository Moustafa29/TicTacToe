/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data_project;

/**
 *
 * @author Moustafa
 */
public class Computer implements Runnable {
    Task task;
    double duration;
    java.lang.Thread t;
    String name;
    Queue Q;
   
    public Computer(Queue Q, String name) {
        t = new java.lang.Thread(this);
        t.start(); 
        this.Q = Q;
        this.name = name;
    }

    public void run() {
        while (true) {
            try {
                if(this.task != null){
                    this.runTask();
                }
                java.lang.Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setTask(Task task) {
        this.task = task;
        this.duration =  task.getTime();
        System.out.println(this.name +": setting task with time: " + this.duration);
    }

    public void runTask(){
        System.out.println(this.name +": running task with time: " + this.duration);
        System.out.println();
        for (int i = 1; i <= duration; i++) {
            
            try {
                System.out.println( this.name+ " Time counter"+
                        ": "+i+" , Task Duration.:"+ this.duration);
                java.lang.Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.duration = 0;
        this.task = null;

    }

}