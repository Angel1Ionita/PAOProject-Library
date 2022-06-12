package com.library.io;

import java.io.*;
import java.util.Date;

public class Audit {
    private static final File file = new File("src/main/java/com/library/database/Audit.csv");
    public static PrintWriter auditFile;

    static {
        try {
            boolean newFile=file.createNewFile();
            auditFile = new PrintWriter(new FileOutputStream(file, true));
            if (newFile) {
                auditFile.println("functionName,timestamp");
                auditFile.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void logFunctionCall(String functionName) {
        auditFile.append(functionName)
                .append(",")
                .append(String.valueOf(new Date()))
                .append("\n");
        auditFile.flush();
    }

}

