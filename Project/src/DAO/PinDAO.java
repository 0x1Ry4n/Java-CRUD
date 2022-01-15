/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.PinDTO;

/**
 *
 * @author Ryan
 */
public class PinDAO {
    PinDTO objPinDTO = new PinDTO();
    
    private int pin = objPinDTO.getKey();
    

    
    public int getPin(PinDTO objPin) {
        if(objPin.getPin() == pin) {
            return this.pin;
        } else {
            return 0;
        }
    }
}
