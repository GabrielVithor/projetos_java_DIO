package primeiroProjeto.negocio;

import primeiroProjeto.basedados.Banco;
import primeiroProjeto.entidade.Cupom;
import primeiroProjeto.entidade.Pedido;
import primeiroProjeto.entidade.Produto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Classe para manipular a entidade {@link Pedido}.
 * @author thiago leite
 */
public class PedidoNegocio {

    /**
     * {@inheritDoc}.
     */
    private Banco bancoDados;

    /**
     * Construtor.
     * @param banco Banco de dados para ter armazenar e ter acesso os pedidos
     */
    public PedidoNegocio(Banco banco) {
        this.bancoDados = banco;
    }

    private double calcularTotal(List<Produto> produtos, Cupom cupom) {

        double total = 0.0;
        for (Produto produto: produtos) {
            total += produto.calcularFrete();
        }

        if (cupom != null) {
            return  total * (1 - cupom.getDesconto());
        } else {
            return  total;
        }

    }

    /**
     * Salva um novo pedido sem cupom de desconto.
     * @param novoPedido Pedido a ser armazenado
     */
    public void salvar(Pedido novoPedido) {
        salvar(novoPedido, null);
    }

    /**
     * Salva um novo pedido com cupom de desconto.
     * @param novoPedido Pedido a ser armazenado
     * @param cupom Cupom de desconto a ser utilizado
     */
    public void salvar(Pedido novoPedido, Cupom cupom) {

        //Definir padrão código - feito
        //Pegar data do dia corrente
        //Formatar código

        //Setar código no pedido
        //Setar cliente no pedido
        //Calcular e set total
        //Adicionar no banco
        //Mensagem

        String codigo = "PD%04d";
        String dataPedido = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);

        codigo = String.format(codigo, bancoDados.getPedidos().length);

        novoPedido.setCodigo(codigo);

        novoPedido.setCliente(bancoDados.getCliente());

        bancoDados.adicionarPedido(novoPedido);

        novoPedido.setTotal(calcularTotal(novoPedido.getProdutos(),cupom));

        System.out.println("Pedido salvo com sucesso!");
    }

    /**
     * Exclui um pedido a partir de seu código de rastreio.
     * @param codigo Código do pedido
     */
    public void excluir(String codigo) {

        int pedidoExclusao = -1;
        for (int i = 0; i < bancoDados.getPedidos().length; i++) {

            Pedido pedido = bancoDados.getPedidos()[i];
            if (pedido.getCodigo().equals(codigo)) {
                pedidoExclusao = i;
                break;
            }
        }

        if (pedidoExclusao != -1) {
            bancoDados.removerPedido(pedidoExclusao);
            System.out.println("Pedido excluído com sucesso.");
        } else {
            System.out.println("Pedido inexistente.");
        }
    }

    /**
     * Lista todos os pedidos realizados.
     */
    //TODO Método de listar todos os pedidos - feito
    public void listarTodos() {

        if (bancoDados.getPedidos().length == 0) {
            System.out.println("Não existem perdidos cadastrados");
        } else {

            for (Pedido pedido: bancoDados.getPedidos()) {
                System.out.println(pedido.toString());
            }
        }
    }
}
