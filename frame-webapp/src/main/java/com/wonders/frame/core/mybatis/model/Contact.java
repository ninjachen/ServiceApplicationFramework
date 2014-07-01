package com.wonders.frame.core.mybatis.model;

public class Contact {
    private Integer id;

    private String lastName;

    private String firstName;

    private String wkMail;

    private String psMail;

    private String homePhone;

    private String wkPhone;

    private String cellPhone;

    private String loc;

    private String zip;

    private Integer groupId;

    private Integer ownerId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName == null ? null : lastName.trim();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName == null ? null : firstName.trim();
    }

    public String getWkMail() {
        return wkMail;
    }

    public void setWkMail(String wkMail) {
        this.wkMail = wkMail == null ? null : wkMail.trim();
    }

    public String getPsMail() {
        return psMail;
    }

    public void setPsMail(String psMail) {
        this.psMail = psMail == null ? null : psMail.trim();
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone == null ? null : homePhone.trim();
    }

    public String getWkPhone() {
        return wkPhone;
    }

    public void setWkPhone(String wkPhone) {
        this.wkPhone = wkPhone == null ? null : wkPhone.trim();
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone == null ? null : cellPhone.trim();
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc == null ? null : loc.trim();
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip == null ? null : zip.trim();
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }
}