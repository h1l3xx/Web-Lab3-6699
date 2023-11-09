package io.github.lab3.model;


import javax.faces.application.FacesMessage;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;


import java.io.Serializable;

public class SelectRBean implements Serializable {
    private Double value;

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
        System.out.println(value);

    }

    public void validateSelectR(FacesContext facesContext,
                                UIComponent uiComponent, Object o) {
        if (o == null) {
            value = null;

            FacesMessage message = new FacesMessage("Please, select value!");
            throw new ValidatorException(message);
        }
    }
    public void valueByDefault() {
        if (value == null){
            value = 1.0;
            System.out.println("set value by default for R: 1.0");
        }
    }
}
