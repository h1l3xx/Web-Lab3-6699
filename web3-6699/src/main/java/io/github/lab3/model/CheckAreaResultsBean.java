package io.github.lab3.model;

import io.github.lab3.db.DAOFactory;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.PartialViewContext;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Objects;


public class CheckAreaResultsBean implements Serializable {
    private SelectXBean selectXBean;
    private SelectYBean selectYBean;
    private SelectRBean selectRBean;

    private LinkedList<CheckAreaBean> results;

    private CheckAreaBean last;

    public CheckAreaResultsBean() {
        super();
        results = new LinkedList<>();
        // fill db with values
        try {
            results = new LinkedList<>(DAOFactory.getInstance().getResultDAO().getAll());
        } catch (SQLException e) {
            System.err.println("ERROR" + e);
        }
    }


    public LinkedList<CheckAreaBean> getResults() {
        results = new LinkedList<>();
        // fill db with values
        try {
            return results = new LinkedList<>(DAOFactory.getInstance().getResultDAO().getAll());
        } catch (SQLException e) {
            return results;
        }
    }
    public CheckAreaBean getLast(){
        return results.getLast();
    }

    public void setResults(LinkedList<CheckAreaBean> results) {
        this.results = results;
    }

    public void newResult(final double x, final double y, final double r) {
        final CheckAreaBean currentResult = new CheckAreaBean();
        final long startExec = System.nanoTime();
        final boolean result = AreaResultChecker.getResult(x, y, r);
        final long endExec = System.nanoTime();
        final long executionTime = endExec - startExec;
        currentResult.setX(x);
        currentResult.setY(y);
        currentResult.setR(r);
        currentResult.setResult(result);
        currentResult.setExecutedAt(LocalDateTime.now());
        currentResult.setExecTime(executionTime);
        try {
            DAOFactory.getInstance().getResultDAO().create(currentResult);
        } catch (SQLException ignored) {}

        results.addFirst(currentResult);
    }


    public void clearResults() {
        results.clear();
        try {
            DAOFactory.getInstance().getResultDAO().clear();
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
        } catch (SQLException | IOException ignored) {}
    }
}
