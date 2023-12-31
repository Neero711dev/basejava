package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int arraySize = 0;

    public int size() {
        return arraySize;
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("Resume "+uuid+" not exist");
            return null;
        }
        return storage[index];
    }

    protected abstract int getIndex(String uuid);
}
