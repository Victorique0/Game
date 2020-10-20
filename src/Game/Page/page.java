package Game.Page;

import javax.swing.*;
import java.awt.event.KeyEvent;

public abstract class page extends JLayeredPane {
    public abstract void ResponseKeyPress(KeyEvent e);
    public abstract void ResponseKeyRelease(KeyEvent e);
}
