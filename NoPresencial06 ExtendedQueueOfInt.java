package es.ulpgc.eii.containers.bounded;

/*  Aitor Ventura Delgado
    30.03.2019
 */

public class ExtendedQueueOfInt extends QueueOfInt
    implements Comparable<QueueOfInt>, Cloneable {

    public ExtendedQueueOfInt(int bound) {
        super(bound);
    }
    
    @Override
    public int compareTo(QueueOfInt arg0) {
        if (arg0 instanceof ExtendedQueueOfInt){
            ExtendedQueueOfInt a = (ExtendedQueueOfInt) arg0;
            int e = a.front;
            for (int i = front; i <= rear && e <= a.count(); i++){
                if (data[i] > a.data[e]){
                    return -1;
                }
                
                if (data[i] < a.data[e]){
                    return 1;
                }
                e++;
            }
            if (count() > a.count()){
                return -1;
            } else if (count() < a.count()){
                return 1;
            } else {
                return 0;
            }
        }
        return 0;
    }

    @Override
    public boolean equals(Object arg0) {
        //Creamos la cola arg
        QueueOfInt arg;
        
        //Si arg0 es del tipo QueueOfInt
        if (arg0 instanceof QueueOfInt){
            //Convertimos arg0 en una cola y será arg
            arg = (QueueOfInt) arg0;
            
            //Si tienen el mismo número de elementos, vemos si son iguales o no
            if (this.count() == arg.count()){
                for (int i = 0; i < this.count(); i++){
                    if (this.data[front+i] != arg.data[arg.front+i]){
                        return false;
                    }
                }
                return true;
            }
            return false;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        //Caso nulo
        if (this.count() == 0){
            return "<<";
        }
        
        //Caso no nulo
        String res = "<";
        for (int i = 0; i < this.count(); i++){
            //Si no estamos en la última posición, pondremos "-"
            if (i != this.count()-1){
                res = res + this.data[front+i] + "-";
            //Si lo estamos, pondremos "<";
            } else {
                res = res + this.data[front+i] + "<";
            }
        }
        return res;
    }
    
    @Override
    public ExtendedQueueOfInt clone() {
        try {
            ExtendedQueueOfInt clon = (ExtendedQueueOfInt) super.clone();
            clon.data = data.clone();
            return clon;
            
        //Si existe una excepción, lo cogemos y devolvemos null
        } catch(CloneNotSupportedException e){
            return null;
        }
    }
}
