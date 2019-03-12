package Exceptions;

public class FilaVaziaException extends Exception
{
  private static final long serialVersionUID = 4L;

  public FilaVaziaException(String msg){
    super(msg);
  }

}
