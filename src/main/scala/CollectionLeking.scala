object CollectionLeking extends App {

    /* viser hvordan vi på en typesikker måte kan bruke partition og pattern matching for å trekke ut integere
    *   av en blandet liste, og deretter å gjøre den om til en liste med strenger */

    val blandetListe = List(1, "a", 'c', 2, "asdasd", 42, null)

    val (intList: List[Int], restList: List[Any]) = blandetListe.partition {
        p => p match {
            case p: Int => true
            case _ => false
        }
    }
    println(intList)
    //List(1, 2, 42)

    intList.map(i => "Tallet er " + i).foreach(println)
    // Tallet er 1
    // Tallet er 2
    // Tallet er 42

    /**
     * Viser hvordan man kan flate ut en liste med underlister, så finne absoluttverdier av alle elementene, og
     *  til slutt sortere de
     */
    val nestedList = List(List(3, -2, 1), List(4, 5), List(-7, 6))

    val sortedFlatList = nestedList.flatten
        .map(value => math.abs(value))
        .sorted
    //List(1, 2, 3, 4, 5, 6, 7)



    def qsort[T <% Ordered[T]](list: List[T]): List[T] = {
        list match {
            case Nil => Nil
            case x :: xs =>
                val (before, after) = xs partition (_ < x)
                qsort(before) ++ (x :: qsort(after))
        }
    }
}
