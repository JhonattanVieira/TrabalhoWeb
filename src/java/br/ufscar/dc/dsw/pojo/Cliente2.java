/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufscar.dc.dsw.pojo;
 
import javax.persistence.Entity;
 
@Entity
public class Cliente2 extends Cliente {
 
    private String cpf;
 
    public String getCpf() {
        return cpf;
    }
 
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}

