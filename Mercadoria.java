import java.util.Scanner;
import java.util.ArrayList;


// questão 1
public abstract class Mercadoria {
    private int codigo;
    private String nome;
    private double preco;
    private double desconto;

    public Mercadoria(int codigo, String nome, double preco, double desconto) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.desconto = desconto;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public abstract double preco_a_vista();
}

// questão 2
class Celular extends Mercadoria {
    public Celular(int codigo, String nome, double preco, double desconto) {
        super(codigo, nome, preco, desconto);
    }

    public double preco_a_vista() {
        return getPreco() - (getPreco() * getDesconto() / 100);
    }
}

// questão 3
class Computador extends Mercadoria {
    private String configuracao;

    public Computador(int codigo, String nome, double preco, String configuracao) {
        super(codigo, nome, preco, 10.0);
        this.configuracao = configuracao;
    }

    public String getConfiguracao() {
        return configuracao;
    }

    public void setConfiguracao(String configuracao) {
        this.configuracao = configuracao;
    }

    public double preco_a_vista() {
        return getPreco() - (getPreco() * 0.1);
    }
}

// questão 4
class Carrinho {
    private int codigoCliente;
    private String nomeCliente;
    private ArrayList<Mercadoria> mercadorias;

    public Carrinho(int codigoCliente, String nomeCliente) {
        this.codigoCliente = codigoCliente;
        this.nomeCliente = nomeCliente;
        this.mercadorias = new ArrayList<>();
    }

    public Mercadoria procurar(int codigo) {
        for (Mercadoria m : mercadorias) {
            if (m.getCodigo() == codigo) {
                return m;
            }
        }
        return null;
    }

    public void cadastrar(Mercadoria m) {
        if (m == null) {
            System.out.println("Erro: mercadoria nula");
        } else {
            mercadorias.add(m);
            System.out.println("Mercadoria cadastrada");
        }
    }

    public void remover(Mercadoria m) {
        if (m == null) {
            System.out.println("Erro: mercadoria nula");
        } else if (!mercadorias.remove(m)) {
            System.out.println("Erro: mercadoria não encontrada");
        } else {
            System.out.println("Mercadoria removida com sucesso");
        }
    }

    public void conteudo() {
        if (mercadorias.isEmpty()) {
            System.out.println("Carrinho vazio");
            return;
        }
        double total = 0;
        for (Mercadoria m : mercadorias) {
            System.out.println("Codigo:" + m.getCodigo() + " Nome:" + m.getNome() + " Preço:" + m.getPreco());
            total += m.getPreco();
        }
        System.out.println("Total de itens:" + mercadorias.size());
        System.out.println("Preço total:" + total);
    }
}

// questão 6
class Produto {
    private int codigo;
    private String nome;
    private double preco;

    public Produto(int codigo, String nome, double preco) {
        if (codigo <= 0 || nome.isEmpty() || preco < 0) {
            throw new IllegalArgumentException("Parâmetros inválidos");
        }
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        if (codigo <= 0) {
            throw new IllegalArgumentException("Código inválido");
        }
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome inválido");
        }
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco < 0) {
            throw new IllegalArgumentException("Preço inválido");
        }
        this.preco = preco;
    }
}
