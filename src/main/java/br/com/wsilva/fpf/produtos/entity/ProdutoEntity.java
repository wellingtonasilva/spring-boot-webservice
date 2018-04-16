package br.com.wsilva.fpf.produtos.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "fpf_produto", schema = "public")
public class ProdutoEntity implements Serializable
{
    @Id
    @Column(name="prod_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @Column(name="prod_dsproduto")
    private String descricao;

    @Column(name="prod_dtcompra")
    //@Temporal(TemporalType.TIMESTAMP)
    private String dataCompra;

    @Column(name="prod_vlpreco")
    private String precoUnitario;

    @ManyToOne
    @JoinColumn(name="orig_id")
    private OrigemEntity origem;

    @ManyToOne
    @JoinColumn(name="cate_id")
    private CategoriaEntity categoria;

    public ProdutoEntity() {
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(String dataCompra) {
        this.dataCompra = dataCompra;
    }

    public String getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(String precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public OrigemEntity getOrigem() {
        return origem;
    }

    public void setOrigem(OrigemEntity origem) {
        this.origem = origem;
    }

    public CategoriaEntity getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEntity categoria) {
        this.categoria = categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdutoEntity that = (ProdutoEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(descricao, that.descricao) &&
                Objects.equals(dataCompra, that.dataCompra) &&
                Objects.equals(precoUnitario, that.precoUnitario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, dataCompra, precoUnitario);
    }
}
