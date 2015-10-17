package com.davidmihal.storagewidget;

import android.os.Environment;
import android.os.StatFs;

import java.text.DecimalFormat;

/**
 * Created by dmihal on 10/17/15.
 */
public class StorageSpace {
    public static long totalMemory()
    {
        StatFs statFs = new StatFs(Environment.getRootDirectory().getAbsolutePath());
        long   total  = (statFs.getBlockCount() * statFs.getBlockSize());
        return total;
    }

    public static long freeMemory()
    {
        StatFs statFs = new StatFs(Environment.getRootDirectory().getAbsolutePath());
        long   free   = (statFs.getAvailableBlocks() * statFs.getBlockSize());
        return free;
    }

    public static long busyMemory()
    {
        StatFs statFs = new StatFs(Environment.getRootDirectory().getAbsolutePath());
        long   total  = (statFs.getBlockCount() * statFs.getBlockSize());
        long   free   = (statFs.getAvailableBlocks() * statFs.getBlockSize());
        long   busy   = total - free;
        return busy;
    }

    public static String percentFree()
    {
        float percent = (float) freeMemory() / totalMemory() * 100;
        return new DecimalFormat("#.##").format(percent) + '%';
    }
}
