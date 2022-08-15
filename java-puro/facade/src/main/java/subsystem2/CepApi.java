package subsystem2;

public class CepApi {

    private static CepApi intancia = new CepApi();

    private CepApi(){}

    public static CepApi getInstance() {
        return intancia;
    }

    public String recuperarCidade(String cep) {
        return "Belo Horizonte";
    }

    public String recuperarEstado(String cep) {
        return "Minas Gerais";
    }
}
