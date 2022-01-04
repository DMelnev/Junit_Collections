/**
 * interface Set collection
 *
 * @author Melnev Dmitriy
 * @version 2022-01-04
 */
public interface CarSet extends CarCollection {
    boolean add(Car car);

    boolean remove(Car car);

    int size();

    void clear();

}
