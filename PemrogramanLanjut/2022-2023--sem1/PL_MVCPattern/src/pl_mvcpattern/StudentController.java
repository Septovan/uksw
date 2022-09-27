/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl_mvcpattern;

/**
 *
 * @author Septovan D. S. Saian
 */
public class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public void setStudentName(String name) {
        model.setName(name);
    }
    
    public String getStudentName() {
        return model.getName();
    }
    
    public void setStudentRollNo(String rollNo) {
        model.setRollNo(rollNo);
    }
    
    public String getStudentRollNo(){
        return model.getRollNo();
    }
    
    public void updateView() {
        view.printStudentDetails(model.getName(), model.getRollNo());
    }
}
