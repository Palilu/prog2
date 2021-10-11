package ejercicio03;

import java.util.List;

public class Member {
    private String fname;
    private String lname;
    private Integer age;
    private Boolean upToDate;
    private List<FieldRent> fieldRents;

    public Member(String fname, String lname, Integer age, Boolean upToDate, List<FieldRent> fieldRents) {
        this.fname = fname;
        this.lname = lname;
        this.age = age;
        this.upToDate = upToDate;
        this.fieldRents = fieldRents;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public Integer getAge() {
        return age;
    }

    public Boolean getUpToDate() {
        return upToDate;
    }

    public List<FieldRent> getFieldRents() {
        return fieldRents;
    }

    @Override
    public String toString() {
        return "Member{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", age=" + age +
                ", upToDate=" + upToDate +
                ", fieldRents=" + fieldRents +
                '}';
    }
}
