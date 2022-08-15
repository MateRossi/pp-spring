package subsystem1;

public class CrmService {

    private CrmService(){}

    public static void gravarCLiente(String nome, String cep, String estado, String cidade) {
        System.out.println("Cliente salvo no sistema de crm.");
        System.out.println(nome);
        System.out.println(cep);
        System.out.println(estado);
        System.out.println(cidade);
    }
}
