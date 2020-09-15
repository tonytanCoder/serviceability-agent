package com.example.demo;

import sun.jvm.hotspot.runtime.VM;
import sun.jvm.hotspot.tools.Tool;

public class MyTool extends Tool {

    @Override
    public void run() {
        VM.getVM().getSystemDictionary()
                .classesDo((klass, loader) -> {
                    String className = klass.getName().asString();
                    System.out.print(className);

                    String loaderName = (loader == null)
                            ? "Bootstrap ClassLoader"
                            : loader.getKlass().getName().asString();
                    System.out.println(" loaded by " + loaderName);
                });

        System.out.println(VM.getVM().getCPU());
    }

    public static void main(String[] args) {
        args=new String[1];
        args[0]="6336";
        new MyTool().execute(args);
    }
}