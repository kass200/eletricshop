public abstract class Mercadoria(){
    private int codigo;
    private String nome;
    private double preço;
    private double desconto;


public Mercadoria(int codigo, String nome, double preço, double desconto){
    this.codigo = codigo;
    this.nome = nome;
    this.preço = preço;
    this.desconto = desconto;
} 
public getCodigo(){
    return codigo;
}
public void setCodigo(int codigo){
    this.codigo = codigo
}
public getNome(){
    return nome;
}
public void setNome(String nome){
    this.nome = nome
}
public getPreço(){
    return preço;
}
public void setPreço(double preço){
    this.preço = preço;
}
public getDesconto(){
    return desconto;
}
public void setDesconto(double desconto){
    this.desconto = desconto;
}

public abstract double preço_a_vista();

}