public class Cliente {
    public String nome;
    public String id;
    public String telefone;
    public String email;

    public Cliente(String nome, String id, String telefone, String email) {
        this.nome = nome;
        this.id = id;
        this.telefone = telefone;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("Cliente: %s | ID: %s | Email: %s | Telefone: %s", nome, id, email, telefone);
    }
}
