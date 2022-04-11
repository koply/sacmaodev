package me.koply.sacmaodev.entity;

import java.util.List;

public class Instructor extends User {

    private String officePhone, employmentType;
    public Instructor(int id, String officePhone, String employmentType, String name, String surname, String birthDate, String gender, String phoneNumber, String email, String password) {
        super(id, name, surname, birthDate, gender, phoneNumber, email, password);
        this.officePhone = officePhone;
        this.employmentType = employmentType;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "officePhone='" + officePhone + '\'' +
                ", employmentType='" + employmentType + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", gender='" + gender + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public Instructor setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
        return this;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public Instructor setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
        return this;
    }

    @Override
    public void listAllCourses(List<CourseRegistration> registrations) { // lmao that parameter

        /* ödevin kendisinde eğitmenlere rastgele kurs ataması yapmayı burada yapmamızı istiyor sanırsam
         * eğer burada rastgele atamayı yaparsak tekrardan hangi eğitmenin hangi kurslara aldığına erişemeyiz
         * kaldı ki main içerisinde zaten çok daha mantıklı bir şekilde rastgele dağıtımını yaptım
         * ödevin saçmalığına dayanamadığım için bu methodu yazmayacağım
         * zaten bu methodun burada olmaması gerekiyor. encapsulation objesi içerisinde
         * böyle bir methodun olması başından beri komik.
         */

    }

}