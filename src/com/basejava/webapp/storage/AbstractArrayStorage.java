package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int arraySize = 0;

    public int size() {
        return arraySize;
    }


    public void clear() {
        Arrays.fill(storage, 0, arraySize, null);
        arraySize = 0;
    }

    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (index > 0) {
            System.out.println("Resume " + r.getUuid() + " already exist");
        } else if (arraySize == STORAGE_LIMIT) {
            System.out.println("Storage full");
        } else {
            insertElement(r, index);
            arraySize++;
        }
    }


    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index < 0) {
            System.out.println("Resume " + r.getUuid() + " not exist");

        } else {
            storage[arraySize] = r;
            arraySize++;
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("Resume " + uuid + " not exist");

        } else {
            fillDeletedElement(index);
            storage[arraySize - 1] = null;
            arraySize--;
        }
    }


    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("Resume " + uuid + " not exist");
            return null;
        }
        return storage[index];
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, arraySize);
    }

    protected abstract void insertElement(Resume r, int index);

    protected abstract void fillDeletedElement(int index);

    protected abstract int getIndex(String uuid);
}
