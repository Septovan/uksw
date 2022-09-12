/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl_abstractfactorypattern;

import pl_abstractfactorypattern.color.Blue;
import pl_abstractfactorypattern.color.Green;
import pl_abstractfactorypattern.color.Red;

/**
 *
 * @author Septovan D. S. Saian
 */
public class ColorFactory extends AbstractFactory {

    @Override
    Color getColor(String color) {
        if (color == null)
            return null;
        
        if (color.equalsIgnoreCase("RED")) {
            return new Red();
        }
        else if (color.equalsIgnoreCase("GREEN")) {
            return new Green();
        }
        else if (color.equalsIgnoreCase("BLUE")) {
            return new Blue();
        }
        
        return null;
    }

    @Override
    Shape getShape(String shape) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
