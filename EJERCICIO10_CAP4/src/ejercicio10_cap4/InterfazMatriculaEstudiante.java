package ejercicio10_cap4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazMatriculaEstudiante {

    private JFrame frame;
    private JTextField txtInscripcion;
    private JTextField txtNombres;
    private JTextField txtPatrimonio;
    private JTextField txtEstrato;
    private JTextArea txtOutput;

    public InterfazMatriculaEstudiante() {
        // Crear la ventana principal
        frame = new JFrame("Calculadora de Matrícula de Estudiante");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(6, 2, 10, 10));

        // Crear componentes
        JLabel lblInscripcion = new JLabel("Número de inscripción:");
        JLabel lblNombres = new JLabel("Nombres:");
        JLabel lblPatrimonio = new JLabel("Patrimonio:");
        JLabel lblEstrato = new JLabel("Estrato social:");

        txtInscripcion = new JTextField();
        txtNombres = new JTextField();
        txtPatrimonio = new JTextField();
        txtEstrato = new JTextField();

        JButton btnCalcular = new JButton("Calcular y Mostrar");
        txtOutput = new JTextArea();
        txtOutput.setEditable(false);

        // Agregar componentes al panel
        frame.add(lblInscripcion);
        frame.add(txtInscripcion);
        frame.add(lblNombres);
        frame.add(txtNombres);
        frame.add(lblPatrimonio);
        frame.add(txtPatrimonio);
        frame.add(lblEstrato);
        frame.add(txtEstrato);
        frame.add(new JLabel()); // Espacio vacío
        frame.add(btnCalcular);
        frame.add(new JLabel()); // Espacio vacío
        frame.add(new JScrollPane(txtOutput));

        // Configurar acción del botón
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularYMostrar();
            }
        });

        // Mostrar la ventana
        frame.setVisible(true);
    }

    private void calcularYMostrar() {
        try {
            // Leer datos de los campos de texto
            int inscripcion = Integer.parseInt(txtInscripcion.getText());
            String nombres = txtNombres.getText();
            double patrimonio = Double.parseDouble(txtPatrimonio.getText());
            int estrato = Integer.parseInt(txtEstrato.getText());

            // Crear un objeto MatriculaEstudiante
            MatriculaEstudiante estudiante = new MatriculaEstudiante(inscripcion, nombres, patrimonio, estrato);

            // Mostrar resultados
            txtOutput.setText(estudiante.MostrarDatos());

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Por favor, ingrese datos válidos.",
                                          "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InterfazMatriculaEstudiante());
    }
}
