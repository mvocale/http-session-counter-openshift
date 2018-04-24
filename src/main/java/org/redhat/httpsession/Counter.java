package org.redhat.httpsession;

import java.io.IOException;
import java.io.Serializable;
import org.jboss.logging.Logger;

public class Counter implements Serializable {

    private static final long serialVersionUID = 6604436849415136871L;

    public static final Logger logger = Logger.getLogger(Counter.class);
    
    private int counter = 0;
    
    public Counter() {
        logger.info("************************");
        logger.info("Counter is created");
        logger.info("************************");
    }
        
    public int getIncrementedValue() {
        return ++this.counter;
    }
    
    private void writeObject(java.io.ObjectOutputStream out) 
            throws IOException {
        logger.info("****************************");
        logger.info("Processing serialization");
        logger.info("Counter = " + this.counter);
        logger.info("****************************");
        out.defaultWriteObject();
    }
    
    private void readObject(java.io.ObjectInputStream in) 
            throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        logger.info("****************************");
        logger.info("Processing Deserialization");
        logger.info("Counter = " + this.counter);
        logger.info("****************************");
    }
}
