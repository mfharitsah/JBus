package muhammadFahishHaritsahJBusAF;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Algorithm {

    private Algorithm() {

    }

    public static <T> boolean exists(Iterator<T> iterator, Predicate<T> pred) {
        while (iterator.hasNext()) {
            T current = iterator.next();
            if (pred.predicate(current))
                return true;
        }
        return false;
    }

    public static <T> boolean exists(Iterator<T> iterator, T value) {
        final Predicate<T> pred = value::equals;
        return exists(iterator, pred);
    }

    public static <T> boolean exists(Iterable<T> iterable, Predicate<T> pred) {
        final Iterator<T> it = iterable.iterator();
        return exists(it, pred);
    }

    public static <T> boolean exists(Iterable<T> iterable, T value) {
        final Iterator<T> it = iterable.iterator();
        return exists(it, value);
    }

    public static <T> boolean exists(T[] arrT, T value) {
        final Iterator<T> it = Arrays.stream(arrT).iterator();
        return exists(it, value);
    }

    public static <T> boolean exists(T[] arrT, Predicate<T> pred) {
        final Iterator<T> it = Arrays.stream(arrT).iterator();
        return exists(it, pred);
    }

    public static <T> int count(Iterator<T> iterator, T value) {
        final Predicate<T> pred = value::equals;
        return count(iterator, pred);
    }

    public static <T> int count(T[] arrT, T value) {
        final Iterator<T> it = Arrays.stream(arrT).iterator();
        return count(it, value);
    }

    public static <T> int count(T[] arrT, Predicate<T> pred) {
        final Iterator<T> it = Arrays.stream(arrT).iterator();
        return count(it, pred);
    }

    public static <T> int count(Iterable<T> iterable, T value) {
        final Iterator<T> it = iterable.iterator();
        return count(it, value);
    }

    public static <T> int count(Iterable<T> iterable, Predicate<T> pred) {
        final Iterator<T> it = iterable.iterator();
        return count(it, pred);
    }

    public static <T> int count(Iterator<T> iterator, Predicate<T> pred) {
        int i = 0;
        while (iterator.hasNext()){
            T current = iterator.next();
            if(pred.predicate(current))
                i++;
        }
        return i;
    }

    public static <T> List<T> collect(Iterable<T> iterable, Predicate<T> pred) {
        final Iterator<T> it = iterable.iterator();
        return collect(it, pred);
    }

    public static <T> List<T> collect(Iterable<T> iterable, T value) {
        final Iterator<T> it = iterable.iterator();
        return collect(it, value);
    }

    public static <T> List<T> collect(T[] arrT, T value) {
        final Iterator<T> it = Arrays.stream(arrT).iterator();
        return collect(it, value);
    }

    public static <T> List<T> collect(T[] arrT, Predicate<T> pred) {
        final Iterator<T> it = Arrays.stream(arrT).iterator();
        return collect(it, pred);
    }

    public static <T> List<T> collect(Iterator<T> iterator, T value) {
        final Predicate<T> pred = value::equals;
        return collect(iterator, pred);
    }

    public static <T> List<T> collect(Iterator<T> iterator, Predicate<T> pred) {
        List<T> listArray = new ArrayList<>();
        while(iterator.hasNext()) {
            T current = iterator.next();
            if (pred.predicate(current)) {
                listArray.add(current);
            }

        }
        return listArray;
    }

    public static <T> T find(T[] arrT, T value) {
        final Iterator<T> it = Arrays.stream(arrT).iterator();
        return find(it, value);
    }

    public static <T> T find(T[] arrT, Predicate<T> pred) {
        final Iterator<T> it = Arrays.stream(arrT).iterator();
        return find(it, pred);
    }

    public static <T> T find(Iterable<T> iterable, T value) {
        final Iterator<T> it = iterable.iterator();
        return find(it, value);
    }

    public static <T> T find(Iterable<T> iterable, Predicate<T> pred){
        final Iterator<T> it = iterable.iterator();
        return find(it, pred);
    }

    public static <T> T find(Iterator<T> iterator, T value) {
        final Predicate<T> pred = value::equals;
        return find(iterator, pred);
    }

    public static <T> T find(Iterator<T> iterator, Predicate<T> pred) {
        while (iterator.hasNext()){
            T current = iterator.next();
            if (pred.predicate(current))
                return current;
        }
        return null;
    }

    public static <T> List<T> paginate(T[] arrT, int page, int pageSize, Predicate <T> pred){
        final Iterator<T> it = Arrays.stream(arrT).iterator();
        return paginate(it, page, pageSize, pred);
    }

    public static <T> List<T> paginate(Iterable <T> iterable, int page, int pageSize, Predicate <T> pred){
        final Iterator<T> it = iterable.iterator();
        return paginate(it, page, pageSize, pred);
    }

    public static <T> List<T> paginate(Iterator<T> iterator, int page, int pageSize, Predicate<T> pred){
        List<T> pageArray = new ArrayList<>();

        int i = 0;
        T current;

        while (iterator.hasNext() && pageArray.size() < page){
            if ((i < ((page + 1) * pageSize)) && (i > (page * pageSize))){
                current = iterator.next();
                pageArray.add(current);
                i++;
            } else {
                i++;
                current = iterator.next();
            }
        }
        return pageArray;
    }
}