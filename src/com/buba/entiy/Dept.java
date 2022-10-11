package com.buba.entiy;

public class Dept {
    private Integer deptId;
    private String deptNumber;
    private String deptName;
    private String Province;
    private Integer peopleCounting;
    private String Described;

    public Dept(){

    }

    public Dept(Integer deptId, String deptNumber, String deptName, String province, Integer peopleCounting, String described) {
        this.deptId = deptId;
        this.deptNumber = deptNumber;
        this.deptName = deptName;
        Province = province;
        this.peopleCounting = peopleCounting;
        Described = described;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptNumber() {
        return deptNumber;
    }

    public void setDeptNumber(String deptNumber) {
        this.deptNumber = deptNumber;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getProvince() {
        return Province;
    }

    public void setProvince(String province) {
        Province = province;
    }

    public Integer getPeopleCounting() {
        return peopleCounting;
    }

    public void setPeopleCounting(Integer peopleCounting) {
        this.peopleCounting = peopleCounting;
    }

    public String getDescribed() {
        return Described;
    }

    public void setDescribed(String described) {
        Described = described;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptId=" + deptId +
                ", deptNumber='" + deptNumber + '\'' +
                ", deptName='" + deptName + '\'' +
                ", Province='" + Province + '\'' +
                ", peopleCounting=" + peopleCounting +
                ", Described='" + Described + '\'' +
                '}';
    }
}
