object Leking2 extends App{

    /* Personklassedefinisjon */
    case class Person(age: Int)

    val people = List(Person(23), Person(15), Person(18))

    /* deler en liste i to basert på et kriterie utrykt ved en anonym/lambda funksjon */
    val (minors, adults) = people partition(p => p.age < 18)

    println(adults)
    //List(Person(23), Person(18))

}
