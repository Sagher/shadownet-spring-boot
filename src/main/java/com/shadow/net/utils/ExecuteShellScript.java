package com.shadow.net.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExecuteShellScript {

    public void blockIP(String ip) {

        try {
            String s = ip;
            String[] a = new String[]{"/bin/bash", "-c", "iptables -I INPUT -s" + s + " -j DROP"};

            Process proc = new ProcessBuilder(a).start();

            System.out.println(s + " has been blocked");
            String line;
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
        } catch (IOException ex) {
            Logger.getLogger(ExecuteShellScript.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void unblockIP(String ip) {

        try {
            String s = ip;
            String[] a = new String[]{"/bin/bash", "-c", "iptables -D INPUT -s" + s + " -j DROP"};

            Process proc = new ProcessBuilder(a).start();

            System.out.println(s + " has been Un-blocked");
            String line;
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
        } catch (IOException ex) {
            Logger.getLogger(ExecuteShellScript.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
