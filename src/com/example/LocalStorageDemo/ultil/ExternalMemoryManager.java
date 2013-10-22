package com.example.LocalStorageDemo.ultil;

import android.os.Environment;

/**
 * User: anhnt
 * Date: 10/22/13
 * Time: 9:39 AM
 */
public class ExternalMemoryManager
{
    public static final int MEMORY_MODE_READ_WRITE = 0;
    public static final int MEMORY_MODE_READ_ONLY = 1;
    public static final int MEMORY_MODE_NOT_READ_WRITE = 2;


    public static int checkExternalMemory()
    {
        String state = Environment.getExternalStorageState();

        if (Environment.MEDIA_MOUNTED.equals(state))
        {
            return MEMORY_MODE_READ_WRITE;
        }
        if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state))
        {
            return MEMORY_MODE_READ_ONLY;
        }
        return MEMORY_MODE_NOT_READ_WRITE;
    }
}
