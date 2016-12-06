package demo8;

import java.util.ArrayList;

public class Bibliotheque {
  private ArrayList<Client> clients;
  private ArrayList<Livre> livres;
  private ArrayList<Emprunt> emprunts;
  public static final long LIMITE_PAR_CLIENT = 5;

  public Bibliotheque() {
    clients = new ArrayList<>();
    livres = new ArrayList<>();
    emprunts = new ArrayList<>();
  }

  public boolean estEmprunte(Livre livre) {
  /*  boolean emprunte = false;
      for (int i = 0; (i < emprunts.size()) && !emprunte ; ++i) {
        Emprunt emprunt = emprunts.get(i);
        if (emprunt.getLivre().equals(livre)) {
          emprunte = true;
        }
      }
      return emprunte; */

    return emprunts.stream().anyMatch(emprunt -> emprunt.getLivre().equals(livre));
  }

  public long nombreEmprunt(Client client) {
    return emprunts.stream().filter(emprunt -> emprunt.getClient().equals(client)).count();
  }

  public void emprunter(Client client, Livre livre) throws LivreDejaEmprunte, ClientAtteintLimite {
    // validation de l'emprunt
    if (estEmprunte(livre))
      throw new LivreDejaEmprunte();
    if (nombreEmprunt(client) >= LIMITE_PAR_CLIENT)
      throw new ClientAtteintLimite();
    // ajout de l'emprunt
    emprunts.add(new Emprunt(livre, client));
  }
} // Bibliotheque