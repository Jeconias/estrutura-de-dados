package Exceptions;

public class ElementoNaoEncontradoException extends Exception
{
  private static final long serialVersionUID = 8L;

  public ElementoNaoEncontradoException(String msg){
    super(msg);
  }

}
