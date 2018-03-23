package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.MigracionesDictamenes;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class index extends JFrame {

	private JPanel contentPane;
	private JTextField txtRuta;
	private JButton btnCargar;
	private JProgressBar progressBar;
	public String rutaExcel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
					index frame = new index();
					frame.setVisible(true);
					
						
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public index() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 254);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		txtRuta = new JTextField();
		txtRuta.setBounds(10, 93, 483, 20);
		panel.add(txtRuta);
		txtRuta.setColumns(10);

		btnCargar = new JButton("Cargar");
		btnCargar.setMnemonic('c');
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cargarBaseDatos();

			}
		});
		btnCargar.setBounds(503, 92, 89, 23);
		panel.add(btnCargar);

		progressBar = new JProgressBar();
		progressBar.setBounds(10, 180, 582, 14);
		panel.add(progressBar);

		JLabel lblD = new JLabel("Migraci\u00F3n Dict\u00E1menes");
		lblD.setFont(new Font("Tahoma", Font.BOLD, 29));
		lblD.setHorizontalAlignment(SwingConstants.CENTER);
		lblD.setBounds(10, 26, 582, 44);
		panel.add(lblD);

		JButton btnImportar = new JButton("Importar");
		btnImportar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MigracionesDictamenes migracion = new MigracionesDictamenes(progressBar, rutaExcel);
				migracion.execute();
			}
		});
		btnImportar.setMnemonic('i');
		btnImportar.setBounds(278, 146, 89, 23);
		panel.add(btnImportar);
	}

	public void cargarBaseDatos() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		 fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Excel", "xlsx","xlsm","xltx","xltx"));
		int result = fileChooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			rutaExcel = selectedFile.getAbsolutePath();
			txtRuta.setText(rutaExcel);
		}
	}

}
