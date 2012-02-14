import collection._
import util.Random


object OptionLeking extends App {

    /**
     * Option er Scalas måte å omgå null-problematikken mange andre språk sliter med.
     * Det er en tynn wrapperklasse som blir brukt for å håndtere det på en typesikker måte.
     *
     * En liste som kan inneholde tomme verdier får typen List[ Option[Type] ], mens en hvor alle elementenene
     *  er garantert å være satt får typen List[Type].
     *
     * Option er en abstract klasse med to implementasjoner, None og Some, som betyr hhv. tom verdi og en verdi
     *
     * Option(1) = Some(1)
     * Option(null) = None
     * Some(1) = Some(1)
     *
     **/

    val random: Random = new Random

    def positiveDivide(nom: Int, denom: Int) = denom match {
        case d if d > 0 => Some(nom / d)
        case _ => None
    }

    val randomNums: Seq[Int] = (1 until 10).map(i => random.nextInt(10) - i)
    // Vector(0, 6, 1, 4, 4, -1, 0, -8, -2)

    val resultater = randomNums.map(randomNum => positiveDivide(12, randomNum))
    // Vector(None, Some(2), Some(12), Some(3), Some(3), None, None, None, None)

    resultater.flatten
    // Vector(2, 12, 3, 3)


    /* en mer direkte måte å bruke option på */
    print(positiveDivide(100, 0).getOrElse(12))
    // 12

    /* og den mest direkte */
    print(positiveDivide(100, 0).get)
    // Exception in thread "main" java.util.NoSuchElementException: None.get

}