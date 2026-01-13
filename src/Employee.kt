enum class Priority {
    LOW,
    MEDIUM,
    HIGH
}
class Employee {
    private var fullName: String = ""
        //get()=fullName
    private var position: String = ""
        //get()=position
    private var salary: Int = 0
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
}
data class Task(
    val title: String,
    val description: String,
    val priority: Priority,
    var isCompleted: Boolean = false
)