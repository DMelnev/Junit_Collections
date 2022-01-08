/**
 * interface Set collection
 *
 * @author Melnev Dmitriy
 * @version 2022-01-04
 */
public interface CarSet<T> extends CarCollection<T> {
    boolean add(T car);

    boolean remove(T car);

    int size();

    void clear();

}
