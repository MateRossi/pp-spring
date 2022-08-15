import subsystem1.CrmService;
import subsystem2.CepApi;

public class Facade {

    public void migrarCliente(String nome, String cep) {
        String cidade = CepApi.getInstance().recuperarCidade(cep);
        String estado = CepApi.getInstance().recuperarEstado(cep);

        CrmService.gravarCLiente(nome, cep, estado, cidade);
    }
}
