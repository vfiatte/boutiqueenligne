/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boutiqueenligne.exception;

/**
 *
 * @author valentinfiatte
 */
public class StockInsufisantException extends Exception {

    /**
     * Creates a new instance of <code>StockInsufisantException</code> without
     * detail message.
     */
    public StockInsufisantException() {
    }

    /**
     * Constructs an instance of <code>StockInsufisantException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public StockInsufisantException(String msg) {
        super(msg);
    }
}
