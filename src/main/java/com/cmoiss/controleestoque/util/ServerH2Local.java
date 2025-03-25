package com.cmoiss.controleestoque.util;

import org.h2.tools.Server;

public final class ServerH2Local {
    private static Server h2Server;

    // Construtor privado para evitar instanciamento
    private ServerH2Local() {
        throw new UnsupportedOperationException("Esta classe não pode ser instanciada");
    }

    // Métodos estáticos
    public static void startServer() {
        // Inicia o servidor web do H2 (console)
        try {
            h2Server = Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8080").start();
            System.out.println("Console H2 em: http://localhost:8080");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void stopServer() {
        // Implementação para parar o servidor H2
        // Garante que o servidor será fechado ao encerrar a aplicação
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if (h2Server != null) {
                h2Server.stop(); // Encerra o servidor
                System.out.println("Servidor H2 encerrado.");
            }
        }));
    }
}