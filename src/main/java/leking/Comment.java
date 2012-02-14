package leking;

class Comment {
    final String text;
    final User user;

    Comment(final String text, final User user) {
        this.text = text;
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "text='" + text + '\'' +
                ", user=" + user +
                '}';
    }
}
