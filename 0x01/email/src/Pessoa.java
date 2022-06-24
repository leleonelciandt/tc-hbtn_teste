public class Pessoa {

    public static boolean emailValid(String email){
       if (email.length() > 50 && email.startsWith("@")){
       return true;
       }
       return false;
    }


}
