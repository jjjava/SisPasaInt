/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pasa.sispasaint.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author hudson schumaker
 */

@Entity
@PrimaryKeyJoinColumn(name="ID_PESSOA")
public class Beneficiario extends Pessoa {
    
}
