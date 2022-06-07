package com.mycompany.swing;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


class Log {
    private DateTimeFormatter dateTimeLog = DateTimeFormatter.ofPattern("[yyyy/MM/dd HH:mm:ss]");
    // Momento para por no nome do arquivo
    private DateTimeFormatter dateTimeName = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private String momentoLog = dateTimeLog.format(LocalDateTime.now());
    private String momentoNomeLog = dateTimeName.format(LocalDateTime.now());
    private String nomeLog = String.format("src/main/resources/%s_Log_TechFood.txt", momentoNomeLog);
    

    public void criarLog(String message){
        try (
            FileWriter criarArquivo = new FileWriter(nomeLog, true);
            BufferedWriter buffer = new BufferedWriter(criarArquivo);
            PrintWriter gravarArq = new PrintWriter(buffer)
            ){
            gravarArq.append(String.format("%s --: %s\n", momentoLog, message));
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
