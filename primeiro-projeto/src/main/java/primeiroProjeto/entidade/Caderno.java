package primeiroProjeto.entidade;

import primeiroProjeto.entidade.constantes.Materias;

public class Caderno extends Produto{
        Materias tipo;

    public Materias getTipo() {
        return tipo;
    }

    public void setTipo(Materias tipo) {
        this.tipo = tipo;
    }

    @Override
    public double calcularFrete() {
        return (getPreco() * getQuantidade() + tipo.getFator());
    }

    @Override
    public String toString() {
        return "Caderno{" +
                "tipo=" + tipo +
                '}';
    }
}
