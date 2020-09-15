package com.example.demo;


import javax.lang.model.SourceVersion;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Set;

import sun.jvm.hotspot.runtime.*;

import sun.jvm.hotspot.tools.Tool;

public class SysPropsDumper   extends Tool {

    public void run() {
        Properties sysProps = VM.getVM().getSystemProperties();
        PrintStream out = System.out;
        if (sysProps != null) {
            Enumeration keys = sysProps.keys();
            while (keys.hasMoreElements()) {
                Object key = keys.nextElement();
                out.print(key);
                out.print(" = ");
                out.println(sysProps.get(key));
            }
        } else {
            out.println("System Properties info not available!");
        }
    }

    public static void main(String[] args) {
     /*   SysPropsDumper pd = new SysPropsDumper();
        pd.start(args);
*/
        args=new String[1];
        args[0]="36996";
        new SysPropsDumper().execute(args);
    }
}
