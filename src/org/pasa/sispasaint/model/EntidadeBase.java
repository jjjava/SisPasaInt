package org.pasa.sispasaint.model;

import java.io.Serializable;

/**
 *
 * @author Hudson Schumaker
 */
abstract class EntidadeBase implements Serializable {
    private static final long serialVersionUID = 1L;
    protected abstract Long getId();
}
