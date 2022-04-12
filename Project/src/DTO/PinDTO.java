/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Ryan
 */
public class PinDTO {
    private int pin;
    private static int key = 1421;
    
    public void setPin(int pin) {
        this.pin = pin;
    }
    
    public int getPin() {
        return this.pin;
    }
    
    public int getKey() {
        return this.key;
    }
}
