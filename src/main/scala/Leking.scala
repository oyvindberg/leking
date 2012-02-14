object Leking extends App {

    val isEven: (Int) => Boolean = num => num % 2 == 0

    println(List(2, 4, 5, 6).forall(isEven))
    //false

    println(List(2, 4, 8, 6).forall(isEven))
    //true

    println(List(1,3,5,8).exists(num => !isEven(num)))
    //true
    
    println(List(5,6).filter(isEven))
    //List(6)


}
