package demo8;

public class Emprunt {
  private Livre livre;
  private Client client;

  public Emprunt(Livre livre, Client client) {
    this.livre = livre;
    this.client = client;
  }

  public Livre getLivre() {
    return livre;
  }

  public Client getClient() {
    return client;
  }
}
