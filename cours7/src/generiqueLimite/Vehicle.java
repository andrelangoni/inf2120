package generiqueLimite;
/** http://onewebsql.com/blog/generics-extends-super */
class Vehicle extends Machine {
  private int totalValue(Valuer<? super Vehicle> valuer) {
    return valuer.evaluate(this);
  }

  public static void main(String[] args) {
    Valuer<Machine> valuer = new Valuer<>();
    Vehicle vehicle = new Vehicle();
    int value = vehicle.totalValue(valuer);
    System.out.println("Value = " + String.valueOf(value));

    Valuer<Car> valuer2 = new Valuer<>();
    // does not work
    //int value2 = vehicle.totalValue(valuer2);
    // does not work
    //int value3 = vehicle.totalValue(vehicle);
  }
}
