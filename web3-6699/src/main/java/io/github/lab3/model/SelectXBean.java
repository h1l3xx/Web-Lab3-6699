package io.github.lab3.model;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;


import java.io.Serializable;


public class SelectXBean implements Serializable {
    private boolean selectedM4;
    private boolean selectedM3;
    private boolean selectedM2;
    private boolean selectedM1;
    private boolean selected0;
    private boolean selected1;
    private boolean selected2;
    private boolean selected3;
    private boolean selected4;
    private final SelectX lastSelected = new SelectX();

    public SelectXBean() {
        lastSelected.lastValue = -1000;
    }

    public void setSelectedM4(boolean selectedM4) {
        this.selectedM4 = selectedM4;
    }
    public void setSelectedM3(boolean selectedM3) {
        this.selectedM3 = selectedM3;
    }
    public void setSelectedM2(boolean selectedM2) {
        this.selectedM2 = selectedM2;
    }
    public void setSelectedM1(boolean selectedM1) {
        this.selectedM1 = selectedM1;
    }
    public void setSelected0(boolean selected0) {
        this.selected0 = selected0;
    }
    public void setSelected1(boolean selected1) {
        this.selected1 = selected1;
    }
    public void setSelected2(boolean selected2) {
        this.selected2 = selected2;
    }
    public void setSelected3(boolean selected3) {
        this.selected3 = selected3;
    }
    public void setSelected4(boolean selected4) {
        this.selected4 = selected4;
    }

    public boolean isSelectedM4() {
        return selectedM4;
    }

    public boolean isSelectedM3() {
        return selectedM3;
    }


    public boolean isSelectedM2() {
        return selectedM2;
    }


    public boolean isSelectedM1() {
        return selectedM1;
    }


    public boolean isSelected0() {
        return selected0;
    }


    public boolean isSelected1() {
        return selected1;
    }
    public boolean isSelected2() {
        return selected2;
    }
    public boolean isSelected3() {
        return selected3;
    }
    public boolean isSelected4() {
        return selected4;
    }


    public SelectX getLastSelected() {
        return lastSelected;
    }

    public double getValue() {
        return lastSelected.getValue();
    }
    public void valueByDefault(){
        if (lastSelected.lastValue == -1000){
            lastSelected.setValue(0);
            System.out.println("Set value by default for X: 0");
        }
    }

    public void valueChanged(double value) {
        lastSelected.lastValue = value;
    }

    public void validateSelectX(FacesContext context, UIComponent component, Object value) {
        if (lastSelected.getValue() == null) {
            FacesMessage message = new FacesMessage("Please, select at least one checkbox!");
            throw new ValidatorException(message);
        }
    }
}
