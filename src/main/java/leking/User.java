package leking;

class User {
    final String username, name, email;
    final int id;
    final UserType userType;

    User(final String username, final String name, final int id, final UserType userType, final String email) {
        this.username = username;
        this.name = name;
        this.id = id;
        this.userType = userType;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final User user = (User) o;

        if (username != null ? !username.equals(user.username) : user.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return username != null ? username.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + name + '\'' +
                ", email='" + email + '\'' +
                ", id=" + id +
                ", userType=" + userType +
                '}';
    }
}
