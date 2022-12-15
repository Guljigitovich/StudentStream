import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Student student =  new Student("Asan",23,Gender.MALE,2000,"Asanov");
        Student student1 = new Student("Samat",21,Gender.MALE,3000,"Aktanov");
        Student student2 = new Student("Asel",20,Gender.FEMALE,3000,"Kanatova");
        Student student3 = new Student("Klara",24,Gender.FEMALE,3500,"Samatova");

        ArrayList<Student> students = new ArrayList<>(
                Arrays.asList(student1,student2,student,student3));
        System.out.println("---Method 2---Жашы 15 тен жогору жана акчасы 2000 ден жогору балдарды чыгаруу");
        students.stream().filter(z->z.getGender().equals(Gender.MALE)).filter(s->s.getAge()>15&&s.getMoney()>2000).forEach(System.out::println);
        System.out.println("---Method 5---Студенттерди аты мн чыгаруу");

        students.stream().map(Student::getName).forEach(System.out::println);
        System.out.println("---Method 8---Канча студент бар чыгарып беруу");

        System.out.println(students.stream().map(Student::getName).count());
        System.out.println("---Method 4---Акчасы коп кыздарды чыгарып беруу");

        Student maxF = students.stream().filter(x->x.getGender().equals(Gender.FEMALE)).max(Comparator.comparing(Student::getMoney)).orElseThrow();
        System.out.println(maxF);
        System.out.println("---Method 3---Акчасы коп студентти чыгарып беруу");
        Student max =students.stream().max(Comparator.comparing(Student::getMoney)).orElseThrow();
        System.out.println(max);

        System.out.println("---Method 7---Биринчи студентти чыгарып беруу");

        Optional<Student> result = students.stream().findFirst();
        System.out.println(result);
        System.out.println("---Method 6---Акчаларына 1000 сом кошуу");

        students.stream().map(s->s.getMoney()+1000).forEach(System.out::println);

        System.out.println("---Method 9--Балдар, кыздарды оз озунчо массивге салуу");
        System.out.println("Students boy : ");
        students.stream().filter(a->a.getGender().equals(Gender.MALE)).toList().forEach(System.out::println);
        System.out.println("Students girl : ");
        students.stream().filter(b->b.getGender().equals(Gender.FEMALE)).toList().forEach(System.out::println);

        System.out.println("--Method 1--Аты А менен башталгандары чыгаруу");
        students.stream().filter(s->s.getName().startsWith("A")).forEach(System.out::println);
    }
}