package io.github.lab3.model;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import java.io.Serializable;


public class SelectYBean implements Serializable {
    private Double value = 0.0;


    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }



    public void validateSelectY(FacesContext facesContext,
                                UIComponent uiComponent, Object o) {
        if (o == null || Double.parseDouble(o.toString()) < -5 || Double.parseDouble(o.toString()) > 5) {
            FacesMessage message = new FacesMessage("Неверный формат данных в Y");
            throw new ValidatorException(message);
        }
    }

}
