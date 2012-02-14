package leking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UserService {

    private final User admin = new User("asd", "dsa", 1, UserType.ADMIN, "asd@dsa.no");
    private static final User mod = new User("ewq", "qwe", 2, UserType.MODERATOR, "asd2@dsa.no");
    private final User user1 = new User("zxc", "cxz", 3, UserType.NORMAL, "asd3@dsa.no");
    private final User user2 = new User("xcv", "csz", 4, UserType.NORMAL, "asd4@dsa.no");

    final List<User> users = new ArrayList<User>() {{
        add(admin);
        add(mod);
        add(user1);
        add(user2);
    }};

    final List<Comment> comments = new ArrayList<Comment>() {{
        add(new Comment("asdasd", admin));
        add(new Comment("dsasadasd", mod));
        add(new Comment("rtyutyu", user1));
        add(new Comment("poipp", user2));
        add(new Comment("poipasdp", user2));
        add(new Comment("poipasdasdp", user2));
    }};

    public List<User> getAllUsers() {
        return users;
    }

    public List<Comment> getAllComments() {
        return comments;
    }

    public List<Comment> findAllCommentsByUser(final User u) {
        final List<Comment> allComments = getAllComments();
        final List<Comment> ret = new ArrayList<Comment>();

        for (final Comment comment : allComments) {
            if (comment.user.equals(u)) {
                ret.add(comment);
            }
        }
        return ret;
    }

    public List<User> findAllUsersWhoHaveMadeComment(){
        final List<User> allUsers = getAllUsers();
        final List<Comment> allComments = getAllComments();

        final List<User> ret = new ArrayList<User>(allUsers.size());

        for (final User user : allUsers) {
            boolean found = false;
            for (final Comment comment : allComments) {
                if (comment.user.equals(user)){
                    found = true;
                    break;
                }
            }
            if (found){
                ret.add(user);
            }
        }
        return ret;
    }

    public List<User> findAllModerators(){
        final List<User> allUsers = getAllUsers();
        final List<User> moderators = new ArrayList<User>();
        for (final User user : allUsers) {
            if (user.getUserType() == UserType.MODERATOR){
                moderators.add(user);
            }
        }
        return moderators;
    }

    public List<String> displayUsersSortedByNumberOfComments(){
        final List<User> allUsers = getAllUsers();

        /* sort by number of posts */
        Collections.sort(allUsers, new Comparator<User>() {
            @Override
            public int compare(final User o1, final User o2) {
                return Integer.valueOf(findAllCommentsByUser(o2).size()).compareTo(findAllCommentsByUser(o1).size());
            }
        });

        final List<String> ret = new ArrayList<String>();

        for (final User user : allUsers) {
            final StringBuffer sb = new StringBuffer();
            sb.append(user.getName());

            if (UserType.NORMAL != user.getUserType()){
                sb.append(' ').append(user.getEmail()).append(' ');
            }

            sb.append('(').append(findAllCommentsByUser(user).size()).append(" comments)");
            ret.add(sb.toString());
        }
        return ret;
    }
}
