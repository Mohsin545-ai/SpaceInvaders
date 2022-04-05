package login;

// import login.Model.Database;
// import login.Model.User;
// import login.View.Form;
// import login.View.UserDetails;

import javax.swing.*;
import java.io.File;

public class UserController {
    private Database database;
    private Form form;
    private UserDetails userDetails;

    public UserController(Form form, UserDetails userDetails) {
        this.database = new Database();
        this.form = form;
        this.userDetails = userDetails;

        // submit user


        // load users
        this.form.viewUsers(e -> {
            this.userDetails.getUsers(this.database.loadUsers());
        });
    }
}
