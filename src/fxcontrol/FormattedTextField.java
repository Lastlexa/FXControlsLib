/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxcontrol;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.TextField;

/**
 *
 * @author Alex
 */
public class FormattedTextField extends TextField {
    
    private final StringProperty format;
    private final IntegerProperty limit;
    
    public FormattedTextField(){
        this.format = new SimpleStringProperty(".*");
        this.limit = new SimpleIntegerProperty(0);
    }
    
    public String getFormat() {
        return formatProperty().get();
    }

    public void setFormat(String value) {
        formatProperty().set(value);
    }

    public StringProperty formatProperty() {
        return this.format;
    }
    
    public Integer getLimit() {
        return limitProperty().get();
    }

    public void setLimit(Integer value) {
        limitProperty().set(value);
    }

    public IntegerProperty limitProperty() {
        return this.limit;
    }
    
    private boolean matches(String text){
        boolean limit = true;
        if (this.getLimit() > 0)
            if ( (this.getText().length() + text.length()) > this.getLimit()) 
                limit = false;
 //System.out.println((limit));  
        return text.matches( this.getFormat() ) && limit; 
    }

    @Override public void replaceText(int start, int end, String text) {
        // If the replaced text would end up being invalid, then simply
        // ignore this call!
        if ((text == "") || this.matches(text)) {
            super.replaceText(start, end, text);
        }
    }
 
    @Override public void replaceSelection(String text) {
        if (this.matches(text)) {
            super.replaceSelection(text);
        }
    }
    
}
