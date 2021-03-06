package ch.mse.app.traits.observer

object ObserverTest {

  class Model(private var value: Int) {
    def getValue = value
    def setValue(value: Int) = { this.value = value }
  }

  trait Observer {
    def update(observable: Any): Unit
  }

  class ObservableModel(init: Int) extends Model(init) { // with Observable {

  }

  class Counter extends Observer {
    var counter = 0
    def update(subject: Any) = counter += 1
  }

  def main(args: Array[String]): Unit = {
    val m = new ObservableModel(0)
    val c = new Counter
    // m.addObserver(c)
    m.setValue(3);
    m.setValue(5);
    println(c.counter) // Output: 2, as the counter observer was notified twice
  }

}