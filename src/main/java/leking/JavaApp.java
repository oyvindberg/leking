package leking;

public class JavaApp {

    public static void main(final String[] args) {
        final UserService userService = new UserService();
        System.out.println("userService.getAllComments() = " + userService.getAllComments());
        System.out.println("userService.getAllUsers() = " + userService.getAllUsers());
        System.out.println("userService.displayUsersSortedByNumberOfComments() = " + userService.displayUsersSortedByNumberOfComments());
        System.out.println("userService.findAllModerators() = " + userService.findAllModerators());
    }
}

