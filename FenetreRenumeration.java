import javax.swing.*;
import java.awt.*;

public class FenetreRenumeration extends JFrame {
	public FenetreRenumeration() {
		super("Renumération");
		setSize(400, 200);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		add(new JLabel("Interface de renumération"), BorderLayout.CENTER);
	}

}

