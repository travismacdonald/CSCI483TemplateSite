/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.csci483.myprojectname.controller;

import ca.csci483.myprojectname.utils.DataUtils;
import ca.csci483.myprojectname.model.User;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.context.RequestScoped;


/**
 *
 * @author osoufan
 */
@RequestScoped
@Named("sessionBean1")
public class SessionBean1 implements Serializable {

    private final ApplicationBean1 ab = (ApplicationBean1) DataUtils.findBean("applicationBean1");
    private User currentUser = null;
    
    
    private String operation;
    private Map<String, String> operations = new HashMap<>();

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Map<String, String> getOperations() {
        return operations;
    }

    public void setOperations(Map<String, String> operations) {
        this.operations = operations;
    }
    
    @PostConstruct
    public void initList(){
        //cities
        operations = new HashMap<>();
        operations.put("sum", "Sum");
        operations.put("subtract", "subtraction");
        operations.put("multiply", "multiplication");
        operations.put("divide", "dvision");
    }
    
    private double total = 0.0;

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    public void reset(){
        total = 0.0;
        history = "";
    }
    
    private String history = "";

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }
    
    public double calculate(){
        switch (operation) {
            case "Sum":
                if(history.equals("")){
                    history += "(" + Double.toString(total) + " + " + Double.toString(number) + ")";
                }else{
                    history = "(" + history +  " + " + Double.toString(number) + ")";
                }
                total += number;
                break;
            case "subtraction":
                if(history.equals("")){
                    history += "(" + Double.toString(total) + " - " + Double.toString(number) + ")";
                }else{
                    history = "(" + history +  " - " + Double.toString(number) + ")" ;
                }
                total -= number;
                break;
            case "multiplication":
                if(history.equals("")){
                    history += "(" + Double.toString(total) + " * " + Double.toString(number) + ")" ;
                }else{
                    history = "(" + history +  " * " + Double.toString(number) + ")" ;
                }
                total *= number;
                break;
            case "dvision":
                if(history.equals("")){
                    history += "(" + Double.toString(total) + " / " + Double.toString(number) + ")";
                }else{
                    history = "(" + history +  " / " + Double.toString(number) + ")" ;
                }
                total /= number;
                break;
            default:
                break;
        }
        return total;
    }
    
    private double number = 0.0;

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }


    /**
     * <p>
     * Construct a new session data bean instance.</p>
     */
    public SessionBean1() {
    }

    //More themes at: https://repository.primefaces.org/org/primefaces/themes/
    private String theme = "smoothness";

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
    
}
