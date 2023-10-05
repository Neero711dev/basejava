package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;
import java.util.Objects;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private static final int STORAGE_LIMIT = 10000;
    private Resume[] storage = new Resume[STORAGE_LIMIT];
    private int arraySize = 0;

    public void clear() {
        Arrays.fill(storage, 0,arraySize, null);
        arraySize = 0;
    }
    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index == -1) {
            System.out.println("Resume "+r.getUuid()+" not exist");

        }  else {
            storage[arraySize] = r;
            arraySize++;
        }
    }

    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (index != -1) {
            System.out.println("Resume "+r.getUuid()+" already exist");
        } else if (arraySize == storage.length) {
            System.out.println("Storage full");
        } else {
            storage[arraySize] = r;
            arraySize++;
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("Resume "+uuid+" not exist");
            return null;
        }
        return storage[index];
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("Resume "+uuid+" not exist");

        } else {
            storage[index] = storage[arraySize - 1];
            storage[arraySize - 1] = null;
            arraySize--;
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

    private int getIndex(String uuid) {
        for (int i = 0; i < arraySize; i++) {
            if (Objects.equals(uuid, storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}
