package gameoflife;

public abstract class CloneableValue<T> implements Value, Cloneable {
    @Override
    public T clone() throws CloneNotSupportedException{
        return (T) super.clone();
    };
}
