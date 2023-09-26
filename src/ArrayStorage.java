/**
 * Array based storage for Resumes
 */
public class  ArrayStorage {
    Resume[] storage = new Resume[10000];
    int arraySize = 0;
    void clear() {
        for (Resume r : storage) {
            r = null;
        }
    }

    void save(Resume r) {
        arraySize = arraySize + 1;
        storage[arraySize] = r;
    }

    Resume get(String uuid) {
        return null;
    }

    void delete(String uuid) {
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return new Resume[0];
    }

    int size() {
        return arraySize;
    }
}
