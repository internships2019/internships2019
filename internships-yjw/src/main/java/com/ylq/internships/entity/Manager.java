package com.ylq.internships.entity;

/**
 * 管理人员实体
 */
public class Manager {
    //管理人员账号
    private String manAccount;
    //管理人员昵称
    private String manName;
    //管理人员密码
    private String manPassword;
    //管理人员单位名称
    private String manNuitName;
    //管理人员身份(系统管理员，学校管理员，企业管理员)
    private String manStatus;

    public Manager() {
    }

    public Manager(String manAccount, String manName, String manPassword, String manNuitName, String manStatus) {
        this.manAccount = manAccount;
        this.manName = manName;
        this.manPassword = manPassword;
        this.manNuitName = manNuitName;
        this.manStatus = manStatus;
    }

    public String getManAccount() {
        return manAccount;
    }

    public void setManAccount(String manAccount) {
        this.manAccount = manAccount;
    }

    public String getManName() {
        return manName;
    }

    public void setManName(String manName) {
        this.manName = manName;
    }

    public String getManPassword() {
        return manPassword;
    }

    public void setManPassword(String manPassword) {
        this.manPassword = manPassword;
    }

    public String getManNuitName() {
        return manNuitName;
    }

    public void setManNuitName(String manNuitName) {
        this.manNuitName = manNuitName;
    }

    public String getManStatus() {
        return manStatus;
    }

    public void setManStatus(String manStatus) {
        this.manStatus = manStatus;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "manAccount='" + manAccount + '\'' +
                ", manName='" + manName + '\'' +
                ", manPassword='" + manPassword + '\'' +
                ", manNuitName='" + manNuitName + '\'' +
                ", manStatus='" + manStatus + '\'' +
                '}';
    }
}
