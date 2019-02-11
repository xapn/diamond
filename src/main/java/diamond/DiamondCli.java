package diamond;

public class DiamondCli {

    public static void main(String[] args) {
        try {
            System.out.println(Diamond.of(args == null ? null : String.join("", args)));
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
