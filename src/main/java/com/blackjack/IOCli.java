package com.blackjack;

import java.io.PrintStream;
import java.util.Scanner;

public class IOCli {
    private Scanner cliInput;
    private PrintStream cliOutput;

    public IOCli(final Scanner cliInput, final PrintStream cliOutput) {
        this.cliInput = cliInput;
        this.cliOutput = cliOutput;
    }

    public String getInput() {
        return cliInput.nextLine();
    }

    public void println(final String output) {
        cliOutput.println(output);
    }

    public void clearOutput() {
        cliOutput.print("\033\143");
    }
}
