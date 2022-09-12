/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl_abstractfactorypattern;

import pl_abstractfactorypattern.shape.Circle;
import pl_abstractfactorypattern.shape.Rectangle;
import pl_abstractfactorypattern.shape.Square;

/**
 *
 * @author Septovan D. S. Saian
 */
public class ShapeFactory extends AbstractFactory {

    @Override
    Color getColor(String color) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    Shape getShape(String shape) {
        if (shape == null)
            return null;
        
        if (shape.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        }
        else if (shape.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        else if (shape.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        }
        
        return null;
    }
    
}
