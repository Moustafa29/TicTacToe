/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data_project;
import static data_project.Data_project.waitingTime;

public class Queue implements Runnable{
    Task [] arrQ;
    int rear;
    int front;
    int size;
    java.lang.Thread t;

    public Queue(int size) {
        this.size = size;
        this.arrQ = new Task[this.size];
        this.rear = -1;
        this.front = -1;
        t = new java.lang.Thread(this);
        t.start(); 
    }

    public void run() {
        Computer computer1 = new Computer(this, "computer 1");
        Computer computer2 = new Computer(this, "computer 2");

        while (true) {
            try {
                 if(!this.isEmpty()){
                    if(computer1.task == null){
                        computer1.setTask(this.deQueue());
                    } else if (computer2.task==null){
                        computer2.setTask(this.deQueue());
                    }
                    else{
                     waitingTime++;
                 }
                }
                java.lang.Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isFull () {
        return ((rear+1) % size == front);
    }

    public boolean isEmpty () {
        return (front == -1 && rear == -1);
    }

    public void enQueue (Task t) {
        if(isFull()){
            return;
        }
        else if(isEmpty()){
            front = rear = 0;
        } else {
            rear = (rear+1) % size;
        }
        arrQ[rear] = t;
    }

    public Task deQueue () {
        int temp = front;
        if(isEmpty()){
            System.out.println("queue is empty");
            return null;}
        else if(front == rear) {
            front = rear = -1;
        } else {
            front=(front+1)%size;
        }
        
        return this.arrQ[temp];
    }

    public void printQueue () { 
       int i;
        if(isEmpty()){
            System.out.println("Queue ia Empty");
        }else{
            
        for ( i =front; i !=rear; i=(i+1)%this.size){
            System.out.println(this.arrQ[i].getTime()+" ");
            System.out.println(this.arrQ[i].getTime());
       
        }
       
      }

    }
}
