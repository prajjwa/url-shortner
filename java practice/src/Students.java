public class Students {

    private String name;
    private String email;
    private Integer priorityLevel;

    public Students(String name, String email, Integer priorityLevel) {
        this.name = name;
        this.email = email;
        this.priorityLevel = priorityLevel;
    }

    @Override
    public String toString() {
        return "Students{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", priorityLevel=" + priorityLevel +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Integer getPriorityLevel() {
        return priorityLevel;
    }
}
