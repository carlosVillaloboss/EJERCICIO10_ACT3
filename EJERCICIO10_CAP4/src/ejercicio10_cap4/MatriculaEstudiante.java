package ejercicio10_cap4;

/**
 * Cierta universidad para liquidar el pago de matrícula de un estudiante le exige los
 * siguientes datos:
 * • Número de inscripción
 * • Nombres
 * • Patrimonio.
 * • Estrato social.
 * La universidad cobra un valor constante para cada estudiante de $50.000. Si el patrimonio
 * es mayor que $2´000.000 y el estrato superior a 3, se le incrementa un porcentaje del 3%
 * sobre el patrimonio. Hacer un algoritmo que muestre:
 * • Número de inscripción.
 * • Nombres.
 * • Pago de matrícula. 
 */
public class MatriculaEstudiante {
    private int inscrip;
    private String nombres;
    private double patrimonio;
    private int estrato;
    
    public MatriculaEstudiante(int inscrip, String nombres, double patrimonio, int estrato) {
        this.inscrip = inscrip;
        this.nombres = nombres;
        this.patrimonio = patrimonio;
        this.estrato = estrato;
    }
    
    public double ValorMatricula() {
        double baseMatricula = 50000;
        double porcentajeIncremento = 0.03; // 3%
        double matricula = baseMatricula;
        
        if (patrimonio > 2000000 && estrato > 3) {
            double incremento = patrimonio * porcentajeIncremento;
            matricula += incremento;
        }
        
        return matricula;
    }
    
    public String MostrarDatos() {
        double pagoMatricula = ValorMatricula();
        return "Número de inscripción: " + inscrip + "\n" +
               "Nombres: " + nombres + "\n" +
               "Pago de matrícula: $" + pagoMatricula;
    }
}
