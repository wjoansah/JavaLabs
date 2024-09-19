package exceptions;

public class exercises {

    public void throwCheckedException() throws CheckedException {
        throw new CheckedException("Throwing checked exception =");
    }

    public void throwUncheckedException() {
        throw new UnCheckedException("Throwing unchecked exception =");
    }

    public static void main(String[] args) {
        exercises ex = new exercises();

        try {
            ex.throwCheckedException();
        } catch (CheckedException e) {
            System.out.println(e.getMessage());
        }

        ex.throwUncheckedException(); // checked at runtime if unhandled crashed the program.
    }

}
