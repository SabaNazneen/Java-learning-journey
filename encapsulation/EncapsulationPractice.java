package three.classdemo.encapsulation;

public class EncapsulationPractice {
    private int age ;
    private String name;
    private int salary;

   /* EncapsulationPractice(int age, String name, int salary){
        this.setAge(age);
        this.name = name;
        this.salary=salary;
    }
*/
     EncapsulationPractice() {
        this.setAge(age);
       // this.age = age;
        this.setName(name);
        this.setSalary(salary);
    }

    public int getAge()
    {
        return age;
    }
    public void setAge(int age){
        if(age<18)
        {
            System.out.println("Invalid age must be above 18");
        }else {
            this.age=age;
        }
    }
    public String getName()
    {

        return name;
    }
    public void setName(String name)
    {
       /* if(name.length()<3)
        {
            System.out.println("Invalid name must be above 6");
        }*/
        this.name = name;
    }
    public int getSalary()
    {
        return salary;
    }
    public void setSalary(int salary)
    {
        if(salary<10){
            System.out.println("Invalid salary must be above 10");
        }else {
            this.salary = salary;
        }
    }
}
class demo
{
    static void main() {
      /*  EncapsulationPractice obj1 = new EncapsulationPractice(17,"Saba",30000);
        System.out.println(obj1.getName());
        System.out.println(obj1.getSalary());
        System.out.println(obj1.getAge());*/
        EncapsulationPractice obj2 = new EncapsulationPractice();
        obj2.setName("Farah");
        obj2.setAge(20);
        obj2.setSalary(40000);
        System.out.println(obj2.getName());
        System.out.println(obj2.getSalary());
        System.out.println(obj2.getAge());
    }
}