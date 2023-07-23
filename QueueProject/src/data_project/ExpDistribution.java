/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data_project;

/**
 *
 * @author Moustafa
 */
public class ExpDistribution {
    
    double lambda = 25;
    double num = Math.random();
    double value = -1 * Math.log(num) * lambda;

    public double getExpDistribution(){
        return value;
    
  }
}