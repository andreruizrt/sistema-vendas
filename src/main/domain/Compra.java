package main.domain;

import java.sql.Timestamp;

public class Compra extends Controle {
    private int idFornecedor;
    private Timestamp dtCompra;

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public Timestamp getDtCompra() {
        return dtCompra;
    }

    public void setDtCompra(Timestamp dtCompra) {
        this.dtCompra = dtCompra;
    }
}
