package cadastro;

public class Cadastro {
    int id;
    String email, password;

    public Cadastro(){}

    public Cadastro(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return  "Id: " + id +
                "\nEmail: " + email +
                "\nPassword: " + password +
                "\n\n";
    }
}
