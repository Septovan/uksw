/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pl_abstractfactorypattern;

/**
 *
 * @author Septovan D. S. Saian
 */
public class PL_AbstractFactoryPattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");
        AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");
        
        Shape shape1 = shapeFactory.getShape("Circle");
        shape1.draw();
        
        Color color1 = colorFactory.getColor("RED");
        color1.fill();
    }
    
}
