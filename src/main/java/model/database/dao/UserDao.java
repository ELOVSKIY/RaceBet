package model.database.dao;

import com.sun.istack.internal.NotNull;
import entities.User;

public interface UserDao {

    void updateUser(final long userId,
                    @NotNull final User user);

    void registerUser(final User user);

    User getUserById(final User user);
}
