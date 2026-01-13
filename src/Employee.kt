enum class Priority {
    LOW,
    MEDIUM,
    HIGH
}
class Employee:ReportGenerator {
    var currentTask: Task? =null
    private var fullName: String =""
        //get()=fullName
    private var position: String =""
        //get()=position
    private var salary: Int =0
        //get()=salary
        set(value){
            if (value<0){
                println("Error")
                field=0
            }
        }
    private var yearsOfExperience: Int = 0
        //get()=yearsOfExperience
        set(value){
            field=value.coerceIn(0,50)
        }
    fun Name(name:String){
        fullName=name
    }
    fun Posit(a:String){
        position=a
    }
    fun Salary(a:Int){
        salary=a
    }
    fun Year(a:Int){
        yearsOfExperience=a
    }
    fun Print_fullName(){
        println(fullName)
    }
    fun Print_position(){
        println(position)
    }
    fun Print_salary(){
        println(salary)
    }
    fun Print_yearsOfExperience(){
        println(yearsOfExperience)
    }
    override fun generateReport(): String {
        return "$fullName,$position,$salary,$yearsOfExperience"
    }
    fun assignTask(newTask: Task) {
        if (currentTask!=null&&currentTask?.isCompleted==false) {
            println("Сотрудник уже занят задачей ${currentTask?.title}")
        } else {
            currentTask=newTask
            println("Задача назначена сотруднику")
        }
    }
}
fun main() {
    val employee = Employee()

    employee.Name("Ivanov Ivan Ivanovich")
    employee.Posit("Developer")
    employee.Salary(50000)
    employee.Year(5)

    println("Correct values:")
    println("Full Name: ${employee.Print_fullName()}")
    println("Position: ${employee.Print_position()}")
    println("Salary: ${employee.Print_salary()}")
    println("Work Experience: ${employee.Print_yearsOfExperience()}")

    println("\n--- Testing incorrect values ---")

    println("\nAttempt to set salary -10000:")
    employee.Salary(-10000)
    println("Current salary: ${employee.Print_salary()}")

    println("\nAttempt to set work experience 60 years:")
    employee.Year(60)
    println("Current work experience: ${employee.Print_yearsOfExperience()}")

    println("\nAttempt to set work experience -5 years:")
    employee.Year(-5)
    println("Current work experience: ${employee.Print_yearsOfExperience()}")

    println("\nSetting correct salary 75000:")
    employee.Salary(75000)
    println("Current salary: ${employee.Print_salary()}")

    println("\n--- Checking getters ---")
    println("Full Name via getter: ${employee.Print_fullName()}")
    println("Salary via getter: ${employee.Print_salary()}")

    val task1 = Task(
        title = "Изучить Kotlin",
        description = "Изучить основы языка Kotlin",
        priority = Priority.HIGH
    )

    val task2 = Task(
        title = "Изучить Kotlin",
        description = "Изучить основы языка Kotlin",
        priority = Priority.HIGH
    )

    val task3 = Task(
        title = "Изучить Kotlin",
        description = "Изучить основы языка Kotlin",
        priority = Priority.MEDIUM
    )

    println("Task 1: $task1")
    println("Task 2: $task2")
    println("Task 3: $task3")

    println("task1.toString() = \"${task1.toString()}\"")

    println("task1.equals(task2): ${task1.equals(task2)}")
    println("task1.equals(task3): ${task1.equals(task3)}")

    println("Хэш-код task1: ${task1.hashCode()}")
    println("Хэш-код task2: ${task2.hashCode()}")
    println("Хэш-код task3: ${task3.hashCode()}")

    println("task1.hashCode() == task2.hashCode(): ${task1.hashCode() == task2.hashCode()}")
    println("task1.hashCode() == task3.hashCode(): ${task1.hashCode() == task3.hashCode()}")

    val task1Copy = task1.copy(priority = Priority.LOW)
    println("Копия task1 с изменением приоритета на LOW:")
    println("task1Copy = $task1Copy")

    val devDep = DevelopmentDepartment()
    val testDep = TestingDepartment()
    devDep.printDepartmentGoal()
    testDep.printDepartmentGoal()

    val reportGenerators: List<ReportGenerator> = listOf(employee,devDep)
    reportGenerators.forEach { item->
        println(item.generateReport())
    }

    val task4 = Task(
        title = "Разработать новый модуль авторизации",
        description = "Реализовать OAuth 2.0 аутентификацию",
        priority = Priority.HIGH
    )
    val task5 = Task(
        title = "Исправить баг в платежной системе",
        description = "Ошибка при обработке возвратов",
        priority = Priority.HIGH
    )
    val task6 = Task(
        title = "Обновить документацию API",
        description = "Добавить новые endpoints в документацию",
        priority = Priority.LOW
    )
    employee.assignTask(task4)
    employee.assignTask(task5)
    employee.assignTask(task6)














}
data class Task(
    val title: String,
    val description: String,
    val priority: Priority,
    var isCompleted: Boolean = false
)
abstract class Department{
    abstract val departmentName: String
    abstract fun printDepartmentGoal()
}
class DevelopmentDepartment(override val departmentName: String = "Отдел разработки"):Department(),ReportGenerator{
    override fun printDepartmentGoal() {
        println("$departmentName должен писать чистый код")
    }
    override fun generateReport(): String {
        return "${printDepartmentGoal()}"
    }
}
class TestingDepartment(override val departmentName: String = "Отдел тестирования"):Department(){
    override fun printDepartmentGoal() {
        println("$departmentName обязаны находить все баги")
    }
}
interface ReportGenerator{
    fun generateReport(): String
}
