package abr;

public class ElementIntrouvableException extends Exception {
  public static final String MSG_INTROUVABLE = "Element introuvable";
  @Override
  public String getMessage() {
    return MSG_INTROUVABLE;
  } // getMessage()
}
