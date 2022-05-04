package DataTypes;

import java.util.concurrent.atomic.AtomicInteger;

public class Person {

    private final String name;
    private final String phone;

    public Person(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }
    public String getPhone() {
        return phone;
    }



    public static class Employee extends Person {

        static AtomicInteger employeeID = new AtomicInteger();
        private final int id;

        public Employee(String name, String phone) {
            super(name, phone);
            id = employeeID.incrementAndGet();
        }

        public int getId() {
            return id;
        }
    }
}
