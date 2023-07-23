/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package data_project;

/**
 *
 * @author Moustafa
 */
public class Data_project extends Thread {
public static double waitingTime=0;
public static double count =0;

    
    public static void main(String[] args) {
        Thread Th = new Thread();
       
        new java.util.Timer().schedule(
            new java.util.TimerTask() {
                
                @Override
                public void run() {
                    
                    System.out.println("Done");
                    System.out.println("waiting time: "+waitingTime);
                    System.out.println("Average waiting Time: " + (double)(waitingTime/count));
                    System.exit(0);
                }
            },10000*1000);
    }
    
}

