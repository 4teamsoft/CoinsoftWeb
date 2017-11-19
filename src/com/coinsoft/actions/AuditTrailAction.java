package com.coinsoft.actions;

import com.opensymphony.xwork2.ActionSupport;

import javax.xml.soap.Detail;
import java.util.Date;

public class AuditTrailAction extends ActionSupport{
    private String type;
    private Date dateTime;
    private String affectedTable;
    private String detail;
    private String status;

    public AuditTrailAction(String type, Date dateTime, String affectedTable, String detail, String status) {
        this.type = type;
        this.dateTime = dateTime;
        this.affectedTable = affectedTable;
        this.detail = detail;
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {

        this.type = type;
    }

    public Date getDateTime (){return dateTime;}

    public void setDateTime(Date dateTime){

        this.dateTime = dateTime;
    }

    public String getAffectedTable(){ return affectedTable; }

    public void setAffectedTable(String affectedTable){

        this.affectedTable = affectedTable;
    }

    public String getDetail() { return detail; }

    public void setDetail(String detail){

        this.detail = detail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {

        this.status = status;
    }

    public String execute() {
        return SUCCESS;
    }
}
