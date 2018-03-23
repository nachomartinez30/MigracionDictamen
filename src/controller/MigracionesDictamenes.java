package controller;

import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

public class MigracionesDictamenes extends SwingWorker<Integer, String> {

	JProgressBar progressBar;
	String rutaExcel;

	public MigracionesDictamenes(JProgressBar progressBar, String rutaExcel) {
		super();
		this.progressBar = progressBar;
		this.rutaExcel = rutaExcel;
	}

	@Override
	protected Integer doInBackground() throws Exception {
		System.out.println("migrando a "+rutaExcel);
		return null;
	}

	public void migrarDictamenesTecnicos() {
		/* conexion a la base de datos */
		/* conexion al archivo excel */
		/* extraxion de datos a variables */
		/* insercion de datos en base de datos */
	}

}
