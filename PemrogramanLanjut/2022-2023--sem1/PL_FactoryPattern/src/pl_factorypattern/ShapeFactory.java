/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl_factorypattern;

/**
 *
 * @author Septovan D. S. Saian
 */
public class ShapeFactory {
    public Shape getShape(String shapeType) {
        if (shapeType == null)
            return null;
        
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        }
        else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        }
        
        return null;
    }
}
