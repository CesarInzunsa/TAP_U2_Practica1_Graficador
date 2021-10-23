
import java.awt.Color;
import java.io.Serializable;
import javax.swing.JFrame;
/**
 *
 * @author cesar
 */
public class GraficadorDeBarras extends javax.swing.JPanel implements Serializable {

    /**
     * Diseña un componente en java que permita que pasándole 3 vectores como parámetros permita la graficación
     * de valores mediante gráfico de barras. El 1er vector tendrá los títulos de X, el 2do vector tendrá los
     * títulos de Y y el 3er vector tendrá los valores a graficar. Se podrá elegir entre colores de barras y
     * el valor máximo para Y.
     */
    
    private Lienzo objeto = new Lienzo();
    
    public void settyMax(int yMax){
        objeto.setyMax(yMax);
    }
    
    public int gettyMax(){
        return objeto.getyMax();
    }

    public void setTitulosX(String[] titulosX){
        objeto.setTitulosX(titulosX);
    }

    public String[] getTitulosX(){
        return objeto.getTitulosX();
    }
    
    public void setTitulosY(String[] titulosY){
        objeto.setTitulosY(titulosY);
    }

    public String[] getTitulosY(){
        return objeto.getTitulosY();
    }
    
    public void settValores(int[] valores){
        objeto.setValores(valores);
    }
    
    public int[] gettValores(){
        return objeto.getValores();
    }
    
    public void settColor(Color color){
        objeto.setColor(color);
    }
    
    public Color gettColor(){
        return objeto.getColor();
    }
    
    public void setTipoTitulo(Lienzo.tipoTitulo tipo){
        objeto.setTipoTitulo(tipo);
    }
    
    public Lienzo.tipoTitulo getTipoTitulo(){
        return objeto.getTipoTitulo();
    }
    
    public GraficadorDeBarras() {
        initComponents();
        objeto.setSize(400,300);
        objeto.setLocation(0,0);
        this.add(objeto);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
