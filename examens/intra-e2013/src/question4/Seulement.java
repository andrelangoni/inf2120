package question4;

@SuppressWarnings("WeakerAccess")
public class Seulement extends PeutEtre {
  private Integer contenu;

  public Seulement(Integer c) {
    contenu = c;
  }

  @Override
  public Integer dePeutEtre(Integer d) {
    return contenu;
  }
}
