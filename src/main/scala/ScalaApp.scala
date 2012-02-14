import leking.{UserType, User, Comment, UserService}
import scalaj.collection.Imports._
import collection.Seq
import collection.immutable.{List, Map}

object ScalaApp extends App {

  val userService: UserService = new UserService

  def displayUsersSortedByNumberOfComments() = {
    val comments: Seq[Comment] = userService.getAllComments.asScala

    val groupedComments: Map[User, Seq[Comment]] = comments.groupBy(c => c.getUser)

    val usersWithCount: List[(User, Int)] = groupedComments.map {
      case (u, comments) => (u, comments.size)
    }.toList;

    val sortedByCommentNum: List[(User, Int)] = usersWithCount.sortBy {
      case (u, commentNum) => -commentNum //minus because we want descending
    }

    sortedByCommentNum.map {
      case (u, commentNum) => u.getName + {
        u.getUserType match {
          case UserType.NORMAL => ""
          case _ => " " + u.getEmail + " "
        }
      } + " (" + commentNum + " comments)"
    }
  }

  def findAllUsersWhoHaveMadeComment:Set[User] = {
    userService.getAllComments.asScala.map(c => c.getUser).toSet
  }
  
  
  displayUsersSortedByNumberOfComments().foreach(println)
  println("---")
  findAllUsersWhoHaveMadeComment.foreach(println)
}
