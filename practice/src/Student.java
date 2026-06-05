public class Student implements Comparable{

    public Integer id;
    public Integer marks;

    public Student(int id,int marks)
    {
        this.id=id;
        this.marks=marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", marks=" + marks +
                '}';
    }

    @Override
    public int compareTo(Object other) {

        return this.marks-((Student) other).marks;
    }
}
