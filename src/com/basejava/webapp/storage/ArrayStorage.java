package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;
import java.util.Objects;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int arraySize = 0;

    public void clear() {
        for (Resume r : storage) {
            r = null;
        }
        arraySize = 0;
    }

    public void save(Resume r) {
        storage[arraySize] = r;
        arraySize++;
    }

    public Resume get(String uuid) {
        for (int i = 0; i < arraySize; i++) {
            if (Objects.equals(uuid, storage[i].getUuid())) {
                return storage[i];
            }
        }
        return null;
    }

    public void delete(String uuid) {
        for (int i = 0; i < arraySize; i++) {
            if (Objects.equals(uuid, storage[i].getUuid())) {
                storage[i] = null;
                arraySize = arraySize - 1;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, arraySize);
    }

    public int size() {
        return arraySize;
    }
}
