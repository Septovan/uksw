/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pl_mvcpattern;

/**
 *
 * @author Septovan D. S. Saian
 */
public class PL_MVCPattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Student model = retriveStudentFromDatabase();        
        StudentView view = new StudentView();
        
        StudentController controller = new StudentController(model, view);
        
        controller.updateView();
        
        controller.setStudentName("Ronaldowati");
        
        controller.updateView();
    }
    
    private static Student retriveStudentFromDatabase() {
        Student student = new Student();
        student.setName("Micah");
        student.setRollNo("10");
        return student;
    }
    
}
