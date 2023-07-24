package com.example;

import java.io.IOException;

import org.jline.reader.History;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

public class App 
{
    public static void main( String[] args )
    {
        try {
            Terminal terminal = TerminalBuilder.terminal();
            LineReader lineReader = LineReaderBuilder.builder()
                    .terminal(terminal)
                    .build();

            // Obtener la historia
            History history = lineReader.getHistory();

            // Mostrar el historial
            for (History.Entry entry : history) {
                System.out.printf(entry.line());
            }

            // Leer comandos
            String line;
            while ((line = lineReader.readLine()) != null) {
                if ("history".equals(line)) {
                    int i = 1;
                    for (History.Entry entry : history) {
                        System.out.printf("[%d] %s\n",i++, entry.line());
                    }
                }

                // Agregar el comando a la historia
                history.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
