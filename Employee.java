import java.io.BufferedReader;
import java.io.IOException;
import java.util.Formatter;
/**

 Класс, представляющий сотрудника организации.В него входит имя, фамимлия,
 профессия, стаж, опыт работы и IDNP
 */
public class Employee implements Comparable<Employee> {
    private String name;
    private String surname;
    private String position;
    private String category;
    private int experience;
    private int IDNP;
    /**
     Конструктор класса Employee, создающий объект сотрудника с значениями по умолчанию.
     */
    public Employee() {
        name = "None";
        surname = "None";
        position = "None";
        category = "None";
        experience = 0;
        IDNP =0;
    }
    /**

     Конструктор класса Employee, который создает копию объекта.
     @param other другой объект класса Employee, который нужно скопировать.
     */
    public Employee(Employee other) {
        name = other.name;
        surname = other.surname;
        position = other.position;
        category = other.category;
        experience = other.experience;
        IDNP = other.IDNP;
    }
    /**
     Метод, создающий копию объекта.
     @return новый объект Employee, идентичный текущему.
     */
    public Employee clone() {
        return new Employee(this);
    }
    /**
     Метод, который проверяет равны ли два объекта класса Employee.
     @param other другой объект класса Employee, с которым нужно сравнить текущий объект.
     @return возвращает true, если объекты равны, и  возвращает false в противном случае.
     */
    public boolean equal(Employee other) {
        return (name.equals(other.name) &&
                surname == other.surname &&
                position.equals(other.position) &&
                category.equals(other.category) &&
                experience == other.experience &&
                IDNP == other.IDNP );
    }
    /**
     Метод, считывающий данные о сотруднике из файла.
     @throws IOException если происходит ошибка ввода-вывода.
     */
    public void readingFile(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        String[] fields = line.split(", ");

        name = fields[0];
        surname = fields[1];
        position = fields[2];
        category = fields[3];
        experience = Integer.parseInt(fields[4]);
        IDNP = Integer.parseInt(fields[4]);
    }
    /**
     Метод, выводящий данные о сотруднике в консоль.
     */
    public void writeElement() {
        System.out.println(name + ", " +
                surname + ", " +
                position + ", " +
                category + ", " +
                experience + ", " +
                IDNP);
    }
    /**
     Это метод, который форматирует данные о сотруднике в виде таблицы.
     @param formatter используется для форматирования вывода.
     */
    public void writeTable(Formatter formatter) {
        formatter.format("Имя: %-20s Фамилия: %-20s Должность: %-50s оклад: %-10s Стаж:%-15d IDNP: %-20d\n", name, surname, position, category, experience, IDNP);
    }
/**
 Метод, возвращающий имя сотрудника */
    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Employee other) {
        return this.name.compareTo(other.getName());
    }
}