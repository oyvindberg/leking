package leking

import collection.immutable

object MapLeking extends App {

    case class Region(region: String);

    case class Trade(value: Int);

    case class TradeID(brokerId: Int)

    object service {
        def tradesByRegion: Map[Region, Map[TradeID, Trade]] = Map()
    }

    def shouldInclude(o: Any) = o match {
        case r: Region => true
        case brokerId: Int if brokerId > 100000 => true
        case _ => false
    }

    val totalValue: Int = {
        (service.tradesByRegion filterKeys shouldInclude).values.flatten collect {
            case (id, trade) if shouldInclude(id.brokerId) => trade.value
        }
    }.foldLeft(0)((acc, value) => acc + value)

    //-----------------------------------------------------------

    val map: Map[Int, List[Option[String]]] = immutable.Map {
        2 -> List(Some("asd"), Some("asdasd"))
        4 -> List(Some("dsa"), None)
        6 -> List(Some("qwe"), None, Some("wqerwewer"))
    }

    /* hent verdiene fra entrien med høyest indeks */
    println(map.get(map.keys.max).flatten.flatten)
    //List(qwe, wqerwewer)

    //-----------------------------------------------------------


    case class User(username: String, password: String)

    val users: List[Option[User]] = immutable.List(Some(User("Arne", "dsa")),
                                                   Some(User("Bjarne", "asd")),
                                                   Some(User("Charlie", "qwe")),
                                                   None)

    def authenticated(user: String, passwd: String): Boolean = users.flatten.contains(User(user, passwd))

    authenticated("Arne", "dsa") match {
        case true => printf("Arne, er det deg?")
        case false => printf("Hvem der¿")
    }
    //Arne, er det deg?

}
