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
        arraySize = 0;
    }

    void save(Resume r) {
                storage[arraySize] = r;
                arraySize++;
    }

    Resume get(String uuid) {
        for (int i  = 0; i < arraySize; i++) {
            if (uuid == storage[i].uuid) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i  = 0; i < arraySize; i++) {
            if (uuid == storage[i].uuid) {
                storage[i] = null;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        for (int i = 0; i < arraySize; i++) {
            return Resume[] resumes = new Resume[i];
                }
    }

    int size() {
        return arraySize;
    }
}
