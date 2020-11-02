
package test;
public class Test {
    protected int wrapped;
    
    public Test (final int value){
        this.wrapped = value;
    }
    public int operador_plus(final Test e2){
        return (this.wrapped + e2.wrapped);
    }
}

