/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl_builderpattern;

/**
 *
 * @author Septovan D. S. Saian
 */
public abstract class ColdDrink implements Item {
    
    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
    
}
