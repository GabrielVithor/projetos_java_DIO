package primeiroProjeto.negocio;

import primeiroProjeto.basedados.Banco;
import primeiroProjeto.entidade.Cliente;
import primeiroProjeto.utilidade.LeitoraDados;

import java.util.Optional;

/**
 * Classe para manipular a entidade {@link Cliente}.
 * @author thiago leite
 */
public class ClienteNegocio {

    /**
     * {@inheritDoc}.
     */
    private Banco bancoDados;

    /**
     * Construtor.
     * @param banco Banco de dados para ter acesso aos clientes cadastrados
     */
    public ClienteNegocio(Banco banco) {
        this.bancoDados = banco;
    }

    /**
     * Consulta o cliente pelo seu CPF.
     * @param cpf CPF de um cliente
     * @return O cliente que possuir o CPF passado.
     */
    public Optional<Cliente> consultar(String cpf) {

        if (bancoDados.getCliente().getCpf().equals(cpf)) {
            return Optional.of(bancoDados.getCliente());
        } else {
            return Optional.empty();
        }
    }

    /**
     * Cadastra um novo cliente.
     * @param cliente Novo cliente que terá acesso a aplicação
     */
    //TODO Fazer a inclusão de cliente
    public void cadastrarCliente(Cliente cliente){
        String nome,cpf;

        System.out.println("Digite novamente o cpf do novo usuario:");
        cpf = LeitoraDados.lerDado();
        cliente.setCpf(cpf);

        System.out.println("Digite o nome do novo usuario:");
        nome = LeitoraDados.lerDado();
        cliente.setNome(nome);

        bancoDados.setCliente(cliente);
    }

    /**
     * Exclui um cliente específico.
     * @param cpf CPF do cliente
     */
    //TODO Fazer a exclusão de cliente
    public void excluirCliente(String cpf){
        Optional<Cliente> cliente = consultar(cpf);

        if (cliente.isPresent()){
            String opcao;
            System.out.println("Tem certeza que deseja excluir este cliente? [digite S para confirmar]");
            opcao = LeitoraDados.lerDado().toUpperCase();
            if (opcao.equals("S")){
                bancoDados.setCliente(null);
            }
        }
    }
}
