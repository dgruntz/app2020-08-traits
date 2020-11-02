package ch.mse.app.traits

trait Logger {
  def log(msg: String): Unit
}

trait ConsoleLogger {
  def log(msg: String): Unit = { println(msg) }
}

trait Cloneable {
  protected def clone(): Object
}

class Account(private var bal: Double = 0) {
  val id = Account.newUniqueNumber()
  def deposit(amount: Double): Unit = { bal += amount }
  def balance = bal
}
object Account { // The companion object
  private var lastNumber = 0
  private def newUniqueNumber() = { lastNumber += 1; lastNumber }
}

class LogAccount extends Account with ConsoleLogger {
  override def deposit(amount: Double): Unit = {
    log(s"deposit($amount) called")
    super.deposit(amount)
  }
}

class LogAccount2 extends Account with ConsoleLogger {
  override def deposit(amount: Double): Unit = {
    log(s"deposit($amount) called")
    super.deposit(amount)
  }
  override def log(msg: String): Unit = {
    super.log(s"${java.time.LocalTime.now}: $msg")
  }
}

object Test {
  def main(args: Array[String]): Unit = {
    val a1 = new LogAccount
    a1.deposit(100)

    val a2 = new LogAccount2
    a2.deposit(100)
  }
}


