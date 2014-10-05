package csc4101;

import java.io.*;

class Quote extends Special {
    private static final String text = "\'";

    @Override
    public String getText() {
        return text;
    }
}
