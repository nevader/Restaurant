package DataTypes;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Person {

    private String name;
    private String phone;

    public Person(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }
    public String getPhone() {
        return phone;
    }





    public abstract static class Employee extends Person {

        static AtomicInteger employeeID = new AtomicInteger();
        private int id;
        private Calendar calendar = Calendar.getInstance();
        private Date date;

        public Employee(String name, String phone) {
            super(name, phone);
            id = employeeID.incrementAndGet();
            this.date = calendar.getTime();
        }

        public int getId() {
            return id;
        }
        public Date getDate() {
            return date;
        }
    }
}
