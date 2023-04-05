import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Formatter;
/**

Класс Main содержит точку входа в программу.
В методе main происходит чтение данных из файла "employee.txt",
создание объектов класса Employee и запись этих объектов в массив productionworkers.
Далее вызывается метод writeTable каждого объекта для вывода информации в формате таблицы.
В случае ошибки чтения из файла выводится сообщение об ошибке.
*/
public class Main

{
    public static void main(String[] args)
    {

        Employee[] productionworkers = new Employee[50];

        try
        {
/// Создаем объект FileReader для чтения файла "employee.txt" и указываем путь

            FileReader fileReader = new FileReader("C:\\Users\\Kozochka\\IdeaProjects\\lab0_ASDC\\src\\employee.txt");
            // // Создаем объект BufferedReader для более эффективного чтения из файла
BufferedReader bufferedReader = new BufferedReader(fileReader);
// Читаем данные из файла и создаем объекты класса Employee
            for(int i = 0; i < productionworkers.length; i++)
            {
                productionworkers[i] = new Employee();
                productionworkers[i].readingFile(bufferedReader);
            }


            Formatter form = new Formatter(System.out);

// Выводим информацию о каждом объекте в формате таблицы
            for(int i = 0; i < productionworkers.length; i++)
            {
                productionworkers[i].writeTable(form);
            }
// Закрываем объект BufferedReader
            bufferedReader.close();
        }

        catch (IOException e)
        {
/// В случае ошибки выводим сообщение об ошибке
            System.out.println("Error " + e.getMessage());
        }
    }
}
