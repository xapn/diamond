package diamond;

public class DiamondCli {

    public static void main(String[] args) {
        try {
            System.out.println(Diamond.of(args == null ? null : args[0]));
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
